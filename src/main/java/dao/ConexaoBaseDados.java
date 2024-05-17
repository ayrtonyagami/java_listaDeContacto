package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ayrton.antonio
 */
public class ConexaoBaseDados {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:DBcontactos.db";    
    private static final String driverClass = "org.sqlite.JDBC";


    // Método para obter a conexão com o banco de dados
    public static Connection abrirConexao() throws SQLException {
        try {
            // Registrar o driver JDBC do SQLite
            Class.forName(driverClass);
            
            // Estabelecer a conexão com o banco de dados
            Connection conexao = DriverManager.getConnection(URL);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            // Tratar exceções
            throw new SQLException("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }    
}
