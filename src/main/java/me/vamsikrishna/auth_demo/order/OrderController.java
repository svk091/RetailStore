package me.vamsikrishna.auth_demo.order;

import me.vamsikrishna.auth_demo.order.dto.CreateOrderDto;
import me.vamsikrishna.auth_demo.order.dto.OrderResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderResponseDto add(@RequestBody @Validated CreateOrderDto dto) {
        return orderService.create(dto);
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable  int id) {
        return orderService.getOrderById(id);
    }
}
