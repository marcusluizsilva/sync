package br.com.fsync.dao;

import br.com.fsync.objetos.Deposito;
import br.com.fsync.objetos.Mov;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Marcus Luiz
 */
public class ConferenciaDeCaixaDAO {

    //private Connection conexaoLoja;
    private Connection conexaoLanda;
    private Connection conexaoConsys;

    //
    String campo;

    // Construtor da classe VendaDao
    public ConferenciaDeCaixaDAO() throws SQLException {
        this.conexaoLanda = CriaConexaoLanda.getConexao();
        this.conexaoConsys = CriaConexaoConsys.getConexao();
    }

    public void deletaMovimento24H(Mov x) {
        try {
            String sql = "delete from ven_vendas24H where data between ? and ?";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(x.getData().getTime()));
            stmt.setDate(2, new java.sql.Date(x.getDataF().getTime()));

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mov> listaDevolucoes24H(Date dataI, Date dataF) {
        try {
            campo = "devolucoes";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor2,0) * coalesce(qt, 0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = 'A' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("A");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insereMovimento24H(Mov x) {
        try {
            String sql = "insert ignore "
                    + "into "
                    + "ven_vendas24H "
                    + "(data, "
                    + "vendedor, "
                    + "operador, "
                    + "operacao, "
                    + campo + ") "
                    + "values "
                    + "(?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(x.getData().getTime()));
            stmt.setString(2, x.getResp());
            stmt.setString(3, x.getCaixa());
            stmt.setString(4, x.getOper());
            stmt.setDouble(5, x.getValor1());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mov> listaRetiradas24H(Date dataI, Date dataF) {
        try {
            campo = "retiradas";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor1,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = 'H' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("H");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaRecebimentos24H(Date dataI, Date dataF) {
        try {
            campo = "recebimentos";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor1,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data "
                    + "between ? and ? "
                    + "and "
                    + "oper = ('U') "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("U");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaRecebimentosCrediario24H(Date dataI, Date dataF) {
        try {
            campo = "recebimentosCrediario";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "(sum(coalesce(valor1,0)) * -1) + sum(coalesce(valor2,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = ('G') "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("G");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaDinheiro24H(Date dataI, Date dataF) {
        try {
            campo = "dinheiro";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor2,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = ('E') "
                    + "and "
                    + "obs1 like ' 1%' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("E1");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaCartao24H(Date dataI, Date dataF) {
        try {
            campo = "cartao";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor2,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = ('E') "
                    + "and "
                    + "obs1 like ' 2%' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("E2");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaCheque24H(Date dataI, Date dataF) {
        try {
            campo = "cheque";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor2,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = ('E') "
                    + "and "
                    + "obs1 like ' 3%' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("E3");

                if (rs.getDate("data") != null) {
                    insereMovimento24H(x);
                }
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaConvenio24H(Date dataI, Date dataF) {
        try {
            campo = "convenio";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor2,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = ('E') "
                    + "and "
                    + "obs1 like ' 4%' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("E4");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Mov> listaCrediario24H(Date dataI, Date dataF) {
        try {
            campo = "dinheiro";
            String sql = "select "
                    + "substr(caixa,3,4) as operador, "
                    + "data, "
                    + "resp, "
                    + "sum(coalesce(valor2,0)) as valor "
                    + "from "
                    + "mov "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = ('E') "
                    + "and "
                    + "obs1 like ' 5%' "
                    + "and "
                    + "codigo = '---P---' "
                    + "and "
                    + "substr(caixa,3,4) in ('0932', '0068', '0099') "
                    + "group by "
                    + "data, "
                    + "resp, "
                    + "substr(caixa,3,4)";
            List<Mov> arrayList = new ArrayList<Mov>();
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                Mov x = new Mov();

                x.setData(rs.getDate("data"));
                x.setResp(rs.getString("resp"));
                x.setValor1(rs.getDouble("valor"));
                x.setCaixa(rs.getString("operador"));
                x.setOper("E5");

                insereMovimento24H(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Deposito> listaDepositos(Date dataI, Date dataF) {
        try {
            String sql = "select "
                    + "loc, "
                    + "data, "
                    + "hora, "
                    + "valor1, "
                    + "valor2, "
                    + "resp, "
                    + "substr(caixa, 3, 4) as operador, "
                    + "ndc, "
                    + "substr(recno, 9) as sr_recno "
                    + "from "
                    + "ven_resumocaixa "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "oper = 'T'";
            List<Deposito> arrayList = new ArrayList<Deposito>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                Deposito x = new Deposito();

                x.setDataRegistro(rs.getDate("data"));
                x.setLoja(rs.getString("loc"));
                //x.setObservacao(rs.getString("obs3"));
                x.setHora(rs.getString("hora"));
                x.setResponsavel(rs.getString("resp"));
                x.setOperador(rs.getString("operador"));
                x.setValorDinheiro(rs.getDouble("valor1"));
                x.setValorCheque(rs.getDouble("valor2"));
                x.setNdc(rs.getString("ndc"));
                x.setRecno(rs.getString("sr_recno"));

                arrayList.add(x);
            }
            rs.close();
            stmt.close();
            return arrayList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insereDeposito(Deposito x) {
        try {
            String sql = "insert ignore into "
                    + "fin_depositos "
                    + "(loja, "
                    + "data, "
                    + "hora, "
                    + "valorDinheiro, "
                    + "valorCheque, "
                    + "responsavel, "
                    + "caixa, "
                    + "ndc, "
                    + "recnoLoja)"
                    + "values "
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);

            stmt.setString(1, x.getLoja());
            stmt.setDate(2, new java.sql.Date(x.getDataRegistro().getTime()));
            stmt.setString(3, x.getHora());
            stmt.setDouble(4, x.getValorDinheiro());
            stmt.setDouble(5, x.getValorCheque());
            stmt.setString(6, x.getResponsavel());
            stmt.setString(7, x.getOperador());
            stmt.setString(8, x.getNdc());
            stmt.setString(9, x.getRecno());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
