package com.atcdevwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity // active spring web security
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails admin = User
        .withUsername("admin")
        .password("{noop}123") // raw
        .roles("admin", "user")
        //.authorities("ROLE_admin", "ROLE_user")
        .build();

    UserDetails user = User
        .withUsername("user")
        .password("{noop}222") //raw
        .roles("user")
        .build();

    return new InMemoryUserDetailsManager(admin, user);
  }
}
