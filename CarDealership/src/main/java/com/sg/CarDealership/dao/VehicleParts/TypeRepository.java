/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dao.VehicleParts;

import com.sg.CarDealership.dto.VehicleParts.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Acer valued customer
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Integer>{
    
}
