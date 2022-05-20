package dev.niangfils.emplyee.management.service.mapper;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.service.dto.EmployeeDTO;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhone(employeeDTO.getPhone());
        employee.setName(employeeDTO.getName());
        employee.setJobTitile(employeeDTO.getJobTitile());
        employee.setImgUrl(employeeDTO.getImgUrl());
        return  employee;

    }
}
