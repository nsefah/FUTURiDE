/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.controller;

import com.sg.CarDealership.dto.Sale;
import com.sg.CarDealership.dto.State;
import com.sg.CarDealership.dto.Vehicle;
import com.sg.CarDealership.dto.VehicleParts.PurchaseType;
import com.sg.CarDealership.service.CarDealershipServiceLayer;
import com.sg.CarDealership.service.MakeModelServiceLayer;
import com.sg.CarDealership.service.SaleServiceLayer;
import com.sg.CarDealership.service.VehicleServiceLayer;
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
public class SaleController {
    @Autowired
    SaleServiceLayer service;
    @Autowired
    VehicleServiceLayer vehicleService;
    @Autowired
    CarDealershipServiceLayer partsService;
    @Autowired
    MakeModelServiceLayer makeModelService;
    
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("sales/purchase")
    public String addNewSale(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        Sale sale = new Sale();
        model.addAttribute("sale", sale);
        //States
        List<State> states = partsService.getAllStates();
        model.addAttribute("states", states);
        //Purchase Types
        List<PurchaseType> purchases = partsService.getAllPurchaseTypes();
        model.addAttribute("purchases", purchases);
        return "sales/purchase";
    }
    
    @PostMapping("sales/purchase")
    public String addSale(HttpServletRequest request, Sale sale){
        int id = Integer.parseInt(request.getParameter("id"));
        Vehicle vehicle = vehicleService.getVehicleById(id);
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
        double price = Double.parseDouble(request.getParameter("purchaseprice"));
        sale.setPurchasePrice(price);
        sale.setZipCode(zipcode);
        sale.setVehicleId(vehicle);
        service.addSale(sale);
        vehicle.setIsavailable(0);
        vehicle.setIsfeatured(0);
        vehicleService.updateVehicle(vehicle);
         return "sales/index";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("reports/sales")
    public String displaySales(Model model){
        List<Sale> sales = service.getAllSales();
        model.addAttribute("sales", sales);
        return "reports/sales";
    }
    
}
