package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.entity.Order;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
String save(OrderDTO orderDTO);
OrderDTO getById(UUID uuid);
}
