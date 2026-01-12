package com.company.hrportal.service;

import com.company.hrportal.model.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class EmployeeClientService {

    private final RestClient restClient;

    public EmployeeClientService(@Value("${services.employee-service.url}") String apiUrl) {
        this.restClient = RestClient.builder().baseUrl(apiUrl).build();
    }

    public List<Employee> getEmployees(@RegisteredOAuth2AuthorizedClient("keycloak") OAuth2AuthorizedClient authorizedClient) {
        return restClient.get()
                .header("Authorization", "Bearer " + authorizedClient.getAccessToken().getTokenValue())
                .retrieve()
                .body(new ParameterizedTypeReference<List<Employee>>() {});
    }
}