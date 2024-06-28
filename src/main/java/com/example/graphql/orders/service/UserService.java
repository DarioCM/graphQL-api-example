package com.example.graphql.orders.service;

import com.example.graphql.orders.entity.User;
import com.example.graphql.orders.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private  final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Add a method to get all users
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    // Add a method to save a user
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    // Add a method to delete a user
    public void deleteUser(Long userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }

    // Add a method to update a user
    public User updateUser(User user) {
        if (userRepo.existsById(user.getUserId())) {
            return userRepo.save(user);
        } else {
            throw  new IllegalArgumentException("User not found");
        }
    }



}
