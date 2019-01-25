/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dao;

import com.sg.CarDealership.dto.Vehicle;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author apprentice
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    @Query("SELECT v "
            + "FROM SearchCar v "
            + "WHERE (modelname = ?1) or (makename = ?1) "
            + "or (yearstr = ?1) and year between ?2 AND ?3 and salesprice between ?4 AND ?5")
    List<Vehicle>findBySearch(String search, int minyear, int maxyear, BigDecimal minprice, BigDecimal maxprice);
    
    @Query("SELECT v "
            + "FROM SearchCar v "
            + "WHERE year between ?1 AND ?2 and salesprice between ?3 and ?4")
    List<Vehicle>findBySearchInfo(int minyear, int maxyear, BigDecimal minprice, BigDecimal maxprice);
    

    
}
