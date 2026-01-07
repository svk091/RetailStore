package me.vamsikrishna.auth_demo.order;

import jakarta.persistence.EntityNotFoundException;
import me.vamsikrishna.auth_demo.customer.CustomerRepository;
import me.vamsikrishna.auth_demo.customer.domain.Customer;
import me.vamsikrishna.auth_demo.customer.dto.CustomerResponseDto;
import me.vamsikrishna.auth_demo.order.domain.OrderEntity;
import me.vamsikrishna.auth_demo.order.dto.CreateOrderDto;
import me.vamsikrishna.auth_demo.order.dto.OrderResponseDto;
import org.aspectj.weaver.ast.Or;
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
        Customer customer = customerRepository.findById(dto.getCustomer_id())
                .orElseThrow(() ->  new EntityNotFoundException("Customer not found"));

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAmount(dto.getAmount());
        orderEntity.setName(dto.getName());
        customer.addOrder(orderEntity);

        OrderEntity order =  orderRepository.save(orderEntity);


        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setName(order.getName());
        orderResponseDto.setAmount(order.getAmount());
        orderResponseDto.setDate(order.getDate());
        orderResponseDto.setCustomerResponseDto(new CustomerResponseDto(customer.getId(), customer.getName(), customer.getPhone(), customer.getCredits()));

        return orderResponseDto;
    }

    public OrderResponseDto getOrderById(int id) {
        OrderEntity order =  orderRepository.getReferenceById(id);
        Customer customer = order.getCustomer();
        CustomerResponseDto customerResponseDto = new CustomerResponseDto(customer.getId(), customer.getName(), customer.getPhone(), customer.getCredits() );
        return  new OrderResponseDto(order.getId(), order.getName( ), customerResponseDto,order.getDate(), order.getAmount());
    }
}
