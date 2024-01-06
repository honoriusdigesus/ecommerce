package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
String save(OrderDTO orderDTO);

}
