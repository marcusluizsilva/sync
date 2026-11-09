package br.com.fsync.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class CriaConexaoLoja02 {

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco de dados da Loja 02");
            return DriverManager.getConnection("jdbc:mysql://serv2/consys", "consys", "consys");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
