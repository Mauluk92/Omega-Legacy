package it.aleph.omega.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;

@FormAuthenticationMechanismDefinition(loginToContinue = @LoginToContinue)
@ApplicationScoped
public class SecurityConfig {
}
