package me.vamsikrishna.auth_demo.order;

import me.vamsikrishna.auth_demo.order.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
