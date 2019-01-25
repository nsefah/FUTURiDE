/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.controller;

import com.sg.CarDealership.dto.Make;
import com.sg.CarDealership.dto.VehicleModel;
import com.sg.CarDealership.service.MakeModelServiceLayer;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Acer valued customer
 */
@Controller
public class MiscController {
   @Autowired
   MakeModelServiceLayer service;
   //make controls
   @PreAuthorize("hasAnyRole('Admin')")
   @GetMapping("admin/makes")
    public String addNewMake(Model model) {
        return "admin/makes";
    }

    @PostMapping("admin/makes")
    public String addMake(HttpServletRequest request) {
        String make = request.getParameter("make");

        Make special = new Make();
        special.setMake(make);

        service.addMake(special);

        return "redirect:makes";
    }
    
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/models")
    public String addNewVehicleModel(Model model) {
        VehicleModel vmodel = new VehicleModel();
        model.addAttribute("vmodel", vmodel);
        List<Make> makes = service.getAllMakes();
        model.addAttribute("makes", makes);
        return "admin/models";
    }
    //model controls
    @PostMapping("admin/models")
    public String addVehicleModel(VehicleModel vmodel) {
        
        //vmodel.setModel(model);
        //special.setMakeId(makeid);
        service.addModel(vmodel);

        return "redirect:models";
    }
          
}
