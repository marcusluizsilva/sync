package br.com.fsync.dao;

import br.com.fsync.objetos.PedidoTelefone;
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
public class AloSaudeDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLandA;
    public String sql;
    

    // Construtor da classe VendaDao
    public AloSaudeDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }
    
    //
    public int at01 = 0;
    public double v01 = 0;
    public int at02 = 0;
    public double v02 = 0;
    public int at03 = 0;
    public double v03 = 0;
    public int at04 = 0;
    public double v04 = 0;
    public int at05 = 0;
    public double v05 = 0;
    public int at06 = 0;
    public double v06 = 0;
    public int at07 = 0;
    public double v07 = 0;
    public int atWeb = 0;
    public double vWeb = 0;
    public int atG = 0;
    public double vG = 0;

    /*public List<PedidoTelefone> somaWebtele(Date dataI, Date dataF) {

        try {
            sql = "SELECT "
                    + "data, "
                    + "SUM(valor) as valorVenda, "
                    + "COUNT(*) as atendimentos "
                    + "FROM "
                    + "entrega "
                    + "where "
                    + "status = '5' "
                    + "and "
                    + "data between ? and ? "
                    + "and "
                    + "codiweb is null "
                    + "and "
                    + "sr_deleted = '' "
                    + "group by data";

            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoWebtele.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {

                PedidoTelefone p = new PedidoTelefone();
                p.setData(rs.getDate("data"));
                p.setConferido(rs.getString("atendimentos"));
                p.setValor(rs.getDouble("valorVenda"));
                p.setLoja("01");
                p.setAtendimentos(rs.getInt("atendimentos"));

                at01 = at01 + Integer.parseInt(rs.getString("atendimentos"));
                v01 = v01 + rs.getDouble("valorVenda");

// Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    /*public List<PedidoTelefone> somaWebloja(Date dataI, Date dataF) {

        try {
            List<PedidoTelefone> pd = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoWebtele.prepareStatement(""
                    + "SELECT "
                    + "data, "
                    + "SUM(valor) as valorVenda, "
                    + "COUNT(*) as atendimentos "
                    + "FROM "
                    + "entrega "
                    + "where "
                    + "status = '5' "
                    + "and "
                    + "data between ? and ? "
                    + "and "
                    + "codiweb is not null "
                    + "and "
                    + "sr_deleted = '' "
                    + "group by data");
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                PedidoTelefone p = new PedidoTelefone();
                p.setData(rs.getDate("data"));
                p.setConferido(rs.getString("atendimentos"));
                p.setValor(rs.getDouble("valorVenda"));
                p.setLoja("01");
                p.setAtendimentos(rs.getInt("atendimentos"));

                atWeb = atWeb + Integer.parseInt(rs.getString("atendimentos"));
                vWeb = vWeb + rs.getDouble("valorVenda");

// Adicionando o objeto à lista
                pd.add(p);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    
    public List<PedidoTelefone> listaPedidosRegiao(Date dataI, Date dataF) {
        try {
            this.conexaoLandA = CriaConexaoLanda.getConexao();
            sql = "select "
                    + "coalesce(filial, substr(ndc, 1, 2)) as filial, "
                    + "data, "
                    + "count(*) as atendimentos, "
                    + "sum(coalesce(valor,0)) as valorVenda "
                    + "from "
                    + "ent_pedidos "
                    + "where "
                    + "data between ? and ? "
                    + "and "
                    + "status = '5' "
                    + "group by "
                    + "filial "
                    + "order by "
                    + "filial";

            List<PedidoTelefone> arrayList = new ArrayList<PedidoTelefone>();
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(dataI.getTime()));
            stmt.setDate(2, new java.sql.Date(dataF.getTime()));
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.getStatement());

            while (rs.next()) {
                PedidoTelefone x = new PedidoTelefone();
                x.setLoja(rs.getString("filial"));
                x.setValor(rs.getDouble("valorVenda"));
                x.setAtendimentos(rs.getInt("atendimentos"));
                x.setData(rs.getDate("data"));

                if (rs.getString("filial").equals("01")) {
                    at01 = at01 + Integer.parseInt(rs.getString("atendimentos"));
                    v01 = v01 + rs.getDouble("valorVenda");
                } else if (rs.getString("filial").equals("02")) {
                    at02 = at02 + Integer.parseInt(rs.getString("atendimentos"));
                    v02 = v02 + rs.getDouble("valorVenda");
                } else if (rs.getString("filial").equals("03")) {
                    at03 = at03 + Integer.parseInt(rs.getString("atendimentos"));
                    v03 = v03 + rs.getDouble("valorVenda");
                } else if (rs.getString("filial").equals("04")) {
                    at04 = at04 + Integer.parseInt(rs.getString("atendimentos"));
                    v04 = v04 + rs.getDouble("valorVenda");
                } else if (rs.getString("filial").equals("05")) {
                    at05 = at05 + Integer.parseInt(rs.getString("atendimentos"));
                    v05 = v05 + rs.getDouble("valorVenda");
                } else if (rs.getString("filial").equals("06")) {
                    at06 = at06 + Integer.parseInt(rs.getString("atendimentos"));
                    v06 = v06 + rs.getDouble("valorVenda");
                } else if (rs.getString("filial").equals("07")) {
                    at07 = at07 + Integer.parseInt(rs.getString("atendimentos"));
                    v07 = v07 + rs.getDouble("valorVenda");
                }

                atG = atG + Integer.parseInt(rs.getString("atendimentos"));
                vG = vG + rs.getDouble("valorVenda");

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
            this.conexaoLandA.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
