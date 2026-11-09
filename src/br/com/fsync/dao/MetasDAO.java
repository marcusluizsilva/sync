package br.com.fsync.dao;

import br.com.fsync.objetos.Anavend;
import br.com.fsync.objetos.Campanhas;
import br.com.fsync.objetos.MetasVendedor;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.Mov;
import br.com.fsync.objetos.Vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcus Luiz
 */
public class MetasDAO {

    private Connection conexaoConsys;
    private Connection conexaoLanda;
    // Declaração das variáveis públicas
    public String sql;
    public String par_operacao;

    public MetasDAO() throws SQLException {
        this.conexaoLanda = CriaConexaoLanda.getConexao();
        this.conexaoConsys = CriaConexaoConsys.getConexao();
    }

    public List<Anavend> listaAnavendParaUpdate(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "data, "
                    + "codifili, "
                    + "vend, "
                    + "codiprod, "
                    + "depar, "
                    + "round(natend) as natend, "
                    + "nunida, "
                    + "vvena, "
                    + "comiprod, "
                    + "tdesc, "
                    + "tdescp, "
                    + "tdescpref, "
                    + "textr, "
                    + "tdevol, "
                    + "tdevocred, "
                    + "tvendc, "
                    + "treccre, "
                    + "tcust, "
                    + "sr_recno, "
                    + "sr_deleted "
                    + "from "
                    + "anavend "
                    + "where "
                    + "data between ? and ? "
                    + "order by "
                    + "codifili, "
                    + "data, "
                    + "vend, "
                    + "depar";
            List<Anavend> arrayList = new ArrayList<Anavend>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaAnavendParaUpdate() " + rs.getStatement());

            while (rs.next()) {

                Anavend x = new Anavend();

                // Criação do objeto para exibição na JTable
                x.setCodifili(rs.getString("codifili"));
                x.setCodiprod(rs.getString("codiprod"));
                x.setComiprod(rs.getDouble("comiprod"));
                x.setData(rs.getDate("data"));
                x.setDepar(rs.getString("depar"));
                x.setNatend(rs.getInt("natend"));
                x.setNunida(rs.getInt("nunida"));
                x.setSr_deleted(rs.getString("sr_deleted"));
                x.setSr_recno(rs.getString("sr_recno"));
                x.setTcust(rs.getDouble("tcust"));
                x.setTdesc(rs.getDouble("tdesc"));
                x.setTdescp(rs.getDouble("tdescp"));
                x.setTdescpref(rs.getDouble("tdescpref"));
                x.setTdevocred(rs.getDouble("tdevocred"));
                x.setTdevol(rs.getDouble("tdevol"));
                x.setTextr(rs.getDouble("textr"));
                x.setTreccre(rs.getDouble("treccre"));
                x.setTvendc(rs.getDouble("tvendc"));
                x.setVend(rs.getString("vend"));
                x.setVvena(rs.getDouble("vvena"));

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

    public List<Anavend> listaAtendimentos(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "a.data, "
                    + "a.resp, "
                    + "count(distinct a.ndc) as natend "
                    + "from "
                    + "mov a "
                    + "where "
                    + "a.data between ? and ? "
                    + "and "
                    + "a.oper = 'E' "
                    + "group by "
                    + "a.data, "
                    + "a.resp";
            List<Anavend> arrayList = new ArrayList<Anavend>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Anavend x = new Anavend();

                // Criação do objeto para exibição na JTable
                x.setData(rs.getDate("data"));
                x.setNatend(rs.getInt("natend"));
                x.setVend(rs.getString("resp"));

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

    public List<Anavend> listaCupons(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "a.data, "
                    + "b.filialemp, "
                    + "b.codigo, "
                    + "b.nome, "
                    + "count(distinct a.ndc) as cupons "
                    + "from "
                    + "mov a, "
                    + "vendedor b "
                    + "where "
                    + "b.codigo = substr(a.caixa, 3, 4) "
                    + "and "
                    + "a.oper = 'E' "
                    + "and "
                    + "b.funcemp = 'oper.caixa' "
                    + "and "
                    + "a.data between ? and ? "
                    + "group by "
                    + "a.data, "
                    + "b.codigo";
            List<Anavend> arrayList = new ArrayList<Anavend>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Anavend x = new Anavend();

                // Criação do objeto para exibição na JTable
                x.setData(rs.getDate("data"));
                x.setNatend(rs.getInt("cupons"));
                x.setVend(rs.getString("codigo"));
                x.setData(rs.getDate("data"));

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

    public List<Mov> listaRecebimentosCaixa(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "vendedor, "
                    + "ndc, "
                    + "produto "
                    + "from "
                    + "ven_vendabonificados "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "pago = 'S' "
                    + "and "
                    + "valorpago > 0 "
                    + "and "
                    + "devolucao is null";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaRecebimentosCaixa(): " + rs.getStatement());

            while (rs.next()) {

                Mov x = new Mov();

                x.setNdc(rs.getString("ndc"));
                x.setCodigo(rs.getString("produto"));
                x.setResp(rs.getString("vendedor"));

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

    public List<Mov> listaDevolucoesRecebimentosCaixa(String ndc, String codigo) {
        try {
            sql = "select "
                    + "codigo "
                    + "from "
                    + "mov "
                    + "where "
                    + "obs3 like ? "
                    + "and "
                    + "codigo = ? "
                    + "and "
                    + "oper in ('A', '#', '-', '$') order by data desc";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, ndc);
            stmt.setString(2, codigo);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaDevolucoesRecebimentosCaixa(): " + rs.getStatement());

            while (rs.next()) {

                Mov x = new Mov();

                x.setCodigo(rs.getString("codigo"));

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

    public void informaDevolucaoRecCaixa(Mov x) {
        // Prepara a conexão com o banco de dados
        String sql = "update "
                + "ven_vendaBonificados "
                + "set "
                + "devolucao = 'S' "
                + "where "
                + "ndc = ? "
                + "and "
                + "produto = ?";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setString(1, x.getNdc());
            stmt.setString(2, x.getCodigo());

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaAtendimentos(Anavend x) {
        // Prepara a conexão com o banco de dados
        String sql = "update "
                + "ven_posicaoMetaIndividual "
                + "set "
                + "atendimentos = ? "
                + "where "
                + "vendedor = ? "
                + "and "
                + "data = ?";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setInt(1, x.getNatend());
            stmt.setString(2, x.getVend());
            stmt.setDate(3, new java.sql.Date(x.getData().getTime()));

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaCupons(Anavend x) {
        // Prepara a conexão com o banco de dados
        String sql = "update "
                + "ven_posicaoMetaIndividual "
                + "set "
                + "cupons = ? "
                + "where "
                + "vendedor = ? "
                + "and "
                + "data = ?";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setInt(1, x.getNatend());
            stmt.setString(2, x.getVend());
            stmt.setDate(3, new java.sql.Date(x.getData().getTime()));

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaAnavend(Anavend x) {
        // Prepara a conexão com o banco de dados
        String sql = "update "
                + "ven_anavend "
                + "set "
                + "data = ?, "
                + "codifili = ?, "
                + "vend = ?, "
                + "codiprod = ?, "
                + "depar = ?, "
                + "natend = ?, "
                + "nunida = ?, "
                + "vvena = ?, "
                + "comiprod = ?, "
                + "tdesc = ?, "
                + "tdescp = ?, "
                + "tdescpref = ?, "
                + "textr = ?, "
                + "tdevol = ?, "
                + "tdevocred = ?, "
                + "tvendc = ?, "
                + "treccre = ?, "
                + "tcust = ?, "
                + "sr_deleted = ? "
                + "where "
                + "sr_recno = ?";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);
            
            // Seta os valores a serem inseridos no banco de dados
            stmt.setDate(1, new java.sql.Date(x.getData().getTime()));
            stmt.setString(2, x.getCodifili());
            stmt.setString(3, x.getVend());
            stmt.setString(4, x.getCodiprod());
            stmt.setString(5, x.getDepar());
            stmt.setInt(6, x.getNatend());
            stmt.setInt(7, x.getNunida());
            stmt.setDouble(8, x.getVvena());
            stmt.setDouble(9, x.getComiprod());
            stmt.setDouble(10, x.getTdesc());
            stmt.setDouble(11, x.getTdescp());
            stmt.setDouble(12, x.getTdescpref());
            stmt.setDouble(13, x.getTextr());
            stmt.setDouble(14, x.getTdevol());
            stmt.setDouble(15, x.getTdevocred());
            stmt.setDouble(16, x.getTvendc());
            stmt.setDouble(17, x.getTreccre());
            stmt.setDouble(18, x.getTcust());
            stmt.setString(19, x.getSr_deleted());
            stmt.setString(20, x.getSr_recno());

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Anavend> listaAnavend(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "data, "
                    + "codifili, "
                    + "vend, "
                    + "codiprod, "
                    + "depar, "
                    + "round(natend) as natend, "
                    + "nunida, "
                    + "vvena, "
                    + "comiprod, "
                    + "tdesc, "
                    + "tdescp, "
                    + "tdescpref, "
                    + "textr, "
                    + "tdevol, "
                    + "tdevocred, "
                    + "tvendc, "
                    + "treccre, "
                    + "tcust, "
                    + "sr_recno, "
                    + "sr_deleted "
                    + "from "
                    + "anavend "
                    + "where "
                    + "data between ? and ? "
                    + "order by "
                    + "codifili, "
                    + "data, "
                    + "vend, "
                    + "depar";
            List<Anavend> arrayList = new ArrayList<Anavend>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("ANAVEND: " + sql);

            while (rs.next()) {

                Anavend x = new Anavend();

                // Criação do objeto para exibição na JTable
                x.setCodifili(rs.getString("codifili"));
                x.setCodiprod(rs.getString("codiprod"));
                x.setComiprod(rs.getDouble("comiprod"));
                x.setData(rs.getDate("data"));
                x.setDepar(rs.getString("depar"));
                x.setNatend(rs.getInt("natend"));
                x.setNunida(rs.getInt("nunida"));
                x.setSr_deleted(rs.getString("sr_deleted"));
                x.setSr_recno(rs.getString("sr_recno"));
                x.setTcust(rs.getDouble("tcust"));
                x.setTdesc(rs.getDouble("tdesc"));
                x.setTdescp(rs.getDouble("tdescp"));
                x.setTdescpref(rs.getDouble("tdescpref"));
                x.setTdevocred(rs.getDouble("tdevocred"));
                x.setTdevol(rs.getDouble("tdevol"));
                x.setTextr(rs.getDouble("textr"));
                x.setTreccre(rs.getDouble("treccre"));
                x.setTvendc(rs.getDouble("tvendc"));
                x.setVend(rs.getString("vend"));
                x.setVvena(rs.getDouble("vvena"));

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

    public void copiaAnavend(Anavend x) {
        // Prepara a conexão com o banco de dados
        String sql = "insert ignore "
                + "into "
                + "ven_anavend "
                + "(data, "
                + "codifili, "
                + "vend, "
                + "codiprod, "
                + "depar, "
                + "natend, "
                + "nunida, "
                + "vvena, "
                + "comiprod, "
                + "tdesc, "
                + "tdescp, "
                + "tdescpref, "
                + "textr, "
                + "tdevol, "
                + "tdevocred, "
                + "tvendc, "
                + "treccre, "
                + "tcust, "
                + "sr_recno, "
                + "sr_deleted) "
                + "values "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setDate(1, new java.sql.Date(x.getData().getTime()));
            stmt.setString(2, x.getCodifili());
            stmt.setString(3, x.getVend());
            stmt.setString(4, x.getCodiprod());
            stmt.setString(5, x.getDepar());
            stmt.setInt(6, x.getNatend());
            stmt.setInt(7, x.getNunida());
            stmt.setDouble(8, x.getVvena());
            stmt.setDouble(9, x.getComiprod());
            stmt.setDouble(10, x.getTdesc());
            stmt.setDouble(11, x.getTdescp());
            stmt.setDouble(12, x.getTdescpref());
            stmt.setDouble(13, x.getTextr());
            stmt.setDouble(14, x.getTdevol());
            stmt.setDouble(15, x.getTdevocred());
            stmt.setDouble(16, x.getTvendc());
            stmt.setDouble(17, x.getTreccre());
            stmt.setDouble(18, x.getTcust());
            stmt.setString(19, x.getSr_recno());
            stmt.setString(20, x.getSr_deleted());

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeVendasSemArea(Date dataI, Date dataF) {
        // Prepara a conexão com o banco de dados
        String sql = "update ignore ven_posicaoMeta set area = 'HPPC' where data between ? and ? and area is null";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<MetasVendedor> analiseIndividualVendedor(Date dataI, Date dataF) {
        try {
            sql = "select "
                    + "a.data, "
                    + "a.vend, "
                    + "a.area, "
                    + "round(sum(coalesce(natend, 0))) as atendimentos, "
                    + "round(sum(coalesce(nunida, 0))) as unidades, "
                    + "(sum(coalesce(vvena,0)) + sum(coalesce(tvendc,0))) - (sum(coalesce(tdevol, 0)) + sum(coalesce(tdevocred, 0))) as liquido, "
                    + "(sum(coalesce(tdescp, 0) - coalesce(tdescpref, 0))) +  sum(coalesce(tdesc, 0)) as descontos "
                    + "from "
                    + "ven_anavend a "
                    + "where "
                    + "a.data between ? and ? "
                    //+ "and "
                    //+ "a.vend like ? "
                    //+ "and "
                    //+ "b.funcao like ? "
                    //+ "and "
                    //+ "b.loja like ? "
                    //+ "and "
                    //+ "d.periodo = ? "
                    + "group by "
                    + "a.data, "
                    + "a.area, "
                    + "a.vend "
                    + "order by "
                    + "a.codifili, "
                    + "a.data, "
                    + "a.vend";
            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println("analiseIndividualVendedor(): " + rs.getStatement());

            while (rs.next()) {
                MetasVendedor x = new MetasVendedor();

                x.setVendaLiquida(rs.getDouble("liquido"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setUnidades(rs.getInt("unidades"));
                x.setArea(rs.getString("area"));
                x.setDescontoMaximo(rs.getDouble("descontos"));
                x.setCodigo(rs.getString("vend"));
                x.setData(rs.getDate("data"));

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

    public List<MetasVendedor> listaVendaArea(Date dataI, Date dataF) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataIS = sdf.format(dataI);
            String dataFS = sdf.format(dataF);
            sql = "select "
                    + "a.data as dataVenda, "
                    + "a.vendedor as vend, "
                    + "(select sum(coalesce(valor, 0)) from ven_posicaoMeta where data = dataVenda and vendedor = vend and area not in ('GENERICO', 'SIMILAR')) as geral, "
                    + "(select sum(coalesce(valor, 0)) from ven_posicaoMeta where data = dataVenda and vendedor = vend and area in ('GENERICO')) as generico, "
                    + "(select sum(coalesce(valor, 0)) from ven_posicaoMeta where data = dataVenda and vendedor = vend and area in ('SIMILAR')) as similar, "
                    + "(select sum(coalesce(atendimentos, 0)) from ven_posicaoMeta where data = dataVenda and vendedor = vend) as atendimentos "
                    + "from "
                    + "ven_posicaoMeta a "
                    + "where "
                    + "a.data between '" + dataIS + "' and '" + dataFS + "' "
                    + "group by "
                    + "a.data, "
                    + "a.vendedor "
                    + "order by "
                    + "a.vendedor, "
                    + "a.data";
            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                MetasVendedor x = new MetasVendedor();

                x.setVendaLiquida(rs.getDouble("geral"));
                x.setMetaGenerico(rs.getDouble("generico"));
                x.setMetaSimilar(rs.getDouble("similar"));
                x.setCodigo(rs.getString("vend"));
                x.setData(rs.getDate("dataVenda"));
                x.setAtendimentos(rs.getInt("atendimentos"));

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

    public void gravaPosicaoMetaResumida(MetasVendedor x) {
        // Prepara a conexão com o banco de dados
        String sql = "insert ignore into ven_posicaoMetaIndividual (vendedor, geral, generico, similar, data, atendimentos) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setString(1, x.getCodigo());
            stmt.setDouble(2, x.getVendaLiquida());
            stmt.setDouble(3, x.getMetaGenerico());
            stmt.setDouble(4, x.getMetaSimilar());
            stmt.setDate(5, new java.sql.Date(x.getData().getTime()));
            stmt.setInt(6, x.getAtendimentos());

            // Executa o código sql
            stmt.execute();
            stmt.close();

            sql = "update ven_posicaoMetaIndividual set geral = ?, generico = ?, similar = ?, atendimentos = ? where vendedor = ? and data = ?";

            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setDouble(1, x.getVendaLiquida());
            stmt.setDouble(2, x.getMetaGenerico());
            stmt.setDouble(3, x.getMetaSimilar());
            stmt.setInt(4, x.getAtendimentos());
            stmt.setString(5, x.getCodigo());
            stmt.setDate(6, new java.sql.Date(x.getData().getTime()));

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpaPosicaoMeta(Date dataI, Date dataF) {
        try {
            String sql = "delete from ven_posicaoMeta where data between ? and ?";
            PreparedStatement stmt = conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            
            stmt.execute();
            stmt.close();
            
            sql = "delete from ven_posicaoMetaIndividual where data between ? and ?";
            stmt = conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            
            stmt.execute();
            stmt.close();
            
            System.out.println("limpaPosicaoMeta()");
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gravaPosicaoMeta(MetasVendedor x) {
        try {
            String sql = "insert ignore into ven_posicaoMeta (valor, atendimentos, unidades, area, desconto, vendedor, data) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setDouble(1, x.getVendaLiquida());
            stmt.setInt(2, x.getAtendimentos());
            stmt.setInt(3, x.getUnidades());
            stmt.setString(4, x.getArea());
            stmt.setDouble(5, x.getDescontoMaximo());
            stmt.setString(6, x.getCodigo());
            stmt.setDate(7, new java.sql.Date(x.getData().getTime()));

            // Executa o código sql
            stmt.execute();
            stmt.close();

            /*sql = "update ven_posicaoMeta set valor = ?, atendimentos = ?, unidades = ?, desconto = ? where vendedor = ? and area = ? and data = ?";

            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setDouble(1, x.getVendaLiquida());
            stmt.setInt(2, x.getAtendimentos());
            stmt.setInt(3, x.getUnidades());
            stmt.setDouble(4, x.getDescontoMaximo());
            stmt.setString(5, x.getCodigo());
            stmt.setString(6, x.getArea());
            stmt.setDate(7, new java.sql.Date(x.getData().getTime()));

            // Executa o código sql
            stmt.execute();
            stmt.close();*/
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Campanhas> listaArqlista(String lista) {
        try {
            sql = "select "
                    + "codigo, "
                    + "preco, "
                    + "datainic, "
                    + "datafina "
                    + "from "
                    + "arqlista "
                    + "where "
                    + "codlis = ? "
                    + "and "
                    + "sr_deleted = ''";
            List<Campanhas> arrayList = new ArrayList<Campanhas>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, lista);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                Campanhas x = new Campanhas();

                x.setProduto(rs.getString("codigo"));
                x.setValorVenda(rs.getDouble("preco"));
                x.setDataInicio(rs.getDate("datainic"));
                x.setDataFim(rs.getDate("datafim"));

                insereItensCampanha(x);

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

    public void insereItensCampanha(Campanhas x) {
        // Prepara a conexão com o banco de dados
        String sql = "insert into ven_campanhas (recno, data, vendedor, laboratorio, unidadesVenda, valorVenda, unidadesDevolvidas, valorDevolvido, produto) values (? ,? ,? ,? ,? ,? ,? ,?, ?)";
        PreparedStatement stmt;
        try {
            stmt = conexaoLanda.prepareStatement(sql);

            // Seta os valores a serem inseridos no banco de dados
            stmt.setString(1, x.getRecno());
            stmt.setDate(2, new java.sql.Date(x.getDataVenda().getTime()));
            stmt.setString(3, x.getVendedor());
            stmt.setString(4, x.getLaboratorio());
            stmt.setInt(5, x.getUnidadesVenda());
            stmt.setDouble(6, x.getValorVenda());
            stmt.setInt(7, x.getUnidadesDevolvidas());
            stmt.setDouble(8, x.getValorDevolvido());
            stmt.setString(9, x.getProduto());

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MetasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<MetasVendedor> listaPosicaoAtendimento(Date dataI, Date dataF, String loja, String funcao) {
        try {
            sql = "select "
                    + "a.vendedor, "
                    + "b.nome, "
                    + "b.funcao, "
                    + "a.atendimentos "
                    + "from "
                    + "ven_posicaoMetaIndividual a, "
                    + "funcionarios b "
                    + "where "
                    + "b.codigo = a.vendedor "
                    + "and "
                    + "a.data between ? and ? "
                    + "and "
                    + "b.loja = ? "
                    + "and "
                    + "b.funcao like ? "
                    + "group by "
                    + "a.vendedor "
                    + "order by "
                    + "a.atendimentos desc";
            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataI.getTime()));
            stmt.setString(3, loja);
            stmt.setString(4, funcao);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                MetasVendedor x = new MetasVendedor();

                x.setCodigo(rs.getString("vendedor"));
                x.setNome(rs.getString("nome"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setFuncao(rs.getString("funcao"));

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

    public List<MetasVendedor> calculaVendedores(Date dataI, Date dataF, String loja) {
        try {
            sql = "select "
                    + "count(distinct vend) as total "
                    + "from "
                    + "anavend "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "codifili = ? "
                    + "and "
                    + "coalesce(natend, 0) > 0";
            /*"select "
                    + "count(distinct resp) as total "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "loc = ? "
                    + "and "
                    + "oper = 'E'";*/
            List<MetasVendedor> arrayList = new ArrayList<MetasVendedor>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataI.getTime()));
            stmt.setString(3, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                MetasVendedor x = new MetasVendedor();

                x.setAtendimentos(rs.getInt("total"));

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

    public void fechaConexao() {
        try {
            this.conexaoConsys.close();
            this.conexaoLanda.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
