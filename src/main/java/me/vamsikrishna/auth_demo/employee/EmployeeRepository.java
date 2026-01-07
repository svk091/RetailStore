package me.vamsikrishna.auth_demo.employee;

import me.vamsikrishna.auth_demo.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
