package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.dto.OrderItemDTO;
import com.ada.ecommerce.entity.Order;
import com.ada.ecommerce.entity.OrderItem;
import com.ada.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
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

    Order orderSaved = orderRepository.save(order);
    return "Order saved successfully with id: " + orderSaved.getId();
  }

  @Override
  public OrderDTO getById(UUID uuid) {
    Order order = orderRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("Order not found"));

    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setComment(order.getComment());

    List<OrderItemDTO> itemsDTO = order.getItems().stream().map( orderItem -> {
      OrderItemDTO itemDTO = new OrderItemDTO();
      itemDTO.setQuantity(orderItem.getQuantity());
      itemDTO.setProductId(orderItem.getProduct().getId());
      return itemDTO;
    }).toList();
    orderDTO.setItems(itemsDTO);
    orderDTO.setTotalPrice(orderRepository.getTotalPrice(uuid));
    return orderDTO;
  }
}
