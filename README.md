# HR Access Portal
The HR Access Portal is a multi-tenant web application designed to demonstrate secure, organization-aware employee management. It leverages Keycloak 26 and the new Organizations feature to provide seamless, domain-based onboarding.

# 🛠 Tech Stack
Java 21

Spring Boot 3.4.1

Spring Security (OAuth2 Client)

Thymeleaf / Bootstrap (UI Layer)

# 🔑 Keycloak Setup (Required)
Before running the portal, ensure your Keycloak 26 instance is configured:

Realm: enterprise-hr-realm.

Client: hr-portal-client (Access Type: Confidential/Standard Flow).

Organizations: * Create Acme Corp with domain acme.com.

# 🏃 How to Run
Start Keycloak: Ensure it is running on 8080.

Start Employee Service: Ensure the backend is running on 8084.

Build & Run Portal:

Bash

mvn clean spring-boot:run

Access: Open http://localhost:8083 in your browser.