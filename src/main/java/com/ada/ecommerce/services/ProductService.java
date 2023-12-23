package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.ProductDTO;
import com.ada.ecommerce.entity.Product;
import java.util.UUID;

public interface ProductService {
  Product save(ProductDTO product);
  Product getById(UUID uuid);

}
