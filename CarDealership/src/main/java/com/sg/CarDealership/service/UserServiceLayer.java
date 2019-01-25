/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.UserRepository;
import com.sg.CarDealership.dto.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer valued customer
 */
@Service
public class UserServiceLayer {
     @Autowired
    UserRepository userRepo;

    //Users
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUserById(int id) {
        userRepo.deleteById(id);
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

}
