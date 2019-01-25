/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;


import com.sg.CarDealership.dao.SalesRepository;
import com.sg.CarDealership.dto.Sale;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer valued customer
 */
@Service
public class SaleServiceLayer {
    
  @Autowired
  SalesRepository saleRepo;

  public Sale getSaleById(int id) {
    return saleRepo.findById(id).orElse(null);
  }

  public List<Sale> getAllSales() {
    return saleRepo.findAll();
  }

  public Sale addSale(Sale sale) {
    return saleRepo.save(sale);
  }

  public void deleteSaleById(int id) {
    saleRepo.deleteById(id);
  }

  public Sale updateSale(Sale sale) {
    return saleRepo.save(sale);
  }
}
