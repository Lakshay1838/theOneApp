package com.example.theOneApp.controllers;

import com.example.theOneApp.entity.User;
import com.example.theOneApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService1;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (user != null) {
            userService1.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> getAllUers(){
        List<User> users = userService1.getAllUsers();
//        User u = null;
//        System.out.println(u);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }
}
