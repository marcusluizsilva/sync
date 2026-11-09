package br.com.fsync.dao;

import br.com.fsync.objetos.Departamentos;
import br.com.fsync.conexao.CriaConexaoConsys;
import br.com.fsync.conexao.CriaConexaoLanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marcus
 */
public class DepartamentosDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoConsys;
    private Connection conexaoLandA;

    // Declaração de variáveis
    public String sql;
    public String campo;

    // Construtor da classe VendaDao
    public DepartamentosDAO() throws SQLException {
        this.conexaoConsys = CriaConexaoConsys.getConexao();
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }

    /* Busca os departamentos cadastrados no schema Conys e chama os métodos
     que os inserem e atualizam no schema LandA
     */
    public List<Departamentos> listaDepartamentosConsys() {
        try {
            List<Departamentos> pd = new ArrayList<Departamentos>();
            sql = "select "
                    + "a.codigo, "
                    + "a.nome, "
                    + "a.sr_recno, "
                    + "a.sr_deleted, "
                    + "b.codigo as codArea, "
                    + "b.nome as descArea, "
                    + "c.codigo as codCat, "
                    + "c.nome as descCat "
                    + "from "
                    + "departs a, "
                    + "areas b, "
                    + "catego c "
                    + "where "
                    + "b.codigo = a.codare "
                    + "and "
                    + "c.codigo = a.codcat "
                    + "order by "
                    + "nome";
            PreparedStatement stmt = this.conexaoConsys.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Departamentos x = new Departamentos();
                x.setCodigo(rs.getString("codigo"));
                x.setNome(rs.getString("nome"));
                x.setRecno(rs.getString("sr_recno"));
                x.setStatus(rs.getString("sr_deleted"));
                x.setArea(rs.getString("descArea"));
                x.setCodigoArea(rs.getString("codArea"));
                x.setCategoria(rs.getString("descCat"));
                x.setCodigoCategoria(rs.getString("codCat"));

                // Adicionando o objeto à lista
                pd.add(x);
            }
            rs.close();
            stmt.close();
            return pd;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Insere os departamentos cadastrados no schema CONSYS no schema LandA
    public void insereDepartamento(Departamentos x) {
        try {
            String sql = "insert ignore into departamentos(codigo, nome, recno, codArea, descArea, codigoCategoria, categoria) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);
            stmt.setString(1, x.getCodigo());
            stmt.setString(2, x.getNome());
            stmt.setString(3, x.getRecno());
            stmt.setString(4, x.getCodigoArea());
            stmt.setString(5, x.getArea());
            stmt.setString(6, x.getCodigoCategoria());
            stmt.setString(7, x.getCategoria());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao inserir departamento: " + ex, "LandA", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Atualiza os departamentos no schema LandA
    public void atualizaDepartamento(Departamentos x) {
        try {
            // Prepara a conexão com o banco de dados
            String sql = "update departamentos set codigo = ?, nome = ?, deletado = ?, codArea = ?, descArea = ?, codigoCategoria = ?, categoria = ? where recno = ?";
            PreparedStatement stmt = conexaoLandA.prepareStatement(sql);
            stmt.setString(1, x.getCodigo());
            stmt.setString(2, x.getNome());
            stmt.setString(3, x.getStatus());
            stmt.setString(4, x.getCodigoArea());
            stmt.setString(5, x.getArea());
            stmt.setString(6, x.getCodigoCategoria());
            stmt.setString(7, x.getCategoria());
            stmt.setString(8, x.getRecno());

            // Executa o código sql
            stmt.execute();
            stmt.close();
            
            sql = "update produtos set area = ? where departamento = ?";
            stmt = conexaoLandA.prepareStatement(sql);
            stmt.setString(1, x.getArea());
            stmt.setString(2, x.getNome());

            // Executa o código sql
            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar departamento: " + ex, "LandA", JOptionPane.ERROR_MESSAGE);
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
