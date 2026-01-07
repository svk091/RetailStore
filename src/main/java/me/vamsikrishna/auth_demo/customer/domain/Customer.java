package me.vamsikrishna.auth_demo.customer.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import me.vamsikrishna.auth_demo.order.domain.OrderEntity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String phone;
    private long credits = 0L;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderEntity> orders = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String phone, long credits) {
        this.name = name;
        this.phone = phone;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", credits=" + credits +
                ", orders=" + orders +
                '}';
    }

    public void setCredits(long credits) {
        this.credits = credits;
    }

    public void addOrder(OrderEntity order) {
        this.orders.add(order);
        order.setCustomer(this);
    }

    public void removeOrder(OrderEntity order) {
        this.orders.remove(order);
        order.setCustomer(null);
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

}
