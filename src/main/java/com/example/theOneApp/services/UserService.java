package com.example.theOneApp.services;

import com.example.theOneApp.entity.User;
import com.example.theOneApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository1;

    public User saveUser(User user){
        return userRepository1.save(user);
    }

    public User findByUserName(String userName){
        return userRepository1.findByUserName(userName);
    }
//    get all users
    public List<User> getAllUsers(){
        return userRepository1.findAll();
    }
}
