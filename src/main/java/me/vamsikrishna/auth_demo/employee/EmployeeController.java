package me.vamsikrishna.auth_demo.employee;

import jakarta.validation.Valid;
import me.vamsikrishna.auth_demo.employee.dto.CreateEmployeeDto;
import me.vamsikrishna.auth_demo.employee.dto.EmployeeResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto getById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @PostMapping
    public EmployeeResponseDto create(@RequestBody @Valid CreateEmployeeDto dto) {
        return service.add(dto);
    }
}
