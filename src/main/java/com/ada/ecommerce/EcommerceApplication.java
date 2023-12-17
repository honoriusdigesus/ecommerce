package com.ada.ecommerce;

import com.ada.ecommerce.entity.Category;
import com.ada.ecommerce.repository.CategoryRepository;
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
	public CommandLineRunner setData (CategoryRepository categoryRepository){
		return args -> {
			Category category = new Category();
      category.setName("Laptops");
			category.setDescription("64 de RAM, NVIDIA 9090Ti");
      categoryRepository.save(category);

			Category category2 = new Category();
			category2.setName("Mochila");
			category2.setDescription("Soporta 100 Kg");
			categoryRepository.save(category2);
    };
	}
}
