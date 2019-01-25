/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dto.Contact;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Dalton Carter
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarDealershipServiceLayerTest {
    
    @Autowired
    ContactServiceLayer service;
    
    public CarDealershipServiceLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
       List<Contact> contacts = service.getAllContacts();
        for(Contact contact : contacts) {
            service.deleteContactById(contact.getId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getVehicleById method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testGetVehicleById() {
    }

    /**
     * Test of getAllVehicles method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testGetAllVehicles() {
    }

    /**
     * Test of addVehicle method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testAddVehicle() {
    }

    /**
     * Test of deleteVehicleById method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testDeleteVehicleById() {
    }

    /**
     * Test of updateVehicle method, of class CarDealershipServiceLayer.
     */
    @Test
    public void testUpdateVehicle() {
    }

    /**
     * Test of getContactById method, of class CarDealershipServiceLayer.
     */
//    @Test
//    public void testGetContactById() {
//        Contact contact = new Contact();
//        contact.setName("Bob");
//        contact.setMessage("message");
//        contact.setEmail("email@gmail.com");
//        contact.setPhone("555-555-5555");
//        service.addContact(contact);
//        
//        assertEquals(contact, service.getContactById(contact.getId()));
//    }
//
//    /**
//     * Test of getAllContacts method, of class CarDealershipServiceLayer.
//     */
//    @Test
//    public void testGetAllContacts() {
//        assertEquals(0, service.getAllContacts().size());
//        Contact contact = new Contact();
//        contact.setName("Bob");
//        contact.setMessage("message");
//        contact.setEmail("email@gmail.com");
//        contact.setPhone("555-555-5555");
//        service.addContact(contact);
//        assertEquals(1, service.getAllContacts().size());
//        
//          Contact contact2 = new Contact();
//        contact2.setName("John");
//        contact2.setMessage(" john message");
//        contact2.setEmail("john@gmail.com");
//        contact2.setPhone("555-555-5557");
//        service.addContact(contact2);
//        assertEquals(2, service.getAllContacts().size());
//    }
//
//    /**
//     * Test of addContact method, of class CarDealershipServiceLayer.
//     */
//    @Test
//    public void testAddContact() {
//        assertEquals(0, service.getAllContacts().size());
//        Contact contact = new Contact();
//        contact.setName("Bob");
//        contact.setMessage("message");
//        contact.setEmail("email@gmail.com");
//        contact.setPhone("555-555-5555");
//        service.addContact(contact);
//        assertEquals(1, service.getAllContacts().size());
//    }
//
//    /**
//     * Test of deleteContactById method, of class CarDealershipServiceLayer.
//     */
//    @Test
//    public void testDeleteContactById() {
//        assertEquals(0, service.getAllContacts().size());
//        Contact contact = new Contact();
//        contact.setName("Bob");
//        contact.setMessage("message");
//        contact.setEmail("email@gmail.com");
//        contact.setPhone("555-555-5555");
//        service.addContact(contact);
//        assertEquals(1, service.getAllContacts().size());
//        
//        service.deleteContactById(contact.getId());
//        assertEquals(0, service.getAllContacts().size());
//    }
//
//    /**
//     * Test of updateContact method, of class CarDealershipServiceLayer.
//     */
//    @Test
//    public void testUpdateContact() {
//        Contact contact = new Contact();
//        contact.setName("Bob");
//        contact.setMessage("message");
//        contact.setEmail("email@gmail.com");
//        contact.setPhone("555-555-5555");
//        service.addContact(contact);
//        
//        contact.setName("John");
//        contact.setMessage("John Message");
//        contact.setEmail("John@gmail.com");
//        contact.setPhone("111-111-1111");
//        service.updateContact(contact);
//        
//        assertEquals("John", service.getContactById(contact.getId()).getName());
//        assertEquals("John Message", service.getContactById(contact.getId()).getMessage());
//        assertEquals("John@gmail.com", service.getContactById(contact.getId()).getEmail());
//        assertEquals("111-111-1111", service.getContactById(contact.getId()).getPhone());
//    }
//    
}
