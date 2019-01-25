/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Acer valued customer
 */
@Entity
public class Make {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    @Column(nullable = false)
    @NotBlank(message = "Make must not be empty.")
    @Size(min = 1, max = 30, message = "Make must be between 1 and 30 characters.")
    private String make;
    
//     
//    @OneToMany
//    @JoinColumn(name="makeid")
//    private List<VehicleModel> models;

    public Make() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

//    public List<VehicleModel> getModels() {
//        return models;
//    }
//
//    public void setModels(List<VehicleModel> models) {
//        this.models = models;
//    }
//    
    
}
