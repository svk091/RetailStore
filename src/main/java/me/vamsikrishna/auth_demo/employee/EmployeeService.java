package me.vamsikrishna.auth_demo.employee;

import me.vamsikrishna.auth_demo.employee.domain.Employee;
import me.vamsikrishna.auth_demo.employee.dto.CreateEmployeeDto;
import me.vamsikrishna.auth_demo.employee.dto.EmployeeResponseDto;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public EmployeeResponseDto add(CreateEmployeeDto dto) {
        Employee employee = new Employee(dto.getName(), dto.getSalary());
        Employee savedEmployee = repo.save(employee);
        return new EmployeeResponseDto(savedEmployee.getId(), savedEmployee.getName(), savedEmployee.getJoiningDate(), savedEmployee.getSalary());
    }

    public EmployeeResponseDto getEmployeeById(int id) {
        Employee employee = repo.getReferenceById(id);
        return new EmployeeResponseDto(employee.getId(), employee.getName(), employee.getJoiningDate(), employee.getSalary());
    }
}
