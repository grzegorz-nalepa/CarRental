package com.example.CarRental.controller;

import com.example.CarRental.model.Rental;
import com.example.CarRental.model.dto.RentalDto;
import com.example.CarRental.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }

    @PostMapping
    public ResponseEntity<Rental> addRental(@RequestBody RentalDto rentalDto) {
        Rental rental = rentalService.addRental(rentalDto);
        return new ResponseEntity<>(rental, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Rental getRentalById(@PathVariable Long id) {
        return rentalService.getRentalById(id);
    }

    /*@PutMapping("/{id}")
    public Rental updateRental(@PathVariable Long id, @RequestBody Rental rental) {
        return rentalService.updateRental(id, rental);
    }*/

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
    }

    @GetMapping("/user/{userId}")
    public List<Rental> getRentalsByUserId(@PathVariable Long userId) {
        return rentalService.getRentalsByUserId(userId);
    }
}
