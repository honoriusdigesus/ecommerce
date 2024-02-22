package com.ada.ecommerce.controller;

import com.ada.ecommerce.entity.Category;
import com.ada.ecommerce.exception.response.ErrorResponse;
import com.ada.ecommerce.services.CategoryService;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Category")
@AllArgsConstructor
@RestController
@RequestMapping("categories")
public class CategoryController {

  private final CategoryService categoryService;

  @Operation(summary = "Get all categories")
  @GetMapping
  public ResponseEntity<List<Category>> getAll() {
    List<Category> categories = categoryService.getAll();
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(categories);
  }

  @Operation(summary = "Get category by ID",
  responses = {
          @ApiResponse(
                  responseCode = "404",
                  description = "Category not found",
                  content = @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation = ErrorResponse.class)
                  )
          ),
          @ApiResponse(
                  responseCode = "200",
                  description = "Category found",
                  content = @Content(
                          mediaType = "application/json",
                          schema = @Schema(implementation = Category.class)
                  )
          )
  }
  )
  @GetMapping("/{id}")
  public ResponseEntity<Category> getById(
          @Parameter(description = "Id of the category to be searched")
          @PathVariable UUID id) {
    Category category = categoryService.getById(id);
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(category);
  }

}
