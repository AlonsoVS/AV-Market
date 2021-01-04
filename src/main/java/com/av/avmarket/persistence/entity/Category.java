package com.av.avmarket.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_categoria")
  private Integer categoryId;

  @Column(name = "descripcion")
  private String description;

  @Column(name = "estado")
  private Boolean status;

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @OneToMany(mappedBy = "category")
  List<Product> products;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
