// Projeto feito por Gustavo Murai e Igor Murai

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Carregar explicitamente o driver do SQL Server
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String URL =
        "jdbc:sqlserver://localhost:1433;" +
        "databaseName=aulajava;" +
        "encrypt=false;trustServerCertificate=true";

    private static final String USER = "sa";
    private static final String PASSWORD = "123"; 

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

