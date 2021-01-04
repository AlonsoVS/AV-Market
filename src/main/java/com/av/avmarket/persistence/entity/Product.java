package com.av.avmarket.persistence.entity;


import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_producto")
  private Integer productId;

  @Column(name = "nombre")
  private String name;

  @Column(name = "id_categoria")
  private Integer categoryId;

  @Column(name = "codigo_barras")
  private String barcode;

  @Column(name = "precio_venta")
  private Double salePrice;

  @Column(name = "cantidad_stock")
  private Integer stockQuantity;

  @Column(name = "estado")
  private Boolean status;

  @ManyToOne
  @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
  private Category category;


  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public Double getSalePrice() {
    return salePrice;
  }

  public void setSalePrice(Double salePrice) {
    this.salePrice = salePrice;
  }

  public Integer getStockQuantity() {
    return stockQuantity;
  }

  public void setStockQuantity(Integer stockQuantity) {
    this.stockQuantity = stockQuantity;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
