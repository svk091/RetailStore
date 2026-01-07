package me.vamsikrishna.auth_demo.order.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class CreateOrderDto {
    @NotNull(message = "You better give a name")
    private String name;
    @NotNull
    @Positive
    private Integer customer_id;
    @NotNull
    private long amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CreateOrderDto{" +
                "name='" + name + '\'' +
                ", customer_id=" + customer_id +
                ", amount=" + amount +
                '}';
    }
}
