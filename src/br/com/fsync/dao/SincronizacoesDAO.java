package br.com.fsync.dao;

import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.CMV;
import br.com.fsync.objetos.Mov;
import br.com.fsync.objetos.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcus Luiz
 */
public class SincronizacoesDAO {

    private Connection conexaoConsys;
    private Connection conexaoLandA;
    public String sql;

    public SincronizacoesDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }

    public List<CMV> selecionaHistres(String periodo1, String periodo2, String periodo3) {
        try {
            List<CMV> arrayList = new ArrayList<CMV>();
            sql = "select "
                    + "periodo, "
                    + "codigo, "
                    + "filial, "
                    + "coalesce(unidcomp, 0) as unidcomp, "
                    + "coalesce(qtven, 0) as qtven, "
                    + "sr_recno "
                    + "from "
                    + "histres "
                    + "where "
                    + "periodo in (?, ?, ?)";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            stmt.setString(1, periodo1);
            stmt.setString(2, periodo2);
            stmt.setString(3, periodo3);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                CMV x = new CMV() {
                };
                x.setPeriodo(rs.getString("periodo"));
                x.setCodigo(rs.getString("codigo"));
                x.setLoja(rs.getString("filial"));
                x.setQuantidadeVendida(rs.getInt("qtven"));
                x.setQuantidadeComprada(rs.getInt("unidcomp"));
                x.setRecno(rs.getString("sr_recno"));

                sincronizaHistres(x);

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

    public void zeraMediaVenda(String loja) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "mediaVenda" + loja + " = 0 ";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void sincronizaHistres(CMV x) throws SQLException {
        try {
            String sql = "insert ignore "
                    + "into "
                    + "ped_infoItem "
                    + "(periodo, "
                    + "codigo, "
                    + "loja, "
                    + "comprado, "
                    + "vendido, "
                    + "recno)"
                    + "values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.setString(1, x.getPeriodo());
            stmt.setString(2, x.getCodigo());
            stmt.setString(3, x.getLoja());
            stmt.setInt(4, x.getQuantidadeComprada());
            stmt.setInt(5, x.getQuantidadeVendida());
            stmt.setString(6, x.getRecno());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<Pedido> selecionaMediasVenda(String per1, String per2, String per3, String loja) {
        int i = 0;
        try {
            List<Pedido> arrayList = new ArrayList<Pedido>();
            sql = "select "
                    + "codigo, "
                    + "loja, "
                    + "sum(coalesce(vendido, 0))/3 as mediaVenda "
                    + "from "
                    + "ped_infoItem "
                    + "where "
                    + "periodo in (?, ?, ?) "
                    + "and "
                    + "loja = ? "
                    + "group by "
                    + "codigo";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setString(1, per1);
            stmt.setString(2, per2);
            stmt.setString(3, per3);
            stmt.setString(4, loja);
            ResultSet rs = stmt.executeQuery();

            PARLoja = loja;

            while (rs.next()) {
                Pedido x = new Pedido();

                x.setCodigo(rs.getString("codigo"));
                x.setMediaVenda01(rs.getInt("mediaVenda"));

                atualizaMediasVenda(x);

                System.out.println(i + " - " + rs.getString("codigo"));
                i = i + 1;

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

    public List<Mov> listaVendaLaboratorio() {
        try {
            List<Mov> arrayList = new ArrayList<Mov>();
            sql = "SELECT "
                    + "b.fabricante, "
                    + "ROUND(SUM(IF(COALESCE(a.oper, 'E') = 'E', "
                    + "a.valor, "
                    + "0)) - SUM(IF(COALESCE(a.oper, 'E') = 'A', "
                    + "a.valor, "
                    + "0)), 2) AS valor "
                    + "FROM "
                    + "bi_vendas a, "
                    + "produtos b "
                    + "WHERE "
                    + "b.codigo = a.codigo "
                    + "AND a.data >= date_add(curdate(), interval -180 day) "
                    + "GROUP BY b.fabricante "
                    + "ORDER BY (SUM(IF(COALESCE(a.oper, 'E') = 'E', "
                    + "a.valor, "
                    + "0)) - SUM(IF(COALESCE(a.oper, 'E') = 'A', "
                    + "a.valor, "
                    + "0))) DESC";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            int i = 1;
            double acumulado = 0;
            while (rs.next()) {

                Mov x = new Mov();
                x.setLaboratorio(rs.getString("fabricante"));
                x.setValorTotal(rs.getDouble("valor"));
                x.setQt(i);

                i = i + 1;
                acumulado = acumulado + x.getValorTotal();

                x.setValor2(acumulado);
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

    public List<Mov> listaRankingLaboratorio(String periodo) {
        try {
            List<Mov> arrayList = new ArrayList<Mov>();
            sql = "SELECT "
                    + "a.nome, "
                    + "a.acumulado, "
                    + "(SELECT SUM(vendido) FROM ven_metas WHERE vendedor LIKE 'L%' AND periodo BETWEEN (? - 5) AND ?) AS faturamento "
                    + "FROM "
                    + "est_laboratorios a "
                    + "ORDER BY "
                    + "a.ranking";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            stmt.setString(1, periodo);
            stmt.setString(2, periodo);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaRankingLaboratorio(): " + rs.getStatement());

            while (rs.next()) {

                Mov x = new Mov();
                x.setLaboratorio(rs.getString("nome"));
                x.setValor1(rs.getDouble("acumulado"));
                x.setValor2(rs.getDouble("faturamento"));

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

    String PARLoja;

    public void atualizaMediasVenda(Pedido x) throws SQLException {
        try {
            String sql = "update "
                    + "produtos "
                    + "set "
                    + "mediaVenda" + PARLoja + " = ? "
                    + "where "
                    + "codigo = ?";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.setInt(1, x.getMediaVenda01());
            stmt.setString(2, x.getCodigo());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void truncaLaboratorios() throws SQLException {
        try {
            String sql = "TRUNCATE TABLE est_laboratorios";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void informaRankingLaboratorio(Mov x) throws SQLException {
        try {
            String sql = "INSERT INTO est_laboratorios (nome, valor, ranking, acumulado) values (?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.setString(1, x.getLaboratorio());
            stmt.setDouble(2, x.getValorTotal());
            stmt.setDouble(3, x.getQt());
            stmt.setDouble(4, x.getValor2());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void informaPrioridadeLaboratorio(Mov x) throws SQLException {
        try {
            String sql = "UPDATE est_laboratorios SET prioritario = 'S' WHERE nome = ?";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);

            stmt.setString(1, x.getLaboratorio());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
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
