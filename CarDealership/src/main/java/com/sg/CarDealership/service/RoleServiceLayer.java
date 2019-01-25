/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.RoleRepository;
import com.sg.CarDealership.dto.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer valued customer
 */
@Service
public class RoleServiceLayer {

  @Autowired
  RoleRepository roleRepo;

  public Role getRoleById(int id) {
    return roleRepo.findById(id).orElse(null);
  }

  public List<Role> getAllRoles() {
    return roleRepo.findAll();
  }

  public Role addRole(Role role) {
    return roleRepo.save(role);
  }

  public void deleteRoleById(int id) {
    roleRepo.deleteById(id);
  }

  public Role updateRole(Role role) {
    return roleRepo.save(role);
  }
  
}
