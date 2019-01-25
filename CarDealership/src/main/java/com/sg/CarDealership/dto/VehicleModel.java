/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Acer valued customer
 */
@Entity(name = "model")
public class VehicleModel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "Model must not be empty.")
    @Size(max = 30, message = "Model name must be more than 2 characters and less than 30 characters.")
    private String model;
    
    @ManyToOne
    @JoinColumn(name = "makeid", nullable = false)
    private Make makeId;

    public VehicleModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Make getMakeId() {
        return makeId;
    }

    public void setMakeId(Make makeId) {
        this.makeId = makeId;
    }

   

}
