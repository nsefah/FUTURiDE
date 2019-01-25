/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dto.VehicleParts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Acer valued customer
 */
@Entity(name = "purchasetype")
public class PurchaseType {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name ="purchasetype")
    private String purchasetype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchasetype() {
        return purchasetype;
    }

    public void setPurchasetype(String purchaseType) {
        this.purchasetype = purchasetype;
    }

}
