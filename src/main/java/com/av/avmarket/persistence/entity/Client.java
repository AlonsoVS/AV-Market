package com.av.avmarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Client {

  @Id
  @Column(name = "id")
  private Integer clientId;

  @Column(name = "nombre")
  private String name;
  
  @Column(name = "apellidos")
  private String lastNames;

  @Column(name = "celular")
  private Double phoneNumber;

  @Column(name = "direccion")
  private String address;

  @Column(name = "correo_electronico")
  private String email;

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastNames() {
    return lastNames;
  }

  public void setLastNames(String lastNames) {
    this.lastNames = lastNames;
  }

  public Double getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Double phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}