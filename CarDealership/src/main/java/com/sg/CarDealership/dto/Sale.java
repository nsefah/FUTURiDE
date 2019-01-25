/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dto;

import com.sg.CarDealership.dto.VehicleParts.PurchaseType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Acer valued customer
 */
@Entity
public class Sale {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(nullable = false)
    //@NotBlank(message = "Purchaser must not be empty.")
    //@Size(min = 2, max = 30, message = "Purchaser must be more than 2 characters and less than 30 characters.")
    private String purchaser;

    @Column
    @Email
    private String email;

    @Column
    @Digits(integer = 10, fraction = 0)
    private String phone;

    @Column(nullable = false)
    //@NotBlank(message = "Street1 must not be empty.")
    //@Size(max = 50, message = "Street1 must be less than 50 characters.")
    private String street1;
    
    @Column
    private String street2;

    @Column(nullable = false)
    //@NotBlank(message = "City must not be empty.")
    //@Size(max = 30, message = "City must be less than 30 characters.")
    private String city;

    @Column(name = "zipcode")
    @Digits(integer = 5, fraction = 0)
    private int zipCode;
    
    @Column(nullable = false, name = "purchaseprice")
    public double purchasePrice;
    
    @Column(nullable = false, name = "purchasedate")
    public LocalDateTime purchaseDate;
    
    @ManyToOne
    @JoinColumn(name = "stateid", nullable = false)
    public State stateId;
    
    @ManyToOne
    @JoinColumn(name = "purchasetypeid", nullable = false)
    public PurchaseType purchaseTypeId;
    
    
    @ManyToOne
    @JoinColumn(name = "vehicleid", nullable = false)
    public Vehicle vehicleId;
    
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    public User userId;

    public Sale() {
        purchaseDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public State getStateId() {
        return stateId;
    }

    public void setStateId(State stateId) {
        this.stateId = stateId;
    }

    public PurchaseType getPurchaseTypeId() {
        return purchaseTypeId;
    }

    public void setPurchaseTypeId(PurchaseType purchaseTypeId) {
        this.purchaseTypeId = purchaseTypeId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

}