package com.atcdevwork.util;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderUtil {
  private static final String EMAIL_HOST = "anhct@gmail.com";

  @Autowired
  private JavaMailSender javaMailSender;

  public void sendTextEmail(String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(EMAIL_HOST);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);

    try {
      javaMailSender.send(message);
      System.out.println("Email sent successfully");
    } catch (Exception e) {
       throw new RuntimeException(e);
    }
  }

  public void sendHtmlEmail(String to, String subject, String content) {
    try {
      MimeMessage mimeMessage = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

      helper.setFrom(EMAIL_HOST);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content, true);

      javaMailSender.send(mimeMessage);
      System.out.println("Email sent HTML successfully");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
