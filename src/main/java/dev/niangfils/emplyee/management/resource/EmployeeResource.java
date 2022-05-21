package dev.niangfils.emplyee.management.resource;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.response.EmployeeResponse;
import dev.niangfils.emplyee.management.service.EmployeeService;
import dev.niangfils.emplyee.management.service.dto.EmployeeDTO;
import dev.niangfils.emplyee.management.service.dto.UpdateEmployeeDTO;
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
    public List<Employee> findAllEMployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        EmployeeResponse response = new EmployeeResponse();
        response.setData(employees);
        response.setError(false);
        response.setStatuCode(200);
        return employees;
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        EmployeeResponse response = new EmployeeResponse();
        response.setData(employee);
        response.setError(false);
        response.setStatuCode(200);
        return employee;
    }

    @PostMapping(value = "/add")
    public Employee addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        Employee newEmployee = employeeService.addEmployee(employee);
        EmployeeResponse response = new EmployeeResponse();
        response.setStatuCode(200);
        response.setData(newEmployee);
        response.setError(false);
        return newEmployee;
    }

    @PutMapping(value = "update")
    public Employee update(@RequestBody UpdateEmployeeDTO updateEmployeeDTO) {
        Employee employee1 = employeeService.findEmployeeById(updateEmployeeDTO.getId());
        Employee newEmployee = employeeMapper.employeeToUpdateEmloyee(employee1, updateEmployeeDTO);
        Employee oldEmployee = employeeService.updateEmployee(newEmployee);
        EmployeeResponse response = new EmployeeResponse();
        response.setStatuCode(200);
        response.setData(oldEmployee);
        response.setError(false);
        return oldEmployee;

    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        EmployeeResponse response = new EmployeeResponse();
        response.setStatuCode(200);
        response.setData(null);
        response.setError(true);
        //  return response;

    }
}
