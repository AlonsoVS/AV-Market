package com.av.avmarket.web.controller;

import com.av.avmarket.domain.ProductDomain;
import com.av.avmarket.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping("/all")
  @ApiOperation("Get all products")
  @ApiResponse(code = 200, message = "OK")
  public ResponseEntity<List<ProductDomain>> getAll() {return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);}

  @GetMapping("/{id}")
  @ApiOperation("Search one product by id")
  @ApiResponses({
          @ApiResponse(code = 200, message = "OK"),
          @ApiResponse(code = 404, message = "PRODUCT NOT FOUND"),
  })
  public ResponseEntity<ProductDomain> getProduct(@ApiParam(value = "Id of the product", required = true, example = "7")
                                                    @PathVariable("id") int productId) {
    return productService.getProduct(productId)
            .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/category/{categoryId}")
  public ResponseEntity<List<ProductDomain>> getByCategory(@PathVariable("categoryId") int categoryId) {
    return productService.getByCategory(categoryId)
            .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/save")
  public ResponseEntity<ProductDomain> save(@RequestBody ProductDomain productDomain) {
    return new ResponseEntity<>(productService.save(productDomain), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity delete(@PathVariable("id") int productId) {
    if (productService.delete(productId)) {
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.NOT_FOUND);
  }
}
