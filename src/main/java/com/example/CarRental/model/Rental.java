package com.example.CarRental.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "wypozyczenia")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_samochodu")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "id_uzytkownika")
    private User user;

/*    @JoinColumn(name = "id_samochodu")
    private Integer idCar;

    @JoinColumn(name = "id_uzytkownika")
    private Integer idUser;*/

    @Column(name = "data_wypozyczenia")
    private LocalDate rentalDate;

    @Column(name = "data_zwrotu")
    private LocalDate returnDate;

    @Column(name = "koszt")
    private Double cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }*/

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}