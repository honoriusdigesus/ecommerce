package com.ada.ecommerce.repository;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.entity.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

  @Query(value = "SELECT SUM(products.price * order_items.quantity) "
      + "FROM orders "
      + "JOIN order_items ON orders.id = order_items.order_id "
      + "JOIN products ON order_items.product_id = products.id "
      + "WHERE orders.id = ?1"
      ,
      nativeQuery = true)
  Double getTotalPriceByOrderId(String orderId);

  @Query(value = "select sum(p.price * oi.quantity) "
      + "from Order o "
      + "Join o.items oi "
      + "Join oi.product p "
      + "Where o.id = ?1")
  Double getTotalPrice(UUID orderId);
}
