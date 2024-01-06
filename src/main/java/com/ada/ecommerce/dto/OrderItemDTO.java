package com.ada.ecommerce.dto;

import com.ada.ecommerce.entity.Product;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderItemDTO {
  private Integer quantity;
  private UUID productId;

}
