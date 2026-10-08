package com.atcdevwork.controller;

import jakarta.annotation.security.RolesAllowed;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
@RolesAllowed({"ADMIN"})
public class AdminController {

  @GetMapping("/vip")
  public String zoneVip() {
    return "zoneVip";
  }

  @GetMapping("/normal")
  public String zoneNormal() {
    return "zoneNormal";
  }

  @GetMapping("/info")
  public @Nullable Authentication getInfoUser() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
}
