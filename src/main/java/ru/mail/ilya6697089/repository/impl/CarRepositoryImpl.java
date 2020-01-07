package ru.mail.ilya6697089.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.mail.ilya6697089.repository.CarRepository;
import ru.mail.ilya6697089.repository.model.Car;

public class CarRepositoryImpl implements CarRepository {

    @Override
    public Car add(Connection connection, Car car) throws SQLException {
        try (
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO person(name, age, is_active) VALUES (?,?,?)",
                        Statement.RETURN_GENERATED_KEYS
                );
        ) {
            statement.setString(1, car.getName());
            statement.setInt(2, car.getAge());
            statement.setBoolean(3, car.getActive());
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating person failed, no rows affected.");
            }
            return car;
        }
    }

    @Override
    public int getCount(Connection connection) throws SQLException {
        try (
                Statement statement = connection.createStatement();
        ) {
            return statement.executeUpdate("SELECT COUNT(*) FROM person");
        }
    }

    @Override
    public List<Car> findAll(Connection connection) throws SQLException {
        try (
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("SELECT * FROM person")
        ) {
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = getCar(rs);
                cars.add(car);
            }
            return cars;
        }
    }

    @Override
    public Car findByName(Connection connection, String searchName) throws SQLException {
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM person WHERE name=?");
        ) {
            statement.setString(1, searchName);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return getCar(rs);
                }
            }
            return null;
        }
    }

    private Car getCar(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        Integer age = rs.getInt("age");
        Boolean isActive = rs.getBoolean("is_active");
        return Car.newBuilder()
                .name(name)
                .age(age)
                .isActive(isActive)
                .build();
    }

}
