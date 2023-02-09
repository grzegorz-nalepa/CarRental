package com.example.CarRental.service;

import com.example.CarRental.model.Car;
import com.example.CarRental.repository.CarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car car) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            existingCar.setBrand(car.getBrand());
            existingCar.setModel(car.getModel());
            existingCar.setYearOfProduction(car.getYearOfProduction());
            existingCar.setFuelType(car.getFuelType());
            existingCar.setEngineCapacity(car.getEngineCapacity());
            existingCar.setNumberOfDoors(car.getNumberOfDoors());
            existingCar.setPhoto(car.getPhoto());
            existingCar.setPricePerDay(car.getPricePerDay());
            existingCar.setAvailability(car.getAvailability());
            return carRepository.save(existingCar);
        }
        return null;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> getCarsByFuelType(String fuelType) {
        return carRepository.findByfuelType(fuelType);
    }

    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public List<Car> getCarsByModel(String model) {
        return carRepository.findByModel(model);
    }

    public List<Car> getCarsByYearOfProduction(int yearOfProduction) {
        return carRepository.findByYearOfProduction(yearOfProduction);
    }

    public List<Car> getCarsByEngineCapacity(double engineCapacity) {
        return carRepository.findByEngineCapacity(engineCapacity);
    }

    public List<Car> getCarsByNumberOfDoors(int numberOfDoors) {
        return carRepository.findByNumberOfDoors(numberOfDoors);
    }

    public List<Car> getCarsByPricePerDay(double pricePerDay) {
        return carRepository.findByPricePerDay(pricePerDay);
    }

    public Car updateCarAvailability(Long id, Boolean availability) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            existingCar.setBrand(existingCar.getBrand());
            existingCar.setModel(existingCar.getModel());
            existingCar.setYearOfProduction(existingCar.getYearOfProduction());
            existingCar.setFuelType(existingCar.getFuelType());
            existingCar.setEngineCapacity(existingCar.getEngineCapacity());
            existingCar.setNumberOfDoors(existingCar.getNumberOfDoors());
            existingCar.setPhoto(existingCar.getPhoto());
            existingCar.setPricePerDay(existingCar.getPricePerDay());
            existingCar.setAvailability(availability);
            return carRepository.save(existingCar);
        }
        return null;
    }
}
