package me.vamsikrishna.auth_demo.order.dto;

import me.vamsikrishna.auth_demo.customer.dto.CustomerResponseDto;

import java.time.LocalDateTime;

public class OrderResponseDto {
    private int id;
    private CustomerResponseDto customerResponseDto;
    private LocalDateTime date;
    private long amount;
    private String name;

    public OrderResponseDto() {
    }

    public OrderResponseDto(int id,String name, CustomerResponseDto customerResponseDto, LocalDateTime date, long amount) {
        this.id = id;
        this.customerResponseDto = customerResponseDto;
        this.date = date;
        this.amount = amount;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerResponseDto getCustomerResponseDto() {
        return customerResponseDto;
    }

    public void setCustomerResponseDto(CustomerResponseDto customerResponseDto) {
        this.customerResponseDto = customerResponseDto;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{" +
                "id=" + id +
                ", customerResponseDto=" + customerResponseDto +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
