package com.ada.ecommerce.mapper;

import com.ada.ecommerce.dto.PageDTO;
import com.ada.ecommerce.dto.ProductDTO;
import com.ada.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
  public PageDTO<Product> fromEntity(Page<Product> page){
    PageDTO<Product> pageDTO = new PageDTO();
    pageDTO.setContent(page.getContent());
    pageDTO.setPageNumber(page.getNumber());
    pageDTO.setPageSize(page.getSize());
    pageDTO.setLastPage(page.isLast());
    pageDTO.setTotalPages(page.getTotalPages());
    pageDTO.setTotalPages(page.getTotalPages());
    return pageDTO;
  }

  public Product fromDTO(ProductDTO productDTO){
    Product product = new Product();
    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setImage_url(productDTO.getImage_url());
    product.setPrice(productDTO.getPrice());
    product.setStock(productDTO.getStock());
    product.setActive(productDTO.isActive());

    return product;
  }

}
