package com.atcdevwork.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

  @GetMapping("/login")
  public ResponseEntity<String> login() {
    return ResponseEntity.ok("Login successful");
  }

  @GetMapping("/register")
  public ResponseEntity<String> register() {
    return ResponseEntity.ok("Register successful");
  }
}
