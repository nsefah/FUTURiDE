/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.CarDealership.dto;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Acer valued customer
 */
@Entity
public class Contact {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String message;

  @Column
  private String email;

  @Column
  private String phone;

  public Contact() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 61 * hash + this.id;
    hash = 61 * hash + Objects.hashCode(this.name);
    hash = 61 * hash + Objects.hashCode(this.message);
    hash = 61 * hash + Objects.hashCode(this.email);
    hash = 61 * hash + Objects.hashCode(this.phone);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Contact other = (Contact) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    if (!Objects.equals(this.message, other.message)) {
      return false;
    }
    if (!Objects.equals(this.email, other.email)) {
      return false;
    }
    if (!Objects.equals(this.phone, other.phone)) {
      return false;
    }
    return true;
  }

}
