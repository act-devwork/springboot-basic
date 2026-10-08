package com.atcdevwork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

  @GetMapping("/vip")
  public String zoneVip() {
    return "zoneVip";
  }

  @GetMapping("/normal")
  public String zoneNormal() {
    return "zoneNormal";
  }
}
