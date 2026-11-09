package br.com.fsync.conexao;

import br.com.fsync.properties.PropertiesReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marcus
 */
public class CriaConexaoLanda {

    private static PropertiesReader reader = new PropertiesReader();

    public static String getValor(String chave) {
        return (String) reader.getValor(chave);
    }

    public static Connection getConexao() throws SQLException {
        try {
            String usuario = "landa";
            String senha = "landa2916";
            String schema = "landa";
            String servidor = "10.10.141.69:3309";

            if (reader.getValor("Loja").equals("AL")) {
                servidor = "landa.zapto.org:3309";
            } else {
                int lojaInt = Integer.parseInt(reader.getValor("Loja"));
                if (lojaInt > 4) {
                    servidor = "landa.zapto.org:3309";
                }
            }

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco de dados " + servidor);
            System.out.println("Usuário: " + usuario);
            System.out.println("Senha: " + senha);
            System.out.println("Base: " + schema);
            System.out.println("Servidor: " + servidor);

            String url = "jdbc:mysql://" + servidor + "/" + schema;
            String user = usuario;
            String password = senha;

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
}
