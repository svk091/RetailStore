package me.vamsikrishna.auth_demo.order;


import me.vamsikrishna.auth_demo.customer.CustomerRepository;
import me.vamsikrishna.auth_demo.customer.domain.Customer;
import me.vamsikrishna.auth_demo.customer.dto.CustomerResponseDto;
import me.vamsikrishna.auth_demo.order.domain.OrderEntity;
import me.vamsikrishna.auth_demo.order.dto.CreateOrderDto;
import me.vamsikrishna.auth_demo.order.dto.OrderResponseDto;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public OrderResponseDto create(CreateOrderDto dto) {
        Customer customer = customerRepository.getReferenceById(dto.getCustomer_id());

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCustomer(customer);
        orderEntity.setAmount(dto.getAmount());
        orderEntity.setName(dto.getName());


        OrderEntity order =  orderRepository.save(orderEntity);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setName(order.getName());
        orderResponseDto.setAmount(order.getAmount());
        orderResponseDto.setDate(order.getDate());
        orderResponseDto.setCustomerResponseDto(new CustomerResponseDto(customer.getId(), customer.getName(), customer.getPhone(), customer.getCredits()));

        return orderResponseDto;
    }



}
