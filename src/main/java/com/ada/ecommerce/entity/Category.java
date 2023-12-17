package com.ada.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "categories") // Le damos el nombre a la tabla
public class Category {

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false, length = 50)
  private String name;
  private String description;

}
