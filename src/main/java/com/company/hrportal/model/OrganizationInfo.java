package com.company.hrportal.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationInfo {
    private String name;
    private String id;
    private String preferredTheme;
}