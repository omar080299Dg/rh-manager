package dev.niangfils.emplyee.management.service.dto;

import lombok.Data;

@Data
public class UpdateEmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private String jobTitile;
    private String imgUrl;
    private String phone;
    private String employeeCode;
}
