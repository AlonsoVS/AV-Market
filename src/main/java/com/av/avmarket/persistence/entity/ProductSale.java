package com.av.avmarket.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ProductSale {

  @EmbeddedId
  private ProductSalePK id;

  @Column(name = "cantidad")
  private Double quantity;

  @Column(name = "total")
  private Double total;

  @Column(name = "estado")
  private Boolean status;

  public ProductSalePK getId() {
    return id;
  }

  public void setId(ProductSalePK id) {
    this.id = id;
  }

  public Double getQuantity() {
    return quantity;
  }

  public void setQuantity(Double quantity) {
    this.quantity = quantity;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
