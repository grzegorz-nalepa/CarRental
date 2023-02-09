package com.example.CarRental.service;

import com.example.CarRental.model.Car;
import com.example.CarRental.model.Rental;
import com.example.CarRental.model.User;
import com.example.CarRental.model.dto.RentalDto;
import com.example.CarRental.repository.CarRepository;
import com.example.CarRental.repository.RentalRepository;
import com.example.CarRental.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    public RentalService(RentalRepository rentalRepository, CarRepository carRepository, UserRepository userRepository) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental addRental(RentalDto rentalDto) {
        Car car = carRepository.findById(rentalDto.getIdCar()).orElseThrow(() -> new EntityNotFoundException("Car not found"));
        User user = userRepository.findById(rentalDto.getIdUser()).orElseThrow(() -> new EntityNotFoundException("User not found"));

        Rental rental = new Rental();
        rental.setCar(car);
        rental.setUser(user);
        rental.setRentalDate(rentalDto.getRentalDate());
        rental.setReturnDate(rentalDto.getReturnDate());
        rental.setCost(rentalDto.getCost());

        car.setAvailability(false);
        carRepository.save(car);

        return rentalRepository.save(rental);
    }


    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    /*public Rental updateRental(Long id, Rental rental) {
        Rental currentRental = rentalRepository.findById(id).orElse(null);
        if (currentRental != null) {
            currentRental.setIdCar(rental.getIdCar());
            currentRental.setIdUser(rental.getIdUser());
            currentRental.setRentalDate(rental.getRentalDate());
            currentRental.setReturnDate(rental.getReturnDate());
            currentRental.setCost(rental.getCost());
            return rentalRepository.save(currentRental);
        }
        return null;
    }*/

    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }


    public List<Rental> getRentalsByUserId(Long userId) {
        return rentalRepository.findByUserId(userId);
    }
}
