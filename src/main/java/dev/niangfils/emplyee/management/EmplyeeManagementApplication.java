package dev.niangfils.emplyee.management;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.repository.EmployeeRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class EmplyeeManagementApplication implements CommandLineRunner {
    private final EmployeeRespository employeeRespository;

    public EmplyeeManagementApplication(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EmplyeeManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setEmail("omar.niang@cauri.it");
        employee.setImgUrl("https://www.niangfils.png");
        employee.setJobTitile("Software engineer");
        employee.setPhone("+221 771221709");
        employee.setName("Oumar NIANG");
        employee.setEmployeeCode(UUID.randomUUID().toString());
       // employeeRespository.save(employee);
    }
}
