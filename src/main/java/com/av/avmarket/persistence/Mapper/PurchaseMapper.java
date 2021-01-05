package com.av.avmarket.persistence.Mapper;

import com.av.avmarket.domain.Purchase;
import com.av.avmarket.persistence.entity.Sale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

  @Mappings({
          @Mapping(source = "saleId", target = "purchaseId"),
          @Mapping(source = "clientId", target = "clientId"),
          @Mapping(source = "date", target = "date"),
          @Mapping(source = "paymentMethod", target = "paymentMethod"),
          @Mapping(source = "comment", target = "comment"),
          @Mapping(source = "status", target = "state"),
          @Mapping(source = "products", target = "items")

  })
  Purchase toPurchase(Sale sale);
  List<Purchase> toPurchases(List<Sale> sales);

  @InheritInverseConfiguration
  @Mapping(target = "client", ignore = true)
  Sale toSale(Purchase purchase);
}
