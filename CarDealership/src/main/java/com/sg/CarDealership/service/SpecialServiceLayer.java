/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.SpecialRepository;
import com.sg.CarDealership.dto.Special;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer valued customer
 */
@Service
public class SpecialServiceLayer {

    @Autowired
    SpecialRepository specialRepo;

    //Specials
    public Special getSpecialById(int id) {
        return specialRepo.findById(id).orElse(null);
    }

    public List<Special> getAllSpecials() {
        return specialRepo.findAll();
    }

    public Special addSpecial(Special special) {
        return specialRepo.save(special);
    }

    public void deleteSpecialById(int id) {
        specialRepo.deleteById(id);
    }

    public Special updateSpecial(Special special) {
        return specialRepo.save(special);
    }

}
