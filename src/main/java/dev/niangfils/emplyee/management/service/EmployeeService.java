package dev.niangfils.emplyee.management.service;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.exception.UserNotFoundException;
import dev.niangfils.emplyee.management.repository.EmployeeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRespository employeeRespository;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        employeeRespository.save(employee);
        return employee;
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRespository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRespository.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRespository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void deleteEmployee(Long id) {
        Employee employee = findEmployeeById(id);

        if (employee == null) {
            throw new UserNotFoundException("employee not found");
        }
        employeeRespository.deleteById(id);
    }
}
