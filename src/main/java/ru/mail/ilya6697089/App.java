package ru.mail.ilya6697089;

import java.lang.invoke.MethodHandles;
import java.util.List;

import ru.mail.ilya6697089.repository.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.ilya6697089.service.CarService;
import ru.mail.ilya6697089.service.impl.CarServiceImpl;
import ru.mail.ilya6697089.service.impl.Task1;

public class App {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        task1.runTask1();

//        CarService carService = new CarServiceImpl();
//
//        Car car = Car.newBuilder()
//                .name("test")
//                .age(10)
//                .isActive(true)
//                .build();
//        carService.add(car);
//
//        List<Car> vehicles = carService.findAll();
//        vehicles.forEach(logger::info);
    }

}
