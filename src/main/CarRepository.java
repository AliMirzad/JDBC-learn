package main;

import utils.DataBase;

import java.sql.*;

public class CarRepository {
    /*repository classes are used to query or anything about db*/
    private static CarRepository instance = null;

    private CarRepository() {
    }

    public static CarRepository getInstance() {
        if (instance == null) {
            instance = new CarRepository();
            return instance;
        }
        return instance;
    }

    /*create car table*/
    private static String CREATE =
            "create table car" +
                    "(id bigserial primary key, name varchar(50), model int)";

    /*insert car query*/
    private static String INSERT =
            "insert into car" +
                    "(name, model) values" +
                    " (?, ?)";

    /*create table method*/
    public int create() {
        try (Connection connection = DataBase.getInstance()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
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
            ResultSet resultSet = meta.getTables(null, null, "car", new String[]{"TABLE"});
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*insert method*/
    public int insert(Car car) {
        try (Connection connection = DataBase.getInstance()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getModel());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
