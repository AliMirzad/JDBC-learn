package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    /*postgres url*/
    private final static String url = "jdbc:postgresql://localhost:5454/";
    /*postgres username*/
    private final static String username = "postgres";
    /*postgres password*/
    private final static String password = "root";

    /*create connection between db and app*/
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
