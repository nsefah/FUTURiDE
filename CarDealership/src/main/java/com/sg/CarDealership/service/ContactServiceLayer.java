/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dao.ContactRepository;
import com.sg.CarDealership.dto.Contact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Acer valued customer
 */
@Service
public class ContactServiceLayer {
    //Contact

    @Autowired
    ContactRepository contactRepo;

    public Contact getContactById(int id) {
        return contactRepo.findById(id).orElse(null);
    }

    public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

    public Contact addContact(Contact contact) {
        return contactRepo.save(contact);
    }

    public void deleteContactById(int id) {
        contactRepo.deleteById(id);
    }

    public Contact updateContact(Contact contact) {
        return contactRepo.save(contact);
    }

}
