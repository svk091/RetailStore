package me.vamsikrishna.auth_demo.customer.dto;

public class CustomerResponseDto {
    private int id;
    private String name;
    private String phone;
    private long credits;

    public CustomerResponseDto() {
    }

    public CustomerResponseDto(int id, String name, String phone, long credits) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setCredits(long credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "CustomerResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", credits=" + credits +
                '}';
    }
}
