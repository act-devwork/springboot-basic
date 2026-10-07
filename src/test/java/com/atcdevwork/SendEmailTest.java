package com.atcdevwork;

import com.atcdevwork.util.EmailSenderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootTest
public class SendEmailTest {
  @Autowired
  private EmailSenderUtil emailSenderUtil;

  @Test
  void sendTextEmail() {
    String to = "anh@gmail.com";
    String subject = "Send Email Test";
    String content = "Hello World!";
    emailSenderUtil.sendTextEmail(to, subject, content);
  }

  @Test
  void sendHtmlEmail() throws IOException {
    String to = "anh@gmail.com";
    String subject = "Send Email Test";
    Resource resource = new ClassPathResource("/templates/email/otp-auth.html");
    String htmlContent = new String(resource.getInputStream().readAllBytes());
    emailSenderUtil.sendHtmlEmail(to, subject, htmlContent);
  }
}
