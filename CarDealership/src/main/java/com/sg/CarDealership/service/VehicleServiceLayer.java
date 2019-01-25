/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.VehicleRepository;
import com.sg.CarDealership.dto.Vehicle;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author Acer valued customer
 */
@Service
public class VehicleServiceLayer {
    @Autowired
    VehicleRepository vehicleRepo;
    
    //Vehicle 
    public Vehicle getVehicleById(int id) {
        return vehicleRepo.findById(id).orElse(null);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    public void deleteVehicleById(int id) {
        vehicleRepo.deleteById(id);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }
    public List<Vehicle> findBySearch(String search, int minyear, int maxyear, BigDecimal minprice, BigDecimal maxprice){
     if(search.isEmpty()){
         return vehicleRepo.findBySearchInfo(minyear, maxyear, minprice, maxprice);
         
     }else{
         return vehicleRepo.findBySearch(search, minyear, maxyear, minprice, maxprice);
     }
    }
    public File savePicture(MultipartFile picture) {
       File pictureToSave = null;
       String directory = "src/main/resources/static/images";
       StringBuilder fileName = new StringBuilder();
       Path path = Paths.get(directory, picture.getOriginalFilename());
       fileName.append(picture.getOriginalFilename());
       try{
           Path savePath = Files.write(path, picture.getBytes());
           pictureToSave = savePath.toFile();
       } catch(IOException ex){
           
       }
       return pictureToSave;
    }
    public String getFileExtension(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if(lastIndexOf == -1){
            return "";
        }
        return name.substring(lastIndexOf);
    }
    public String moveSavedPicture(Path picturePath, int vehicleId, String fileExtension) {
        String newFilePath = "";
        try{
            Path rename = Files.move(picturePath, picturePath.resolveSibling("inventory-" 
                    + vehicleId + fileExtension));
            String[] filePathArr = rename.toString().split("static");
            newFilePath = filePathArr[1];
        } catch(IOException ex) {
            
        }
        return newFilePath;
    }
}
