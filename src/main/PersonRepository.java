package main;

import utils.DataBase;

import java.sql.*;

public class PersonRepository {
    /*repository classes are used to query or anything about db*/
    private static PersonRepository instance = null;

    private PersonRepository() {
    }

    public static PersonRepository getInstance() {
        if (instance == null) {
            instance = new PersonRepository();
            return instance;
        }
        return instance;
    }

    /*create person table query*/
    private static String CREATE_TABLE_QUERY =
            "create table person" +
                    "(id bigserial primary key," +
                    " firstname varchar(30)," +
                    " lastname varchar(30)," +
                    " national_code varchar(30)," +
                    " age int," +
                    " car_id bigint references car(id))";
    /*insert query from person*/
    private static String INSERT_WO_CAR =
            "insert into person" +
                    "(firstname, lastname, national_code, age) values" +
                    " (?, ?, ?, ?)";
    /*insert with car*/
    private static String INSERT_W_CAR =
            "insert into person" +
                    "(firstname, lastname, national_code, age, car_id) values" +
                    " (?, ?, ?, ?, ?)";
    /*buy car query*/
    private static String BUY_CAR =
            "update person set" +
                    " car_id = ?" +
                    " where id = ?";
    /*create person table.*/
    public int createTable() {
        try (Connection connection = DataBase.getInstance()) {
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
            meta = DataBase.getInstance().getMetaData();
            ResultSet resultSet = meta.getTables(null, null, "person", new String[]{"TABLE"});
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*insert data to person table*/
    public int insertWithoutCar(Person person) {
        try (Connection connection = DataBase.getInstance()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WO_CAR);
            preparedStatement.setString(1, person.getFirstname());
            preparedStatement.setString(2, person.getLastname());
            preparedStatement.setString(3, person.getNationalCode());
            preparedStatement.setInt(4, person.getAge());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertWithCar(Person person) {
        try (Connection connection = DataBase.getInstance()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_W_CAR);
            preparedStatement.setString(1, person.getFirstname());
            preparedStatement.setString(2, person.getLastname());
            preparedStatement.setString(3, person.getNationalCode());
            preparedStatement.setInt(4, person.getAge());
            preparedStatement.setLong(5, person.getCar().getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int buyCar(Person person) {
        try (Connection connection = DataBase.getInstance()){
            PreparedStatement preparedStatement = connection.prepareStatement(BUY_CAR);
            preparedStatement.setLong(1, person.getCar().getId());
            preparedStatement.setLong(2, person.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
