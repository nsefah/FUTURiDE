/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.controller;

import com.sg.CarDealership.dto.Special;
import com.sg.CarDealership.service.SpecialServiceLayer;
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
public class SpecialController {

    @Autowired
    SpecialServiceLayer service;

    @GetMapping("specials")
    public String displayNewSpecial(Model model) {

        return "specials";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/addspecial")
    public String addNewSpecial(Model model){
        return "addspecial";
    }

    @PostMapping("admin/addspecial")
    public String addSpecial(HttpServletRequest request) {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Special special = new Special();
        special.setTitle(title);
        special.setDescription(description);

        service.addSpecial(special);

        return "redirect:addspecial";
    }

    @GetMapping("home/specials")
    public String displaySpecials(Model model) {
        List<Special> specials = service.getAllSpecials();
        model.addAttribute("specials", specials);
        return "home/specials";
    }
    
    @GetMapping("admin/adminSpecials")
    public String displayAdminSpecials(Model model) {
        List<Special> specials = service.getAllSpecials();
        model.addAttribute("specials", specials);
        return "admin/adminSpecials";
    }

    @GetMapping("deleteSpecial")
    public String deleteSpecial(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteSpecialById(id);
        return "redirect:adminSpecials";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/editSpecial")
    public String editSpecial(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Special special = service.getSpecialById(id);

        model.addAttribute("special", special);
        return "admin/editSpecial";
    }

    @PostMapping("admin/editSpecial")
    public String performEditSpecial(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Special special = service.getSpecialById(id);

        special.setTitle(request.getParameter("title"));
        special.setDescription(request.getParameter("description"));

        service.updateSpecial(special);

        return "redirect:adminSpecials";
    }
}
