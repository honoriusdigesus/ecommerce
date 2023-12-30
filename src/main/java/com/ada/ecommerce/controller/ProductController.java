package com.ada.ecommerce.controller;

import com.ada.ecommerce.dto.ProductDTO;
import com.ada.ecommerce.entity.Product;
import com.ada.ecommerce.services.ProductService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

  private final ProductService productService;

  @PostMapping
  public ResponseEntity<Product> save(@RequestBody ProductDTO productDTO) {
    Product product = productService.save(productDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(product);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Product> getById(@PathVariable UUID id) {
  Product product = productService.getById(id);
  return ResponseEntity
      .status(HttpStatus.OK)
      .body(product);
  }

  @GetMapping("/pageable")
  public ResponseEntity<Page<Product>> getProductsPageable(@RequestParam int page,@RequestParam int size){
    Pageable pageable = PageRequest.of(page, size);
    Page<Product> productPage = productService.getProduct(pageable);
    return ResponseEntity.status(HttpStatus.OK).body(productPage);
  }
}
