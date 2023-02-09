package com.example.CarRental.repository;

import com.example.CarRental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLoginAndPassword(String login, String password);
    User findByLogin(String login);
}