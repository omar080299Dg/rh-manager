package dev.niangfils.emplyee.management.service.mapper;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.service.dto.EmployeeDTO;
import dev.niangfils.emplyee.management.service.dto.UpdateEmployeeDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setName(employeeDTO.getName());
        employee.setJobTitile(employeeDTO.getJobTitile());
        employee.setImgUrl(employeeDTO.getImgUrl());
        return employee;

    }

    public Employee employeeToUpdateEmloyee(Employee employee,UpdateEmployeeDTO updateEmployeeDTO) {
        employee.setImgUrl(updateEmployeeDTO.getImgUrl());
        employee.setName(updateEmployeeDTO.getName());
        employee.setEmail(updateEmployeeDTO.getEmail());
        employee.setPhone(updateEmployeeDTO.getPhone());
        employee.setJobTitile(updateEmployeeDTO.getJobTitile());
        return employee;
    }
}
