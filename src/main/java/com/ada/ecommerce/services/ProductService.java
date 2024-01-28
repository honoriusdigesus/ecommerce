package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.PageDTO;
import com.ada.ecommerce.dto.ProductDTO;
import com.ada.ecommerce.entity.Product;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface  ProductService {
  Product save(ProductDTO product);
  Product getById(UUID uuid);

  Page<Product> getProduct(Pageable pageable); //Obtener productos paginados
  PageDTO<Product> getProductsFiltered(Double minPrice, Double maxPrice,Pageable pageable); //Obt ener productos filtrados

}
