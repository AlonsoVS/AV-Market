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
}
