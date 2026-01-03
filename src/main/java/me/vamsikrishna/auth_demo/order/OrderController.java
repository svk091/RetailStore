package me.vamsikrishna.auth_demo.order;

import jakarta.validation.Valid;
import me.vamsikrishna.auth_demo.order.dto.CreateOrderDto;
import me.vamsikrishna.auth_demo.order.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import me.vamsikrishna.auth_demo.order.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponseDto add(@RequestBody @Valid CreateOrderDto dto) {
        return orderService.create(dto);
    }
}
