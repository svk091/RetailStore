package me.vamsikrishna.auth_demo.customer;

import me.vamsikrishna.auth_demo.customer.domain.Customer;
import me.vamsikrishna.auth_demo.customer.dto.CreateCustomerDto;
import me.vamsikrishna.auth_demo.customer.dto.CustomerResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public CustomerResponseDto create(@RequestBody CreateCustomerDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Customer put(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}


// TODO: Give correct error responses