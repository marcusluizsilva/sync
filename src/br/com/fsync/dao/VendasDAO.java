package br.com.fsync.dao;

import br.com.fsync.objetos.Mov;
import br.com.fsync.objetos.Venda;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.conexao.CriaConexaoLandaBI;
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
public class VendasDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLandA;
    private Connection conexaoLandABI;

    // Construtor da classe VendaDao
    public VendasDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
        this.conexaoLandABI = CriaConexaoLandaBI.getConexao();
    }

    //
    public String sql;
    public double valor;
    public double desconto;
    public double descontoC;

    /*public List<Mov> listaDescontoManual(Date dataI, Date dataF, String loja) {
        valor = 0;
        desconto = 0;
        try {
            sql = "select "
                    + "b.loc, "
                    + "a.data, "
                    + "c.nome, "
                    + "sum(b.valor2) as valorVenda, "
                    + "a.totcomp as descontoManual, "
                    + "a.ndc, "
                    + "coalesce(a.nome, '') as cliente "
                    + "from "
                    + "conveni a, "
                    + "mov b, "
                    + "vendedor c "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "c.codigo = b.resp "
                    + "and "
                    + "a.data between ? and ? "
                    + "and "
                    + "b.loc = ? "
                    + "and "
                    + "a.convenio in ('301', '401', '402', '403', '404', '405', '423', '435') "
                    + "and "
                    + "b.codigo = '---P---' "
                    + "group by "
                    + "a.ndc "
                    + "order by "
                    + "b.sr_recno";

            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Mov x = new Mov();
                x.setLoc(rs.getString("loc"));
                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("nome"));
                x.setValor1(rs.getDouble("valorVenda"));
                x.setValor2(rs.getDouble("descontoManual"));
                x.setNdc(rs.getString("ndc"));
                x.setClipref(rs.getString("cliente"));

                valor = valor + rs.getDouble("valorVenda");
                desconto = desconto + rs.getDouble("descontoManual");

                // Adicionando o objeto à lista
                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    public List<Venda> listaNDCsDescontoManual(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "distinct ndc "
                    + "from "
                    + "conveni a "
                    + "where "
                    + "a.data between ? and ? "
                    + "and "
                    + "a.convenio in ('401', '402', '403', '404', '405', '423', '435', '458', '461', '472', '476')";
            List<Venda> arrayList = new ArrayList<Venda>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaAnaliseItemDescontoManual(): " + rs.getStatement());

            while (rs.next()) {
                Venda x = new Venda();

                x.setNdc(rs.getString("ndc"));

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

    public List<Venda> listaItemDescontoManualNDC(String ndc) {
        try {
            sql = "select "
                    + "a.sr_recno, "
                    + "a.loc, "
                    + "a.data, "
                    + "a.resp, "
                    + "b.nome as obs2, "
                    + "a.codigo, "
                    + "c.cdesc, "
                    + "a.qt, "
                    + "c.cvenda, "
                    + "round(c.cvenda - (c.cvenda * (coalesce(c.descp, 0) / 100)), 2) as liquido, "
                    + "a.valor2 as final, "
                    + "round((100 - ((a.valor2 * 100) / (c.cvenda * a.qt))), 2) as descontoItem, "
                    + "a.ndc, "
                    + "b.totcomp as descontoManual, "
                    + "(select sum(valor2) from mov where ndc = a.ndc and codigo <> '---P---') as valorVenda "
                    + "from "
                    + "mov a, "
                    + "conveni b, "
                    + "alqui c "
                    + "where "
                    + "b.ndc = a.ndc "
                    + "and "
                    + "c.ccodigo = a.codigo "
                    + "and "
                    + "b.convenio in ('401', '402', '403', '404', '405', '423', '435', '458', '461', '472', '476') "
                    + "and "
                    + "a.ndc = ?";
            List<Venda> arrayList = new ArrayList<Venda>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, ndc);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaAnaliseItemDescontoManual(): " + rs.getStatement());

            while (rs.next()) {
                Venda x = new Venda();
                x.setRecno(rs.getString("sr_recno"));
                x.setLoja(rs.getString("loc"));
                x.setData(rs.getDate("data"));
                x.setResponsavel(rs.getString("resp"));
                x.setConcorrente(rs.getString("obs2"));
                x.setCodigo(rs.getString("codigo"));
                x.setDescricao(rs.getString("cdesc"));
                x.setQuantidade(rs.getInt("qt"));
                x.setValorBruto(rs.getDouble("cvenda"));
                x.setValorLiquido(rs.getDouble("liquido"));
                x.setPrecoVenda(rs.getDouble("final"));
                x.setDesconto(rs.getDouble("descontoItem"));
                x.setNdc(rs.getString("ndc"));
                x.setDescontoManual(rs.getDouble("descontoManual"));
                x.setValorCupom(rs.getDouble("valorVenda"));

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

    public void gravaBIDescontoManual(Venda x) {
        try {
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(
                    "insert ignore into "
                    + "bi_descontoManual "
                    + "(recno, "
                    + "loja, "
                    + "data, "
                    + "vendedor, "
                    + "concorrente, "
                    + "codigo, "
                    + "descricao, "
                    + "quantidade, "
                    + "precoCheio, "
                    + "precoLiquido, "
                    + "precoVenda, "
                    + "descontoItem, "
                    + "ndc, "
                    + "descontoManualCupom, "
                    + "valorCupom, "
                    + "precoVendaFinal) "
                    + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            System.out.println(stmt);

            stmt.setString(1, x.getRecno());
            stmt.setString(2, x.getLoja());
            stmt.setDate(3, new java.sql.Date(x.getData().getTime()));
            stmt.setString(4, x.getResponsavel());
            stmt.setString(5, x.getConcorrente());
            stmt.setString(6, x.getCodigo());
            stmt.setString(7, x.getDescricao());
            stmt.setInt(8, x.getQuantidade());
            stmt.setDouble(9, x.getValorBruto());
            stmt.setDouble(10, x.getValorLiquido());
            stmt.setDouble(11, x.getPrecoVenda());
            stmt.setDouble(12, x.getDesconto());
            stmt.setString(13, x.getNdc());
            stmt.setDouble(14, x.getDescontoManual());
            stmt.setDouble(15, x.getValorCupom());

            double v = x.getValorCupom() - x.getDescontoManual();
            double descontoExtra = 100 - ((v * 100) / x.getValorCupom());
            double valorComDescontoManual = x.getPrecoVenda() - (x.getPrecoVenda() * (descontoExtra / 100));
            valorComDescontoManual = valorComDescontoManual / x.getQuantidade();

            stmt.setDouble(16, valorComDescontoManual);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void gravaBIDescontoManualCupom() {
        try {
            PreparedStatement stmt = this.conexaoLandA.prepareStatement("insert ignore into bi_descontomanualcupom (ndc, vendedor, valorProdutos, valorCupom, valorDescontoManual, data, concorrente, loja) select ndc, vendedor, sum(precoLiquido * quantidade), valorCupom, descontoManualCupom, data, concorrente, loja from bi_descontomanual group by ndc");
            System.out.println(stmt);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mov> listaDescontoManualValor(Date dataI, Date dataF, String loja) {
        descontoC = 0;
        desconto = 0;
        try {
            sql = "select "
                    + "sum(coalesce(descontoManual, 0)) as descontoManual, "
                    + "sum(coalesce(descontoCrediario, 0)) as descontoCrediario "
                    + "from "
                    + "ven_anafilresumo "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "loja like ? "
                    + "group by "
                    + "loja";

            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaDescontoManualValor(): " + rs.getStatement());

            while (rs.next()) {

                Mov x = new Mov();

                x.setValor2(rs.getDouble("descontoManual"));

                desconto = desconto + rs.getDouble("descontoManual");
                descontoC = descontoC + rs.getDouble("descontoCrediario");

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

    public List<Mov> listaDescontoManualCrediario(Date dataI, Date dataF, String loja) {
        descontoC = 0;
        try {
            sql = "select "
                    + "loc, "
                    + "sum(valor1) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "loc = ? "
                    + "and "
                    + "oper = 'H' "
                    + "and "
                    + "obs3 = 'D.01.01.016' "
                    + "and "
                    + "sr_deleted = '' "
                    + "group by "
                    + "oper";

            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Mov x = new Mov();
                x.setLoc(rs.getString("loc"));

                descontoC = descontoC + rs.getDouble("valor");

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

    public List<Mov> listaDevolucoes(String loja) {
        try {
            List<Mov> pd = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement("select "
                    + "a.sr_recno, "
                    + "a.codigo, "
                    //+ "b.cdesc, "
                    + "a.loc, "
                    + "a.qt, "
                    + "a.data "
                    //+ "b.clascodi "
                    + "from "
                    + "mov a "
                    //+ "alqui b "
                    + "where "
                    //+ "b.ccodigo = a.codigo "
                    //+ "and "
                    + "a.data = DATE_ADD(curdate(), INTERVAL -1 DAY) "
                    + "and "
                    + "a.loc = ? "
                    + "and "
                    + "a.oper = 'A'");
            stmt.setString(1, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {

                Mov x = new Mov();
                x.setRecno(rs.getString("sr_recno"));
                x.setCodigo(rs.getString("codigo"));
                x.setLoc(rs.getString("loc"));
                x.setQt(rs.getInt("qt"));
                x.setData(rs.getDate("data"));
                //x.setDescricao(rs.getString("cdesc"));
                //x.setObs1(rs.getString("clascodi"));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            System.out.println(stmt.getUpdateCount());
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void informaClasseDevolvidos() {
        try {
            sql = "update produtos a inner join est_classes b set a.codigoClasse = b.codigo where b.descricao = a.classe and a.sr_deleted = '' and b.deletado = ''";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            sql = "update est_devolucoes a inner join produtos b set a.descricao = b.descricao, a.classe = b.codigoClasse, a.fabricante = b.fabricante where b.codigo = a.codigo and a.classe is null";
            stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void gravaDevolucoes(Mov x) {
        try {
            sql = "insert ignore into est_devolucoes (recno, codigo, loja, quantidade, data, descricao, classe, fabricante) values (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);

            stmt.setString(1, x.getRecno());
            stmt.setString(2, x.getCodigo());
            stmt.setString(3, x.getLoc());
            stmt.setInt(4, x.getQt());
            stmt.setDate(5, new java.sql.Date(x.getData().getTime()));
            stmt.setString(6, x.getDescricao());
            stmt.setString(7, x.getObs1());
            stmt.setString(8, x.getLaboratorio());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mov> listaDiferencasBalanco() {
        try {
            List<Mov> arrayList = new ArrayList<Mov>();
            String sql = "select "
                    + "a.data, "
                    + "a.sr_recno, "
                    + "a.codigo, "
                    + "a.filial, "
                    + "b.cdesc, "
                    + "b.nlab, "
                    + "b.clascodi as classe "
                    + "from "
                    + "prodbal a, "
                    + "alqui b "
                    + "where "
                    + "b.ccodigo = a.codigo "
                    + "and "
                    + "a.codimoti = '1' "
                    + "and "
                    + "(coalesce(a.quantant, 0) - coalesce(a.quantdep, 0)) <> 0";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setRecno(rs.getString("sr_recno"));
                x.setCodigo(rs.getString("codigo"));
                x.setLoc(rs.getString("filial"));
                x.setObs1(rs.getString("classe"));
                x.setDescricao(rs.getString("cdesc"));
                x.setLaboratorio(rs.getString("nlab"));

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

    public void insereItemRecontagemBalanco(Mov x) throws SQLException {
        try {
            String sql = "insert ignore into "
                    + "est_prodbal "
                    + "(data, "
                    + "recno, "
                    + "codigo,"
                    + "loja, "
                    + "classe, "
                    + "descricao, "
                    + "fabricante) "
                    + "values "
                    + "(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);
            System.out.println(sql);

            stmt.setDate(1, new java.sql.Date(x.getData().getTime()));
            stmt.setString(2, x.getRecno());
            stmt.setString(3, x.getCodigo());
            stmt.setString(4, x.getLoc());
            stmt.setString(5, x.getObs1());
            stmt.setString(6, x.getDescricao());
            stmt.setString(7, x.getLaboratorio());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaVendas7Dias(Date dataI, Date dataF) {
        try {
            sql = "SELECT "
                    + "sr_recno, "
                    + "loc, "
                    + "data, "
                    + "resp, "
                    + "codigo, "
                    + "qt, "
                    + "valor2, "
                    + "ndc, "
                    + "obs1, "
                    + "clipref, "
                    + "caixa, "
                    + "hora, "
                    + "oper "
                    + "FROM "
                    + "mov "
                    + "WHERE "
                    //+ "data between CURDATE() - 7 and CURDATE() "
                    + "data between ? and ? "
                    + "AND "
                    + "oper in ('E', 'A', '-', '#', '$') "
                    + "order by "
                    + "data desc, "
                    + "loc asc";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                Mov x = new Mov();

                x.setRecno(rs.getString("sr_recno"));
                x.setLoc(rs.getString("loc"));
                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setCodigo(rs.getString("codigo"));
                x.setQt(rs.getInt("qt"));
                x.setValor2(rs.getDouble("valor2"));
                x.setNdc(rs.getString("ndc"));
                x.setObs1(rs.getString("obs1"));
                x.setClipref(rs.getString("clipref"));
                x.setCaixa(rs.getString("caixa"));
                x.setHora(rs.getString("hora"));
                x.setOper(rs.getString("oper"));

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

    public List<Mov> listaVendas60Dias() {
        try {
            sql = "select "
                    + "a.loja, "
                    + "a.codigo, "
                    + "sum(if (a.oper = 'E', a.quant, 0)) - sum(if (a.oper = 'A', a.quant, 0)) - sum(if (a.oper = '-', a.quant, 0)) - sum(if (a.oper = '#', a.quant, 0)) - sum(if (a.oper = '$', a.quant, 0)) as quant "
                    + "from "
                    + "bi_vendas a "
                    + "where "
                    + "a.data between date_add(curdate(), interval -60 day) and curdate() "
                    + "group by "
                    + "a.loja, "
                    + "a.codigo";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                Mov x = new Mov();

                x.setLoc(rs.getString("loja"));
                x.setCodigo(rs.getString("codigo"));
                x.setQt(rs.getInt("quant"));

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

    public void gravaVenda(Mov x) throws SQLException {
        try {
            String sql = "INSERT IGNORE INTO "
                    + "bi_vendas "
                    + "(recno, "
                    + "loja, "
                    + "data, "
                    + "vendedor, "
                    + "codigo, "
                    + "quant, "
                    + "valor, "
                    + "ndc, "
                    + "formaPagamento, "
                    + "cliente, "
                    + "caixa, "
                    + "hora, "
                    + "oper) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);
            System.out.println(x.getData() + " - LOJA" + x.getLoc());

            stmt.setString(1, x.getRecno());
            stmt.setString(2, x.getLoc());
            stmt.setDate(3, new java.sql.Date(x.getData().getTime()));
            stmt.setString(4, x.getResp());
            stmt.setString(5, x.getCodigo());
            stmt.setInt(6, x.getQt());
            stmt.setDouble(7, x.getValor2());
            stmt.setString(8, x.getNdc());
            stmt.setString(9, x.getObs1());
            stmt.setString(10, x.getClipref());
            stmt.setString(11, x.getCaixa());
            stmt.setString(12, x.getHora());
            stmt.setString(13, x.getOper());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void zeraVendas60Dias() throws SQLException {
        try {
            String sql = "update produtos set venda60Dias01 = 0";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias02 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias03 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias04 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias05 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias06 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias07 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias08 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias09 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias10 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias11 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias12 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
            
            sql = "update produtos set venda60Dias13 = 0";
            stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void informaVenda60Dias(Mov x) throws SQLException {
        try {
            String sql = "update produtos set venda60Dias" + x.getLoc() + " = ? where codigo = ?";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);
            System.out.println(sql);

            stmt.setInt(1, x.getQt());
            stmt.setString(2, x.getCodigo());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Venda> pesquisaVendaClientePreferencial(Date dataI, Date dataF) {
        String sql = "select "
                + "a.sr_recno, "
                + "a.data, "
                + "a.hora, "
                + "a.loc, "
                + "substr(a.clipref, 6, 3) as cartao, "
                + "substr(a.clipref, 9, 5) as numero, "
                + "(select nome from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as nomeCliente, "
                + "(select cpf from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as cpfCliente, "
                + "(select bairro from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as bairroCliente, "
                + "(select cidade from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as cidadeCliente, "
                + "(select cep from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as cepCliente, "
                + "(select tel from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as telefoneCliente, "
                + "(select datanasc from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as nascimentoCliente, "
                + "(select sexoclie from clipref where codcart = substr(a.clipref, 6, 3) and codigo = substr(a.clipref, 9, 5) and sr_deleted = '' limit 1) as sexoCliente, "
                + "a.ndc, "
                + "a.codigo, "
                + "a.qt, "
                + "a.valor2, "
                + "a.valor5, "
                + "a.resp, "
                + "a.obs1 as formaPagamento "
                + "from "
                + "mov a "
                + "where "
                + "a.data between ? and ? "
                + "and "
                + "substr(a.clipref, 6, 3) in ('003', '009', '011', '012') "
                + "and "
                + "a.oper = 'E'";
        try {
            List<Venda> arrayList = new ArrayList<Venda>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("pesquisaVendaClientePreferencial(): " + rs.getStatement());
            while (rs.next()) {
                Venda x = new Venda();

                x.setRecno(rs.getString("sr_recno"));
                x.setData(rs.getDate("data"));
                x.setHora(rs.getString("hora"));
                x.setLoja(rs.getString("loc"));
                x.setCodigoCartao(rs.getString("cartao"));
                x.setCodigoCliente(rs.getString("numero"));
                x.setNomeCliente(rs.getString("nomeCliente"));
                x.setCpf(rs.getString("cpfCliente"));
                x.setNdc(rs.getString("ndc"));
                x.setCodigo(rs.getString("codigo"));
                x.setQuantidade(rs.getInt("qt"));
                x.setValorLiquido(rs.getDouble("valor2"));
                x.setCodigoVendedor(rs.getString("resp"));
                x.setFormaPagamento(rs.getString("formaPagamento"));
                x.setBairro(rs.getString("bairroCliente"));
                x.setCidade(rs.getString("cidadeCliente"));
                x.setCep(rs.getString("cepCliente"));
                x.setTelefone(rs.getString("telefoneCliente"));
                x.setNascimento(rs.getDate("nascimentoCliente"));
                x.setSexo(rs.getString("sexoCliente"));
                x.setDesconto(rs.getDouble("valor5"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void gravaVendaClipref(Venda x) throws SQLException {
        try {
            String sql = "insert ignore into "
                    + "bi_vendaClipref "
                    + "(recno, "
                    + "data, "
                    + "hora, "
                    + "loja, "
                    + "cartao, "
                    + "codigoCliente, "
                    + "nomeCliente, "
                    + "ndc, "
                    + "produto, "
                    + "quantidade, "
                    + "valor, "
                    + "vendedor, "
                    + "cpf, "
                    + "formaPagamento, "
                    + "bairro, "
                    + "cidade, "
                    + "cep, "
                    + "telefone, "
                    + "nascimento, "
                    + "sexo, "
                    + "desconto) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);
            System.out.println(sql);

            stmt.setString(1, x.getRecno());
            stmt.setDate(2, new java.sql.Date(x.getData().getTime()));
            stmt.setString(3, x.getHora());
            stmt.setString(4, x.getLoja());
            stmt.setString(5, x.getCodigoCartao());
            stmt.setString(6, x.getCodigoCliente());
            stmt.setString(7, x.getNomeCliente());
            stmt.setString(8, x.getNdc());
            stmt.setString(9, x.getCodigo());
            stmt.setInt(10, x.getQuantidade());
            stmt.setDouble(11, x.getValorLiquido());
            stmt.setString(12, x.getCodigoVendedor());
            stmt.setString(13, x.getCpf());
            stmt.setString(14, x.getFormaPagamento());
            stmt.setString(15, x.getBairro());
            stmt.setString(16, x.getCidade());
            stmt.setString(17, x.getCep());
            stmt.setString(18, x.getTelefone());
            if (x.getNascimento() != null) {
                stmt.setDate(19, new java.sql.Date(x.getNascimento().getTime()));
            } else {
                stmt.setString(19, null);
            }
            stmt.setString(20, x.getSexo());
            stmt.setDouble(21, x.getDesconto());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpaClipref() throws SQLException {
        try {
            String sql = "update clipref set sr_deleted = 'T', dtalt = curdate() where nome not like '% %' and codcart = '009' and sr_deleted = ''";
            PreparedStatement stmt = conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update clipref set sr_deleted = 'T', dtalt = curdate() where datanasc is null and codcart = '009' and sr_deleted = ''";
            stmt = conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update clipref set sr_deleted = 'T', dtalt = curdate() where sexoclie is null and codcart = '009' and sr_deleted = ''";
            stmt = conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update clipref set sr_deleted = 'T', dtalt = curdate() where cidade is null and codcart = '009' and sr_deleted = ''";
            stmt = conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update clipref set sr_deleted = 'T', dtalt = curdate() where bairro is null and codcart = '009' and sr_deleted = ''";
            stmt = conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            sql = "update clipref set sr_deleted = 'T', dtalt = curdate() where cpf in (select cpfemp from vendedor where funcemp in ('BALCONISTA', 'VEND.PERFUMARIA', 'GERENTE'))";
            stmt = conexaoConsys.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fechaConexao() {
        try {
            this.conexaoConsys.close();
            this.conexaoLandA.close();
            this.conexaoLandABI.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
