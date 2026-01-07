package me.vamsikrishna.auth_demo.employee.dto;


import jakarta.validation.constraints.NotNull;

public class CreateEmployeeDto {
    @NotNull
    private String name;
    @NotNull
    private long salary;

    public CreateEmployeeDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
