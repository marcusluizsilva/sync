package br.com.fsync.dao;

import br.com.fsync.objetos.ControleDePonto;
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
public class EscalasDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoLanda;
    private String sql = "";
    
    // Construtor da classe VendaDao
    public EscalasDAO() throws SQLException {
        this.conexaoLanda = CriaConexaoLanda.getConexao();
    }

    public List<ControleDePonto> pesquisaAtrasoEntrada(Date data, String loja) {
        try {
            sql = "select "
                    + "c.nome, "
                    + "a.entrada as entradaEscala, "
                    + "b.entrada as entradaPonto, "
                    + "timediff(b.entrada, a.entrada) as atraso "
                    + "from "
                    + "rh_escalas a, "
                    + "rh_ponto b, "
                    + "funcionarios c "
                    + "where "
                    + "b.funcionario = a.funcionario "
                    + "and "
                    + "c.codigo = a.funcionario "
                    + "and "
                    + "a.data = ? "
                    + "and "
                    + "a.loja = ? "
                    + "and "
                    + "b.data = a.data "
                    + "and "
                    + "timediff(b.entrada, a.entrada) > '00:05'";
            List<ControleDePonto> lista = new ArrayList<ControleDePonto>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            stmt.setString(2, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                ControleDePonto x = new ControleDePonto();

                x.setNome(rs.getString("nome"));
                x.setEntrada(rs.getString("entradaEscala"));
                x.setEntradaRegistrada(rs.getString("entradaPonto"));
                x.setResultado(rs.getString("atraso"));

                lista.add(x);
            }
            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<ControleDePonto> pesquisaAtrasoLancheM(Date data, String loja) {
        try {
            sql = "select "
                    + "b.nome, "
                    + "a.saidaLancheManha, "
                    + "a.retornoLancheManha, "
                    + "timediff(a.retornoLancheManha, a.saidaLancheManha) as atraso "
                    + "from "
                    + "rh_ponto a, "
                    + "funcionarios b "
                    + "where "
                    + "b.codigo = a.funcionario "
                    + "and "
                    + "a.data = ? "
                    + "and "
                    + "a.loja = ? "
                    + "and "
                    + "timediff(a.retornoLancheManha, a.saidaLancheManha) > '00:16'";
            List<ControleDePonto> lista = new ArrayList<ControleDePonto>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            stmt.setString(2, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                ControleDePonto x = new ControleDePonto();

                x.setNome(rs.getString("nome"));
                x.setSaidaLancheManha(rs.getString("saidaLancheManha"));
                x.setRetornoLancheManha(rs.getString("retornoLancheManha"));
                x.setResultado(rs.getString("atraso"));

                lista.add(x);
            }
            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ControleDePonto> pesquisaAtrasoLancheT(Date data, String loja) {
        try {
            sql = "select "
                    + "b.nome, "
                    + "a.saidaLancheTarde, "
                    + "a.retornoLancheTarde, "
                    + "timediff(a.retornoLancheTarde, a.saidaLancheTarde) as atraso "
                    + "from "
                    + "rh_ponto a, "
                    + "funcionarios b "
                    + "where "
                    + "b.codigo = a.funcionario "
                    + "and "
                    + "a.data = ? "
                    + "and "
                    + "a.loja = ? "
                    + "and "
                    + "timediff(a.retornoLancheTarde, a.saidaLancheTarde) > '00:16'";
            List<ControleDePonto> lista = new ArrayList<ControleDePonto>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            stmt.setString(2, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                ControleDePonto x = new ControleDePonto();

                x.setNome(rs.getString("nome"));
                x.setSaidaLancheTarde(rs.getString("saidaLancheTarde"));
                x.setRetornoLancheTarde(rs.getString("retornoLancheTarde"));
                x.setResultado(rs.getString("atraso"));

                lista.add(x);
            }
            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ControleDePonto> pesquisaAtrasoAlmoco(Date data, String loja) {
        try {
            sql = "select "
                    + "b.nome, "
                    + "a.saidaAlmoco, "
                    + "a.retornoAlmoco, "
                    + "timediff(a.retornoAlmoco, a.saidaAlmoco) as atraso "
                    + "from "
                    + "rh_ponto a, "
                    + "funcionarios b "
                    + "where "
                    + "b.codigo = a.funcionario "
                    + "and "
                    + "a.data = ? "
                    + "and "
                    + "a.loja = ? "
                    + "and "
                    + "timediff(a.retornoAlmoco, a.saidaAlmoco) > '01:31'";
            List<ControleDePonto> lista = new ArrayList<ControleDePonto>();
            PreparedStatement stmt = this.conexaoLanda.prepareStatement(sql);
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            stmt.setString(2, loja);
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);

            while (rs.next()) {
                ControleDePonto x = new ControleDePonto();

                x.setNome(rs.getString("nome"));
                x.setSaidaAlmoco(rs.getString("saidaAlmoco"));
                x.setRetornoAlmoco(rs.getString("retornoAlmoco"));
                x.setResultado(rs.getString("atraso"));

                lista.add(x);
            }
            rs.close();
            stmt.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void fechaConexao() {
        try {
            this.conexaoLanda.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
