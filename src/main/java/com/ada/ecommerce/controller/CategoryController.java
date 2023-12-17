package com.ada.ecommerce.controller;

import com.ada.ecommerce.entity.Category;
import com.ada.ecommerce.services.CategoryService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {
  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    List<Category> categories = categoryService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(categories);
  }

}
