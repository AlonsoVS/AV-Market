package com.av.avmarket.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "compras")
public class Sale {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_compra")
  private Integer saleId;

  @Column(name = "id_cliente")
  private String clientId;

  @Column(name = "fecha")
  private LocalDateTime date;

  @Column(name = "medio_pago")
  private Character paymentMethod;

  @Column(name = "comentario")
  private String comment;

  @Column(name = "estado")
  private Character status;

  public Integer getSaleId() {
    return saleId;
  }

  public void setSaleId(Integer saleId) {
    this.saleId = saleId;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Character getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(Character paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Character getStatus() {
    return status;
  }

  public void setStatus(Character status) {
    this.status = status;
  }
}