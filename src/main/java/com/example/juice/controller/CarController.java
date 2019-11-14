package com.example.juice.controller;

import com.example.juice.domain.Car;
import com.example.juice.repos.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public @ResponseBody List<Car> allCars(){
        return (List<Car>) carRepository.findAll();
    }
}
