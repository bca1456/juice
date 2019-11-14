package com.example.juice.service;

import com.example.juice.domain.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    void delete(int id);
    Car updateCar(Car car);
    List<Car> getAll();
}
