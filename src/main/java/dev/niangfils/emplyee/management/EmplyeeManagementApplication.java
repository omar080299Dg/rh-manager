package dev.niangfils.emplyee.management;

import dev.niangfils.emplyee.management.domain.Employee;
import dev.niangfils.emplyee.management.repository.EmployeeRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
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
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
