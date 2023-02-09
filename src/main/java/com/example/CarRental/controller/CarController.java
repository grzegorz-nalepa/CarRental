package com.example.CarRental.controller;

import com.example.CarRental.model.Car;
import com.example.CarRental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @PutMapping("availability/{id}/{availability}")
    public Car updateCarAvailability(@PathVariable Long id, @PathVariable Boolean availability) {
        return carService.updateCarAvailability(id, availability);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/fuelType/{fuelType}")
    public List<Car> getCarsByFuelType(@PathVariable String fuelType) {
        return carService.getCarsByFuelType(fuelType);
    }

    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return carService.getCarsByBrand(brand);
    }

    @GetMapping("/model/{model}")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.getCarsByModel(model);
    }

    @GetMapping("/yearOfProduction/{yearOfProduction}")
    public List<Car> getCarsByYearOfProduction(@PathVariable int yearOfProduction) {
        return carService.getCarsByYearOfProduction(yearOfProduction);
    }

    @GetMapping("/engineCapacity/{engineCapacity}")
    public List<Car> getCarsByEngineCapacity(@PathVariable double engineCapacity) {
        return carService.getCarsByEngineCapacity(engineCapacity);
    }

    @GetMapping("/numberOfDoors/{numberOfDoors}")
    public List<Car> getCarsByNumberOfDoors(@PathVariable int numberOfDoors) {
        return carService.getCarsByNumberOfDoors(numberOfDoors);
    }

    @GetMapping("/pricePerDay/{pricePerDay}")
    public List<Car> getCarsByPricePerDay(@PathVariable double pricePerDay) {
        return carService.getCarsByPricePerDay(pricePerDay);
    }


}