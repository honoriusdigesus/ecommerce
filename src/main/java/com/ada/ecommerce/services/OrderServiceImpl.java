package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.entity.Order;
import com.ada.ecommerce.entity.OrderItem;
import com.ada.ecommerce.repository.OrderRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

  private OrderRepository orderRepository;
  private ProductService productService;

  @Override
  public String save(OrderDTO orderDTO) {
    Order order = new Order();
    order.setComment(orderDTO.getComment());

    List<OrderItem> items = orderDTO.getItems().stream().map(item -> {
      OrderItem orderItems = new OrderItem();
      orderItems.setOrder(order);
      orderItems.setQuantity(item.getQuantity());
      orderItems.setProduct(productService.getById(item.getProductId()));
      return orderItems;
    }).toList();
    order.setItems(items);

    orderRepository.save(order);
    return "Order saved successfully";
  }
}
