package br.com.fsync.dao;

import br.com.fsync.conexao.CriaConexaoLanda;
import br.com.fsync.objetos.Pendencia;
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
public class PendenciaDAO {

    // Inicia a conexão com o banco de dados
    private Connection conexaoLandA;

    // Construtor da classe VendaDao
    public PendenciaDAO() throws SQLException {
        this.conexaoLandA = CriaConexaoLanda.getConexao();
    }
    
    public List<Pendencia> listaRomaneiosNaoSeparados() {
        try {
            List<Pendencia> pd = new ArrayList<Pendencia>();
            String sql = "SELECT DISTINCT "
                    + "dataAgrupamento, "
                    + "origem, "
                    + "destino, "
                    + "COUNT(DISTINCT ndcLandA) as pendencias "
                    + "FROM "
                    + "est_pendenciasromaneiossaida "
                    + "WHERE "
                    + "status = '1' "
                    + "AND "
                    + "ndcLandA IS NOT NULL "
                    + "AND "
                    + "data >= '2024-01-01' "
                    + "GROUP BY "
                    + "dataAgrupamento, "
                    + "origem, "
                    + "destino "
                    + "ORDER BY "
                    + "origem, "
                    + "destino, "
                    + "data";
            PreparedStatement stmt = this.conexaoLandA.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            System.out.println("listaRomaneiosNaoSeparados(): " + rs.getStatement());

            while (rs.next()) {
                Pendencia f = new Pendencia();

                f.setData(rs.getDate("dataAgrupamento"));
                f.setOrigem(rs.getString("origem"));
                f.setDestino(rs.getString("destino"));
                f.setQuantidade(rs.getInt("pendencias"));

                pd.add(f);
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
