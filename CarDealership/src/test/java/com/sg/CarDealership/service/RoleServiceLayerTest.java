/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.service;

import com.sg.CarDealership.dto.Role;
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
 * @author Acer valued customer
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceLayerTest {

    @Autowired
    RoleServiceLayer service;

    public RoleServiceLayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //List<Role> contacts = service.getAllRoles();
        //for(Role contact : contacts) {
          //  service.deleteRoleById(contact.getId());
        //}
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRoleById method, of class RoleServiceLayer.
     */
    @Test
    public void testGetRoleById() {
        //Role role = service.getRoleById(1);
        //assertEquals("Admin", role.getRole());

    }

    /**
     * Test of getAllRoles method, of class RoleServiceLayer.
     */
    @Test
    public void testGetAllRoles() {
        //List<Role> roles = service.getAllRoles();
        //assertEquals(3, roles.size());
    }

}
