/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.controller;

import com.sg.CarDealership.dto.Contact;
import com.sg.CarDealership.service.ContactServiceLayer;
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
 * @author apprentice
 */
@Controller
public class ContactController {

    @Autowired
    ContactServiceLayer service;
    
    @GetMapping("contact")
    public String displayNewContact(Model model) {

        return "contact";
    }
    
    @PostMapping("contact")
    public String addContact(HttpServletRequest request) {
        String name = request.getParameter("name");
        String message = request.getParameter("message");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Contact contact = new Contact();
        contact.setName(name);
        contact.setMessage(message);
        contact.setEmail(email);
        contact.setPhone(phone);

        service.addContact(contact);

        return "redirect:contact";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("adminContact")
    public String displayContacts(Model model) {
        List<Contact> contacts = service.getAllContacts();
        model.addAttribute("contacts", contacts);
        return "adminContact";
    }

    @GetMapping("deleteContact")
    public String deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteContactById(id);
        return "redirect:adminContact";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("editContact")
    public String editContact(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contact = service.getContactById(id);

        model.addAttribute("contact", contact);
        return "editContact";
    }

    @PostMapping("editContact")
    public String performEditContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contact = service.getContactById(id);

        contact.setName(request.getParameter("name"));
        contact.setMessage(request.getParameter("message"));
        contact.setEmail(request.getParameter("email"));
        contact.setPhone(request.getParameter("phone"));

        service.updateContact(contact);

        return "redirect:adminContact";
    }
}
