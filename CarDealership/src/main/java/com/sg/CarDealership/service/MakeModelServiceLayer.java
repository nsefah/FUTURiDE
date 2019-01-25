/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.MakeRepository;
import com.sg.CarDealership.dao.ModelRepository;
import com.sg.CarDealership.dto.Make;
import com.sg.CarDealership.dto.VehicleModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer valued customer
 */
@Service
public class MakeModelServiceLayer {
        //Make

    @Autowired
    MakeRepository makeRepo;
    @Autowired
    ModelRepository modelRepo;

    public Make getMakeById(int id) {
        return makeRepo.findById(id).orElse(null);
    }

    public List<Make> getAllMakes() {
        return makeRepo.findAll();
    }

    public Make addMake(Make make) {
        return makeRepo.save(make);
    }

    public void deleteMakeById(int id) {
        makeRepo.deleteById(id);
    }

    public Make updateMake(Make make) {
        return makeRepo.save(make);
    }
    //Model
    
    public VehicleModel getModelById(int id) {
        return modelRepo.findById(id).orElse(null);
    }

    public List<VehicleModel> getAllModels() {
        return modelRepo.findAll();
    }

    public VehicleModel addModel(VehicleModel make) {
        return modelRepo.save(make);
    }

    public void deleteModelById(int id) {
        modelRepo.deleteById(id);
    }

    public VehicleModel updateModel(VehicleModel make) {
        return modelRepo.save(make);
    }

}
