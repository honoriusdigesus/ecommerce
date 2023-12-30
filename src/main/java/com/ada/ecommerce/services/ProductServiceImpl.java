package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.ProductDTO;
import com.ada.ecommerce.entity.Category;
import com.ada.ecommerce.entity.Product;
import com.ada.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

  private ProductRepository productRepository;
  private CategoryService categoryService;

  @Override
  public Product save(ProductDTO productDTO) {
    Category category = categoryService.getById(productDTO.getCategory_id());
    Product product = new Product();
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setImage_url(productDTO.getImage_url());
    product.setPrice(productDTO.getPrice());
    product.setStock(productDTO.getStock());
    product.setActive(productDTO.isActive());
    product.setCategory(category);

    return productRepository.save(product);
  }

  @Override
  public Product getById(UUID uuid) {
    return productRepository.findById(uuid).orElseThrow(() -> new EntityNotFoundException("Product not found"));
  }

  @Override
  public Page<Product> getProduct(Pageable pageable) {
    return productRepository.findAll(pageable);
  }

  @Override
  public Page<Product> getProductsFiltered(Double minPrice, Double maxPrice, Pageable pageable) {
    return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
  }
}
