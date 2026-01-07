package me.vamsikrishna.auth_demo.admin;

import me.vamsikrishna.auth_demo.admin.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
