package com.av.avmarket.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductSalePK implements Serializable {
  @Column(name = "id_compra")
  private Integer saleId;

  @Column(name = "id_producto")
  private Integer productId;

  public Integer getSaleId() {
    return saleId;
  }

  public void setSaleId(Integer saleId) {
    this.saleId = saleId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }
}
