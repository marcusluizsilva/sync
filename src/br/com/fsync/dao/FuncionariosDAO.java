package br.com.fsync.dao;

import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcus
 */
public class FuncionariosDAO {

    private Connection conexaoLandA;

    public FuncionariosDAO() throws SQLException {
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }

    public List<Funcionarios> listaReposicaoQuadro() {
        try {
            List<Funcionarios> pd = new ArrayList<Funcionarios>();
            String sql = "select "
                    + "a.loja, "
                    + "a.funcao, "
                    + "a.quadro, "
                    + "a.ativos, "
                    + "coalesce(a.ferias, 0) as ferias, "
                    + "coalesce(a.inss, 0) as inss, "
                    + "coalesce(a.atestado, 0) as atestado, "
                    + "coalesce(a.licencaMaternidade, 0) as licencaMaternidade, "
                    + "count(distinct a.loja) as lojas "
                    + "from "
                    + "rh_quadro a "
                    + "where "
                    + "ativos < a.quadro "
                    + "group by "
                    + "a.loja, "
                    + "a.funcao";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionarios x = new Funcionarios();
                x.setLoja(rs.getString("loja"));
                x.setFuncao(rs.getString("funcao"));
                x.setQuadroIdeal(rs.getInt("quadro"));
                x.setQuantidadeTotal(rs.getInt("ativos"));
                x.setQuantidadeAtestado(rs.getInt("atestado"));
                x.setQuantidadeFerias(rs.getInt("ferias"));
                x.setQuantidadeLicencaMaternidade(rs.getInt("licencaMaternidade"));
                x.setQuantidadeLicenciados(rs.getInt("inss"));
                x.setLojas(rs.getInt("lojas"));

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

    public void fechaConexao() {
        try {
            this.conexaoLandA.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
