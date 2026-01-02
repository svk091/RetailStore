package me.vamsikrishna.auth_demo.customer;

import me.vamsikrishna.auth_demo.customer.domain.Customer;
import me.vamsikrishna.auth_demo.customer.dto.CreateCustomerDto;
import me.vamsikrishna.auth_demo.customer.dto.CustomerResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public CustomerResponseDto getById(int id) {
        Customer customer = repo.getReferenceById(id);
        return new CustomerResponseDto(customer.getId(), customer.getName(), customer.getPhone(), customer.getCredits());
    }

    public CustomerResponseDto create(CreateCustomerDto dto) {
        Customer customer = new Customer(dto.getName(), dto.getPhone(), dto.getCredits());
        Customer saved =  repo.save(customer);
        return new CustomerResponseDto(saved.getId(), saved.getName(), saved.getPhone(), saved.getCredits());
    }

    public Customer update(Customer customer) {
        return  repo.save(customer);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
