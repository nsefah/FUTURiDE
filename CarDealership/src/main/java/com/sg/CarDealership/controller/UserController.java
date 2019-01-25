/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.controller;

import com.sg.CarDealership.dto.User;
import com.sg.CarDealership.service.UserServiceLayer;
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
public class UserController {

  @Autowired
  UserServiceLayer service;

//    @GetMapping("admin/users")
//    public String displayNewUser(Model model) {
//
//        return "admin/users";
//    }
  @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/adduser")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        
        return "admin/adduser";
    }
    @PostMapping("admin/adduser")
    public String addUser(HttpServletRequest request) {
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        service.addUser(user);

        return "admin/users";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("admin/users")
    public String displayUsers(Model model) {
        List<User> users = service.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @GetMapping("deleteuser")
    public String deleteUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteUserById(id);
        return "redirect:adminuser";
    }
    @PreAuthorize("hasAnyRole('Admin')")
    @GetMapping("edituser")
    public String edituser(HttpServletRequest request, Model model) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.getUserById(id);

        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("edituser")
    public String performEditUser(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.getUserById(id);

        //user.setTitle(request.getParameter("title"));
        //user.setDescription(request.getParameter("description"));

        service.updateUser(user);

        return "redirect:adminuser";
    }
}
