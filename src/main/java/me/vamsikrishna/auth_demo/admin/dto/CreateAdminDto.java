package me.vamsikrishna.auth_demo.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public class CreateAdminDto {
    @NotNull String name;
    @NotNull @Email String email;

    public CreateAdminDto() {
    }

    public CreateAdminDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CreateAdminDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}