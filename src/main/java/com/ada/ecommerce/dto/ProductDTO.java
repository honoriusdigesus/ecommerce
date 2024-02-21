package com.ada.ecommerce.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {

  @NotBlank(message = "Name con not blank")
  @Size(min = 1, max =70, message = "Name con be between 3 and 7 characters")
  private String name;

  @NotBlank(message = "Name con not blank")
  private String description;

  @URL
  private String image_url;

  @DecimalMin(value = "0.0", inclusive = false, message = "The price con not be negative")
  private double price;

  @Min(value = 1, message = "The stock can not be negative")
  private int stock;

  @NotNull
  private boolean active;

  @NotNull
  private UUID category_id;
}
