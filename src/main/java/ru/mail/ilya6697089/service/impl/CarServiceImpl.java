package ru.mail.ilya6697089.service.impl;

import java.lang.invoke.MethodHandles;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import ru.mail.ilya6697089.repository.ConnectionRepository;
import ru.mail.ilya6697089.repository.CarRepository;
import ru.mail.ilya6697089.repository.impl.ConnectionRepositoryImpl;
import ru.mail.ilya6697089.repository.impl.CarRepositoryImpl;
import ru.mail.ilya6697089.repository.model.Car;
import ru.mail.ilya6697089.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarServiceImpl implements CarService {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private ConnectionRepository connectionRepository = new ConnectionRepositoryImpl();
    private CarRepository carRepository = new CarRepositoryImpl();

    @Override
    public Car add(Car car) {
        try (Connection connection = connectionRepository.getConnection()) {
            connection.setAutoCommit(false);
            try {
                car = carRepository.add(connection, car);
                connection.commit();
                return car;
            } catch (SQLException e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Car> findAll() {
        try (Connection connection = connectionRepository.getConnection()) {
            connection.setAutoCommit(false);
            try {
                List<Car> vehicles = carRepository.findAll(connection);
                connection.commit();
                return vehicles;
            } catch (SQLException e) {
                connection.rollback();
                logger.error(e.getMessage(), e);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return Collections.emptyList();
    }

}
