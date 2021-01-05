package com.av.avmarket.persistence;

import com.av.avmarket.domain.Purchase;
import com.av.avmarket.domain.repository.PurchaseRepository;
import com.av.avmarket.persistence.Mapper.PurchaseMapper;
import com.av.avmarket.persistence.crud.SaleCrudRepository;
import com.av.avmarket.persistence.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepository implements PurchaseRepository {

  @Autowired
  private SaleCrudRepository saleCrudRepository;

  @Autowired
  private PurchaseMapper mapper;

  @Override
  public List<Purchase> getAll() {
    return mapper.toPurchases((List<Sale>) saleCrudRepository.findAll());
  }

  @Override
  public Optional<List<Purchase>> getByClient(String clientId) {
    return saleCrudRepository.findByClientId(clientId)
            .map(sales -> mapper.toPurchases(sales));
  }

  @Override
  public Purchase save(Purchase purchase) {
    Sale sale = mapper.toSale(purchase);
    sale.getProducts().forEach(product -> product.setSale(sale));
    return mapper.toPurchase(saleCrudRepository.save(sale));
  }
}
