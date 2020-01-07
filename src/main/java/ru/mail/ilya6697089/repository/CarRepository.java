package ru.mail.ilya6697089.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ru.mail.ilya6697089.repository.model.Car;

public interface CarRepository {

    Car add(Connection connection, Car car) throws SQLException;

    int getCount(Connection connection) throws SQLException;

    List<Car> findAll(Connection connection) throws SQLException;

    Car findByName(Connection connection, String searchName) throws SQLException;

}
