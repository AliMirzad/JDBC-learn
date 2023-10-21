package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static DataBase instance;
    private Connection connection;

    private DataBase() {}

    private void init() throws SQLException {
        final String DB_URL = "jdbc:postgresql://localhost:5454/";
        final String USER = "postgres";
        final String PASS = "root";

        connection = DriverManager.getConnection(DB_URL, USER, PASS);

        System.out.println("Connected to database");
    }

    private Connection getConnection() {
        return connection;
    }

    public static Connection getInstance() throws SQLException {
        if (instance != null && !instance.getConnection().isClosed()) {
            return instance.getConnection();
        } else {
            instance = new DataBase();
            instance.init();
            return instance.getConnection();
        }
    }
}
