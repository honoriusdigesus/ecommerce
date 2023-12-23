package com.ada.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
  private String name;
  private String description;
  private String image_url;
  private double price;
  private int stock;
  private boolean active;
  private UUID category_id;
}
