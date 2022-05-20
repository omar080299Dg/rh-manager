package dev.niangfils.emplyee.management.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Object data;
    private int statuCode;
    private boolean error;
}
