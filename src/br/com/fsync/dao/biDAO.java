package br.com.fsync.dao;

import br.com.fsync.objetos.Mov;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.conexao.CriaConexaoLandaBI;
import br.com.fsync.objetos.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marcus
 */
public class biDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLandA_BI;
    private Connection conexaoLandA;

    // Construtor da classe VendaDao
    public biDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA_BI = CriaConexaoLandaBI.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }

    public List<Mov> listaCompras(Date dataI, Date dataF) {
        try {
            String sql = "SELECT "
                    + "b.filial, "
                    + "b.dentre, "
                    + "a.codiprod, "
                    + "a.descprod, "
                    + "c.nlab, "
                    + "c.ccodlab, "
                    + "COALESCE(a.quanprod, 1) AS quantidade, "
                    + "COALESCE(a.quanprod, 1) * COALESCE(a.unidhosp, 1) AS quantidadeTotal, "
                    + "COALESCE(a.unidhosp, 1) AS hospitalar, "
                    + "coalesce(a.custentr, a.valoprod) AS valorUnitario, "
                    + "coalesce(a.custentr, a.valoprod) * (COALESCE(a.quanprod, 1) * COALESCE(a.unidhosp, 1)) as valorTotal, "
                    + "(SELECT fornom FROM forarq WHERE forcod = b.forn and sr_deleted = '') AS fornecedor, "
                    + "b.forn, "
                    + "b.nfatura, "
                    + "d.nome as departamento, "
                    + "d.codigo as codDep, "
                    + "e.nome as area, "
                    + "e.codigo as codArea, "
                    + "f.nome as categoria, "
                    + "f.codigo as codCat, "
                    + "c.classe, "
                    + "c.clascodi "
                    + "FROM "
                    + "notapro a, "
                    + "alqent b, "
                    + "alqui c, "
                    + "departs d, "
                    + "areas e, "
                    + "catego f "
                    + "WHERE "
                    + "d.codigo = c.ccoddep "
                    + "AND e.codigo = d.codare "
                    + "AND f.codigo = d.codcat "
                    + "AND b.codinota = a.codinota "
                    + "AND c.ccodigo = a.codiprod "
                    + "AND b.dentre BETWEEN ? AND ? "
                    + "AND b.filial LIKE '%' "
                    + "AND b.entrsaid = 'E' "
                    + "AND coalesce(b.codidest, '') <> 'AL' "
                    + "AND a.sr_deleted = '' "
                    + "AND b.sr_deleted = '' "
                    + "AND c.sr_deleted = ''";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Mov x = new Mov();
                x.setLoc(rs.getString("filial"));
                x.setData(rs.getDate("dentre"));
                x.setCodigo(rs.getString("codiprod"));
                x.setDescricao(rs.getString("descprod"));
                x.setLaboratorio(rs.getString("nlab"));
                x.setQt(rs.getInt("quantidade"));
                x.setQtFracao(rs.getInt("quantidadeTotal"));
                x.setValorUnitario(rs.getDouble("valorUnitario"));
                x.setValorTotal(rs.getDouble("valorTotal"));
                x.setFornecedor(rs.getString("fornecedor"));
                x.setCodigoFornecedor(rs.getString("forn"));
                x.setCodigoLaboratorio(rs.getString("ccodlab"));
                x.setNota(rs.getString("nfatura"));
                x.setDepartamento(rs.getString("departamento"));
                x.setCategoria(rs.getString("categoria"));
                x.setArea(rs.getString("area"));
                x.setCodigoDepartamento(rs.getString("codDep"));
                x.setCodigoCategoria(rs.getString("codCat"));
                x.setCodigoArea(rs.getString("codArea"));
                x.setCodigoClasse(rs.getString("clascodi"));
                x.setClasse(rs.getString("classe"));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravaCompra(Mov x) throws SQLException {
        try {
            String sql = "insert ignore into "
                    + "bi_compras "
                    + "(loja, "
                    + "data, "
                    + "codigo, "
                    + "descricao, "
                    + "fabricante, "
                    + "unCompra, "
                    + "valorCompra, "
                    + "fornecedor, "
                    + "codigoFornecedor, "
                    + "codigoFabricante, "
                    + "nota, "
                    + "departamento, "
                    + "categoria, "
                    + "area, "
                    + "classe, "
                    + "codigoDepartamento, "
                    + "codigoCategoria, "
                    + "codigoArea, "
                    + "codigoClasse) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA_BI.prepareStatement(sql);
            System.out.println(sql);

            stmt.setString(1, x.getLoc());
            stmt.setDate(2, new java.sql.Date(x.getData().getTime()));
            stmt.setString(3, x.getCodigo());
            stmt.setString(4, x.getDescricao());
            stmt.setString(5, x.getLaboratorio());
            stmt.setInt(6, x.getQtFracao());
            stmt.setDouble(7, x.getValorTotal());
            stmt.setString(8, x.getFornecedor());
            stmt.setString(9, x.getCodigoFornecedor());
            stmt.setString(10, x.getCodigoLaboratorio());
            stmt.setString(11, x.getNota());
            stmt.setString(12, x.getDepartamento());
            stmt.setString(13, x.getCategoria());
            stmt.setString(14, x.getArea());
            stmt.setString(15, x.getClasse());
            stmt.setString(16, x.getCodigoDepartamento());
            stmt.setString(17, x.getCodigoCategoria());
            stmt.setString(18, x.getCodigoArea());
            stmt.setString(19, x.getCodigoClasse());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaProdutos(Date data) {
        try {
            String sql = "SELECT "
                    + "a.ccodigo, "
                    + "a.cdesc, "
                    + "a.nlab, "
                    + "a.ccodlab, "
                    + "b.nome as departamento, "
                    + "b.codigo as codDep, "
                    + "c.nome as area, "
                    + "c.codigo as codArea, "
                    + "d.nome as categoria, "
                    + "d.codigo as codCat, "
                    + "a.classe, "
                    + "a.clascodi, "
                    + "a.sr_recno, "
                    + "a.sr_deleted, "
                    + "a.ccusto, "
                    + "a.ccustou as penultimoCusto, "
                    + "a.ccustoul as ultimoCusto, "
                    + "a.cvenda, "
                    + "a.descp "
                    + "FROM "
                    + "alqui a, "
                    + "departs b, "
                    + "areas c, "
                    + "catego d "
                    + "WHERE "
                    + "b.codigo = a.ccoddep "
                    + "AND c.codigo = b.codare "
                    + "AND d.codigo = b.codcat "
                    + "AND a.caltpre >= ? "
                    + "AND b.sr_deleted = '' "
                    + "AND c.sr_deleted = '' "
                    + "AND d.sr_deleted = ''";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Mov x = new Mov();

                x.setCodigo(rs.getString("ccodigo"));
                x.setDescricao(rs.getString("cdesc"));
                x.setLaboratorio(rs.getString("nlab"));
                x.setCodigoLaboratorio(rs.getString("ccodlab"));
                x.setDepartamento(rs.getString("departamento"));
                x.setCodigoDepartamento(rs.getString("codDep"));
                x.setArea(rs.getString("area"));
                x.setCodigoArea(rs.getString("codArea"));
                x.setCategoria(rs.getString("categoria"));
                x.setCodigoCategoria(rs.getString("codCat"));
                x.setClasse(rs.getString("classe"));
                x.setCodigoClasse(rs.getString("clascodi"));
                x.setRecno(rs.getString("sr_recno"));
                x.setSr_deleted(rs.getString("sr_deleted"));
                x.setPrecoCusto(rs.getDouble("ccusto"));
                x.setPrecoVenda(rs.getDouble("cvenda"));
                x.setDesconto(rs.getDouble("descp"));
                x.setUltimoCusto(rs.getDouble("ultimoCusto"));
                x.setPenultimoCusto(rs.getDouble("penultimoCusto"));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insereProdutoBI(Mov p) {
        try {
            String sql = "insert ignore into "
                    + "bi_produtos"
                    + "(codigo, "
                    + "descricao, "
                    + "departamento, "
                    + "categoria, "
                    + "area, "
                    + "classe, "
                    + "codigoDepartamento, "
                    + "codigoCategoria, "
                    + "codigoArea, "
                    + "codigoClasse, "
                    + "sr_recno, "
                    + "fabricante, "
                    + "codigoFabricante, "
                    + "sr_deleted, "
                    + "custo, "
                    + "venda, "
                    + "desconto, "
                    + "ultimoCusto, "
                    + "penultimoCusto) "
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLandA_BI.prepareStatement(sql);

            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getDepartamento());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getArea());
            stmt.setString(6, p.getClasse());
            stmt.setString(7, p.getCodigoDepartamento());
            stmt.setString(8, p.getCodigoCategoria());
            stmt.setString(9, p.getCodigoArea());
            stmt.setString(10, p.getCodigoClasse());
            stmt.setString(11, p.getRecno());
            stmt.setString(12, p.getLaboratorio());
            stmt.setString(13, p.getCodigoLaboratorio());
            stmt.setString(14, p.getSr_deleted());
            stmt.setDouble(15, p.getPrecoCusto());
            stmt.setDouble(16, p.getPrecoVenda());
            stmt.setDouble(17, p.getDesconto());
            stmt.setDouble(18, p.getUltimoCusto());
            stmt.setDouble(19, p.getPenultimoCusto());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void atualizaProdutoBI(Mov p) {
        try {
            String sql = "update  "
                    + "bi_produtos "
                    + "set "
                    + "codigo = ?, "
                    + "descricao = ?, "
                    + "departamento = ?, "
                    + "categoria = ?, "
                    + "area = ?, "
                    + "classe = ?, "
                    + "codigoDepartamento = ?, "
                    + "codigoCategoria = ?, "
                    + "codigoArea = ?, "
                    + "codigoClasse = ?, "
                    + "fabricante = ?, "
                    + "codigoFabricante = ?, "
                    + "sr_deleted = ?, "
                    + "custo = ?, "
                    + "venda = ?, "
                    + "desconto = ?, "
                    + "ultimoCusto = ?, "
                    + "penultimoCusto = ? "
                    + "where "
                    + "sr_recno = ?";
            PreparedStatement stmt = this.conexaoLandA_BI.prepareStatement(sql);

            stmt.setString(1, p.getCodigo());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getDepartamento());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getArea());
            stmt.setString(6, p.getClasse());
            stmt.setString(7, p.getCodigoDepartamento());
            stmt.setString(8, p.getCodigoCategoria());
            stmt.setString(9, p.getCodigoArea());
            stmt.setString(10, p.getCodigoClasse());
            stmt.setString(11, p.getLaboratorio());
            stmt.setString(12, p.getCodigoLaboratorio());
            stmt.setString(13, p.getSr_deleted());
            stmt.setDouble(14, p.getPrecoCusto());
            stmt.setDouble(15, p.getPrecoVenda());
            stmt.setDouble(16, p.getDesconto());
            stmt.setDouble(17, p.getUltimoCusto());
            stmt.setDouble(18, p.getPenultimoCusto());
            stmt.setString(19, p.getRecno());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deletaMovProduto(Date dataI, Date dataF) {
        try {
            String sql = "delete from bi_movProduto where data between ? and ?";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mov> listaMovProdutos(Date dataI, Date dataF) {
        try {
            String sql = "SELECT "
                    + "a.loc, "
                    + "a.data, "
                    + "a.codigo, "
                    + "a.oper, "
                    + "SUM(COALESCE(a.qt, 0)) AS qt, "
                    + "SUM(COALESCE(a.valor1, 0)) AS valor1, "
                    + "SUM(COALESCE(a.valor2, 0)) AS valor2, "
                    + "SUM(COALESCE(a.valor3, 0)) AS valor3, "
                    + "SUM(COALESCE(a.valor4, 0)) AS valor4, "
                    + "SUM(COALESCE(a.valor5, 0)) AS valor5, "
                    + "SUM(COALESCE(a.valor6, 0)) AS valor6 "
                    + "FROM "
                    + "mov a "
                    + "WHERE "
                    + "a.data between ? and ? "
                    + "GROUP BY a.loc , a.data , a.codigo , a.oper "
                    + "ORDER BY a.loc , a.data , a.codigo , a.oper";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Mov x = new Mov();

                x.setLoc(rs.getString("loc"));
                x.setData(rs.getDate("data"));
                x.setCodigo(rs.getString("codigo"));
                x.setOper(rs.getString("oper"));
                x.setQt(rs.getInt("qt"));
                x.setValor1(rs.getDouble("valor1"));
                x.setValor2(rs.getDouble("valor2"));
                x.setValor3(rs.getDouble("valor3"));
                x.setValor4(rs.getDouble("valor4"));
                x.setValor5(rs.getDouble("valor5"));
                x.setValor6(rs.getDouble("valor6"));

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void gravaMovProduto(Mov x) {
        try {
            String sql = "insert into bi_movProduto (loja, data, codigo, operacao, quantidade, valor1, valor2, valor3, valor4, valor5, valor6) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setString(1, x.getLoc());
            stmt.setDate(2, new java.sql.Date(x.getData().getTime()));
            stmt.setString(3, x.getCodigo());
            stmt.setString(4, x.getOper());
            stmt.setInt(5, x.getQt());
            stmt.setDouble(6, x.getValor1());
            stmt.setDouble(7, x.getValor2());
            stmt.setDouble(8, x.getValor3());
            stmt.setDouble(9, x.getValor4());
            stmt.setDouble(10, x.getValor5());
            stmt.setDouble(11, x.getValor6());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void fechaConexao() {
        try {
            this.conexaoConsys.close();
            this.conexaoLandA_BI.close();
            this.conexaoLandA.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
