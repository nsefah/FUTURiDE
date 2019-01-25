/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dto;

import com.sg.CarDealership.dto.VehicleParts.BodyStyle;
import com.sg.CarDealership.dto.VehicleParts.ExteriorColor;
import com.sg.CarDealership.dto.VehicleParts.InteriorColor;
import com.sg.CarDealership.dto.VehicleParts.Transmission;
import com.sg.CarDealership.dto.VehicleParts.Type;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Acer valued customer
 */
@Entity(name = "vehicle")
public class Vehicle {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    //Elements consisting of actual tables 
    @ManyToOne
    @JoinColumn(name = "makeid", nullable = false)
    private Make makeId;
    @ManyToOne
    @JoinColumn(name = "modelid", nullable = false)
    private VehicleModel modelId;
    @ManyToOne
    @JoinColumn(name = "typeid", nullable = false)
    private Type typeId;
    @ManyToOne
    @JoinColumn(name = "exteriorcolorid", nullable = false)
    private ExteriorColor exteriorColorId;
    @ManyToOne
    @JoinColumn(name = "bodystyleid", nullable = false)
    private BodyStyle bodyStyleId;
    @ManyToOne
    @JoinColumn(name = "transmissionid", nullable = false)
    private Transmission transmissionId;
    @ManyToOne
    @JoinColumn(name = "interiorcolorid", nullable = false)
    private InteriorColor interiorColorsId;

    //individualized elements 
    @Column(nullable = false)
    private int year;
    @Column(nullable = false)
    private int mileage;
    @Column(nullable = true)
    private String vinnum;
    @Column(nullable = false)
    private BigDecimal MSRP;
    @Column(nullable = false)
    private BigDecimal salesprice;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int isfeatured;
    @Column(nullable = false)
    private int isavailable;
    @Column(nullable = true)
    private String imagepath;

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Make getMakeId() {
        return makeId;
    }

    public void setMakeId(Make makeId) {
        this.makeId = makeId;
    }

    public VehicleModel getModelId() {
        return modelId;
    }

    public void setModelId(VehicleModel modelId) {
        this.modelId = modelId;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    public ExteriorColor getExteriorColorId() {
        return exteriorColorId;
    }

    public void setExteriorColorId(ExteriorColor exteriorColorId) {
        this.exteriorColorId = exteriorColorId;
    }

    public BodyStyle getBodyStyleId() {
        return bodyStyleId;
    }

    public void setBodyStyleId(BodyStyle bodyStyleId) {
        this.bodyStyleId = bodyStyleId;
    }

    public Transmission getTransmissionId() {
        return transmissionId;
    }

    public void setTransmissionId(Transmission transmissionId) {
        this.transmissionId = transmissionId;
    }

    public InteriorColor getInteriorColorsId() {
        return interiorColorsId;
    }

    public void setInteriorColorsId(InteriorColor interiorColorsId) {
        this.interiorColorsId = interiorColorsId;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVinnum() {
        return vinnum;
    }

    public void setVinnum(String vinnum) {
        this.vinnum = vinnum;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }

    public BigDecimal getSalesprice() {
        return salesprice;
    }

    public void setSalesprice(BigDecimal salesprice) {
        this.salesprice = salesprice;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIsfeatured() {
        return isfeatured;
    }

    public void setIsfeatured(int isfeatured) {
        this.isfeatured = isfeatured;
    }

    public int getIsavailable() {
        return isavailable;
    }

    public void setIsavailable(int isavailable) {
        this.isavailable = isavailable;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    

}
