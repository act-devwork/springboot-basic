package com.atcdevwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // active spring web security
@EnableMethodSecurity(jsr250Enabled = true)
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // tach FE va BE
    http.formLogin((formLogin) -> formLogin.loginProcessingUrl("/login"));

    http.authorizeHttpRequests(req -> req
        .requestMatchers("/v1/auth/login", "/v1/auth/register")
        .permitAll()
        .anyRequest().authenticated()
    );
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails admin = User
        .withUsername("admin")
        .password("{noop}123") // raw
//        .roles("admin", "user")
        .authorities("ROLE_ADMIN", "ROLE_USER")
        .build();

    UserDetails user = User
        .withUsername("user")
        .password("{noop}222") //raw
//        .roles("user")
        .authorities("ROLE_USER")
        .build();

    return new InMemoryUserDetailsManager(admin, user);
  }
}
