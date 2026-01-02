package me.vamsikrishna.auth_demo.customer.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateCustomerDto {

    @NotBlank
    private String name;

    @NotBlank
    private String phone;
    private long credits;

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

    public void setCredits(long credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "CreateCustomerDto{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", credits=" + credits +
                '}';
    }
}
