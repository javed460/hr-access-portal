package com.company.hrportal.model;

import lombok.Data;

@Data
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
}