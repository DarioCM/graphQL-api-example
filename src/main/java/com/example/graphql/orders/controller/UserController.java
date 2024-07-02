package com.example.graphql.orders.controller;

import com.example.graphql.orders.entity.User;
import com.example.graphql.orders.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    //  This is a form of dependency injection called constructor injection
    // When Spring creates an instance of UserController, it will also
    // create an instance of UserService and pass it to the UserController's constructor.
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // add methods to get all users, save a user, delete a user, and update a user
    // These methods will be used to handle the GraphQL queries and mutations

    // create user
    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone, @Argument String password) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        return userService.saveUser(user);
    }

    // get all users
    @QueryMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    // get user by id
    @QueryMapping
    public User getUserById(@Argument Long userId) {
        return userService.getUserById(userId);
    }

    // delete user
    @MutationMapping
    public void deleteUser(@Argument Long userId) {
         userService.deleteUser(userId);
    }



}
