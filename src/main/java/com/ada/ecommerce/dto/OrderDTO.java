package com.ada.ecommerce.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderDTO {
  private String comment;

  @JsonProperty(access = Access.READ_ONLY)
  private double totalPrice;

  List<OrderItemDTO> items;
}
