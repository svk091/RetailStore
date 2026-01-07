package me.vamsikrishna.auth_demo.admin;


import me.vamsikrishna.auth_demo.admin.domain.Admin;
import me.vamsikrishna.auth_demo.admin.dto.AdminResponseDto;
import me.vamsikrishna.auth_demo.admin.dto.CreateAdminDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AdminService {
    private final AdminRepository repo;

    public AdminService(AdminRepository repo) {
        this.repo = repo;
    }

    public AdminResponseDto add(CreateAdminDto dto) {
        Admin admin = new Admin(dto.getName(), dto.getEmail());
        Admin savedAdmin = repo.save(admin);

        return new AdminResponseDto(savedAdmin.getId(), savedAdmin.getName(), savedAdmin.getEmail());
    }


    public AdminResponseDto getById(int id) {
        Admin admin = repo.getReferenceById(id);
        return new AdminResponseDto(admin.getId(), admin.getName(), admin.getEmail());
    }
}
