package com.atcdevwork.service;

import com.atcdevwork.entity.EmailEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class KafkaService {
  @Autowired
  private EmailService emailService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @KafkaListener(topics = "otp-auth-topic", groupId = "otp-group-id")
  public void listenOTP(String message) {
    try {
      /**
       * jsonNode
       * email
       * otp
       */
      JsonNode jsonNode = objectMapper.readTree(message);
      String email = jsonNode.get("email").asText();
      String otp = jsonNode.get("otp").asText();
      log.info("otp is {}", "email is {}", otp, email);

      EmailEntity  emailEntity = new EmailEntity();
      emailEntity.setToEmail(email);
      emailEntity.setSubject("Send OTP from KAFKA GO");
      emailEntity.setMessageBody("OTP is" + otp);

      String result = emailService.sendTextEmail(emailEntity);
      log.info("result is {}", "otp is {}", "email is {}", result, otp, email);

    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }
}
