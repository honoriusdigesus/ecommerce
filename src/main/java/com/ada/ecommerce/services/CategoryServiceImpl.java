package com.ada.ecommerce.services;

import com.ada.ecommerce.entity.Category;
import com.ada.ecommerce.repository.CategoryRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor //Inyectamos las dependencias por constructor
@Service
public class CategoryServiceImpl implements CategoryService{
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAll() {
    return categoryRepository.findAll();
  }
}
