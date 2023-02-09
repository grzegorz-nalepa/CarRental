package com.example.CarRental.repository;


import com.example.CarRental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findByfuelType(String fuelType);
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
    List<Car> findByYearOfProduction(int yearOfProduction);
    List<Car> findByEngineCapacity(double engineCapacity);
    List<Car> findByNumberOfDoors(int numberOfDoors);
    List<Car> findByPricePerDay(double pricePerDay);

}
