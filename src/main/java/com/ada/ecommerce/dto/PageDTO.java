package com.ada.ecommerce.dto;

import com.ada.ecommerce.entity.Product;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PageDTO<T> {
private List<Product> content;
private boolean lastPage;
private int pageNumber;
private int pageSize;
private int totalPages;
private int totalElements;
}
