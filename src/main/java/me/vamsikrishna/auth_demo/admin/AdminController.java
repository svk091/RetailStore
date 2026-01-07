package me.vamsikrishna.auth_demo.admin;


import me.vamsikrishna.auth_demo.admin.dto.AdminResponseDto;
import me.vamsikrishna.auth_demo.admin.dto.CreateAdminDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final  AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @PostMapping
    public AdminResponseDto create(@RequestBody CreateAdminDto dto) {
        return  service.add(dto);
    }

    @GetMapping("/{id}")
    public AdminResponseDto get(@PathVariable int id) {
        return service.getById(id);
    }
}
