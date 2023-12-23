package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.Category;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
List<Category> getAll();
Category getById(UUID id);
}
