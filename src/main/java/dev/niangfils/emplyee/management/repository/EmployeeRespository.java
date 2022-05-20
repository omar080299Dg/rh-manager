package dev.niangfils.emplyee.management.repository;

import dev.niangfils.emplyee.management.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
}
