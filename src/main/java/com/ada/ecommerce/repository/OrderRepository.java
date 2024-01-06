package com.ada.ecommerce.repository;

import com.ada.ecommerce.dto.OrderDTO;
import com.ada.ecommerce.entity.Order;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
