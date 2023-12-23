package com.ada.ecommerce;

import com.ada.ecommerce.entity.Category;
import com.ada.ecommerce.entity.Product;
import com.ada.ecommerce.repository.CategoryRepository;
import com.ada.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner setData (
			CategoryRepository categoryRepository,
			ProductRepository productRepository
	){
		return args -> {
			Category category = new Category();
      category.setName("Laptops");
			category.setDescription("64 de RAM, NVIDIA 9090Ti");
      categoryRepository.save(category);

			Category category2 = new Category();
			category2.setName("Mochila");
			category2.setDescription("Soporta 100 Kg");
			categoryRepository.save(category2);

			Product product = new Product();
			product.setName("Producto A");
			product.setDescription("Descripción del producto A");
			product.setStock(10);
			product.setPrice(1500.0);
			product.setImage_url("Http://imagen.com");
			product.setActive(true);
			product.setCategory(category);
			productRepository.save(product);
    };
	}
}
