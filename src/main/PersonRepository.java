package main;

import utils.JDBC;

import java.sql.*;

public class PersonRepository {
    /*repository classes are used to query or anything about db*/
    /*create person table query*/
    private static String CREATE_TABLE_QUERY =
            "create table person(id bigserial primary key," +
                    " firstname varchar(30)," +
                    " lastname varchar(30)," +
                    " national_code varchar(30)," +
                    " age int)";
    private static String INSERT =
            "insert into person" +
                    "(firstname, lastname, national_code, age) values" +
                    "(?, ?, ?, ?)";

    /*create person table.*/
    public int createTable() {
        try (Connection connection = JDBC.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*check if table exists before return true.*/
    public boolean checkTableExists() {
        DatabaseMetaData meta = null;
        try {
            meta = JDBC.getConnection().getMetaData();
            ResultSet resultSet = meta.getTables(null, null, "person", new String[]{"TABLE"});
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*insert data to person table*/
    public int insert(Person person) {
        try (Connection connection = JDBC.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, person.getFirstname());
            preparedStatement.setString(2, person.getLastname());
            preparedStatement.setString(3, person.getNationalCode());
            preparedStatement.setInt(4, person.getAge());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
