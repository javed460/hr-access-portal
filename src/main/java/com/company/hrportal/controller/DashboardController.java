package com.company.hrportal.controller;

import com.company.hrportal.model.OrganizationInfo;
import com.company.hrportal.service.EmployeeClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    private final EmployeeClientService employeeService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, @AuthenticationPrincipal OidcUser principal) {
        String orgName = principal.getClaimAsString("organization");

        OrganizationInfo org = OrganizationInfo.builder()
                .name(orgName != null ? orgName : "Global Workforce")
                .id(principal.getClaimAsString("org_id"))
                .build();

        model.addAttribute("user", principal.getFullName());
        model.addAttribute("org", org);
        return "dashboard";
    }

    @GetMapping("/employees")
    public String employees(Model model,
                            @RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient client) {
        model.addAttribute("employees", employeeService.getEmployees(client));
        return "employees";
    }
}