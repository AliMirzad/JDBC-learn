package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    /*JDBC util*/
    private final static String url = "jdbc:postgresql://localhost:5454/";
    private final static String username = "postgres";
    private final static String password = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
