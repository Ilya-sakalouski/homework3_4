package ru.mail.ilya6697089.service;

import java.util.List;

import ru.mail.ilya6697089.repository.model.Car;

public interface CarService {

    Car add(Car car);

    List<Car> findAll();

}
