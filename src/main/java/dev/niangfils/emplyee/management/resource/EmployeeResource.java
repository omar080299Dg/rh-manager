package dev.niangfils.emplyee.management.resource;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.response.EmployeeResponse;
import dev.niangfils.emplyee.management.service.EmployeeService;
import dev.niangfils.emplyee.management.service.dto.EmployeeDTO;
import dev.niangfils.emplyee.management.service.mapper.EmployeeMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeResource(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping(value = "/all")
    public EmployeeResponse findAllEMployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        EmployeeResponse response = new EmployeeResponse();
        response.setData(employees);
        response.setError(false);
        response.setStatuCode(200);
        return response;
    }

    @GetMapping(value = "/employee/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        EmployeeResponse response = new EmployeeResponse();
        response.setData(employee);
        response.setError(false);
        response.setStatuCode(200);
        return response;
    }

    @PostMapping(value = "/add")
    public EmployeeResponse addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        Employee newEmployee = employeeService.addEmployee(employee);
        EmployeeResponse response = new EmployeeResponse();
        response.setStatuCode(200);
        response.setData(newEmployee);
        response.setError(false);
        return response;
    }

    @PutMapping(value = "update")
    public EmployeeResponse update(@RequestBody Employee employee) {
        Employee employee1 = employeeService.findEmployeeById(employee.getId());
        employee1.setImgUrl(employee.getImgUrl());
        employee1.setName(employee.getName());
        employee1.setEmail(employee.getEmail());
        employee1.setPhone(employee.getPhone());
        employee1.setJobTitile(employee.getJobTitile());
        Employee oldEmployee = employeeService.updateEmployee(employee1);
        EmployeeResponse response = new EmployeeResponse();
        response.setStatuCode(200);
        response.setData(oldEmployee);
        response.setError(false);
        return response;

    }

    @DeleteMapping(value = "/delete/{id}")
    public EmployeeResponse delete(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        EmployeeResponse response = new EmployeeResponse();
        response.setStatuCode(200);
        response.setData(null);
        response.setError(true);
        return response;

    }
}
