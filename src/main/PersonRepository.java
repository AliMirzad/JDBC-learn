package main;

import utils.JDBC;

import java.sql.*;

public class PersonRepository {
    /*create person table query*/
    private static String CREATE_TABLE_QUERY =
            "create table person(id bigserial primary key," +
                    " firstname varchar(30)," +
                    " lastname varchar(30)," +
                    " national_code varchar(30)," +
                    " age int)";

    /*create person table.*/
    public void createTable() {
        try (Connection connection = JDBC.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*check if table exists before return true.*/
    public boolean checkTableExists() {
        DatabaseMetaData meta = null;
        try {
            meta = JDBC.getConnection().getMetaData();
            ResultSet resultSet = meta.getTables(null, null, "person", new String[] {"TABLE"});
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
