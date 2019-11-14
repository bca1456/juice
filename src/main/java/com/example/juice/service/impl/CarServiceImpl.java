package com.example.juice.service.impl;

import com.example.juice.domain.Car;
import com.example.juice.repos.CarRepository;
import com.example.juice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public Car updateCar(Car car) {
        Car newCar = new Car(car.getId(), car.getName(), car.getDriveUnit(), car.getMileage());
        this.delete(car.getId());
        return carRepository.save(newCar);
    }

    @Override
    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }
}
