/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.VehicleParts.BodyStyleRepository;
import com.sg.CarDealership.dao.VehicleParts.ExteriorColorRepository;
import com.sg.CarDealership.dao.VehicleParts.InteriorColorRepository;
import com.sg.CarDealership.dao.VehicleParts.PurchaseTypeRepository;
import com.sg.CarDealership.dao.VehicleParts.StateRepository;
import com.sg.CarDealership.dao.VehicleParts.TransmissionRepository;
import com.sg.CarDealership.dao.VehicleParts.TypeRepository;
import com.sg.CarDealership.dto.State;
import com.sg.CarDealership.dto.VehicleParts.BodyStyle;
import com.sg.CarDealership.dto.VehicleParts.ExteriorColor;
import com.sg.CarDealership.dto.VehicleParts.InteriorColor;
import com.sg.CarDealership.dto.VehicleParts.PurchaseType;
import com.sg.CarDealership.dto.VehicleParts.Transmission;
import com.sg.CarDealership.dto.VehicleParts.Type;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dalton Carter
 */
@Service
public class CarDealershipServiceLayer {

  @Autowired
  BodyStyleRepository bodyRepo;
  
  @Autowired
  ExteriorColorRepository excoRepo;
  
  @Autowired
  InteriorColorRepository incoRepo;
  
  @Autowired
  PurchaseTypeRepository purchaseRepo;
  
  @Autowired
  TransmissionRepository transmissionRepo;
  
  @Autowired
  TypeRepository typeRepo;
  
  @Autowired
  StateRepository stateRepo;
  
  //BodyStyle
    public BodyStyle getBodyStyleById(int id) {
        return bodyRepo.findById(id).orElse(null);
    }

    public List<BodyStyle> getAllBodyStyles() {
        return bodyRepo.findAll();
    }

    public BodyStyle addBodyStyle(BodyStyle vehicle) {
        return bodyRepo.save(vehicle);
    }

    public void deleteBodyStyleById(int id) {
        bodyRepo.deleteById(id);
    }

    public BodyStyle updateBodyStyle(BodyStyle body) {
        return bodyRepo.save(body);
    }
  //ExteriorColor
    public ExteriorColor getExteriorColorById(int id) {
        return excoRepo.findById(id).orElse(null);
    }

    public List<ExteriorColor> getAllExteriorColors() {
        return excoRepo.findAll();
    }

    public ExteriorColor addExteriorColor(ExteriorColor vehicle) {
        return excoRepo.save(vehicle);
    }

    public void deleteExteriorColorById(int id) {
        excoRepo.deleteById(id);
    }

    public ExteriorColor updateExteriorColor(ExteriorColor body) {
        return excoRepo.save(body);
    }
    //InteriorColor
    public InteriorColor getInteriorColorById(int id) {
        return incoRepo.findById(id).orElse(null);
    }

    public List<InteriorColor> getAllInteriorColors() {
        return incoRepo.findAll();
    }

    public InteriorColor addInteriorColor(InteriorColor vehicle) {
        return incoRepo.save(vehicle);
    }

    public void deleteInteriorColorById(int id) {
        incoRepo.deleteById(id);
    }

    public InteriorColor updateInteriorColor(InteriorColor body) {
        return incoRepo.save(body);
    }
    //Purchase Type
    public PurchaseType getPurchaseTypeById(int id) {
        return purchaseRepo.findById(id).orElse(null);
    }

    public List<PurchaseType> getAllPurchaseTypes() {
        return purchaseRepo.findAll();
    }

    public PurchaseType addPurchaseType(PurchaseType vehicle) {
        return purchaseRepo.save(vehicle);
    }

    public void deletePurchaseTypeById(int id) {
        purchaseRepo.deleteById(id);
    }

    public PurchaseType updatePurchaseType(PurchaseType body) {
        return purchaseRepo.save(body);
    }
     //Transmission
    public Transmission getTransmissionById(int id) {
        return transmissionRepo.findById(id).orElse(null);
    }

    public List<Transmission> getAllTransmissions() {
        return transmissionRepo.findAll();
    }

    public Transmission addTransmission(Transmission vehicle) {
        return transmissionRepo.save(vehicle);
    }

    public void deleteTransmissionById(int id) {
        transmissionRepo.deleteById(id);
    }

    public Transmission updateTransmission(Transmission body) {
        return transmissionRepo.save(body);
    }
     //Type
    public Type getTypeById(int id) {
        return typeRepo.findById(id).orElse(null);
    }

    public List<Type> getAllTypes() {
        return typeRepo.findAll();
    }

    public Type addType(Type vehicle) {
        return typeRepo.save(vehicle);
    }

    public void deleteTypeById(int id) {
        typeRepo.deleteById(id);
    }

    public Type updateType(Type body) {
        return typeRepo.save(body);
    }
     //State
    public State getStateById(int id) {
        return stateRepo.findById(id).orElse(null);
    }

    public List<State> getAllStates() {
        return stateRepo.findAll();
    }

    public State addState(State vehicle) {
        return stateRepo.save(vehicle);
    }

    public void deleteStateById(int id) {
        stateRepo.deleteById(id);
    }

    public State updateState(State body) {
        return stateRepo.save(body);
    }
  
  
 
}
