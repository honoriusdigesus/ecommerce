package com.ada.ecommerce.dto;


import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
  private String comment;
  List<OrderItemDTO> items;
}
