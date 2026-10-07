package com.atcdevwork.service.impl;

import com.atcdevwork.entity.EmailEntity;
import com.atcdevwork.service.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
  private static final String EMAIL_HOST = "anhct@gmail.com";

  @Autowired
  private JavaMailSender javaMailSender;

  @Override
  public String sendTextEmail(EmailEntity email) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(EMAIL_HOST);
    message.setTo(email.getToEmail());
    message.setSubject(email.getSubject());
    message.setText(email.getMessageBody());

    try {
      javaMailSender.send(message);
      System.out.println("Email sent successfully");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "Email sent successfully";
  }

  @Override
  public String sendHtmlEmail(EmailEntity email) {
    try {
      MimeMessage mimeMessage = javaMailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

      helper.setFrom(EMAIL_HOST);
      helper.setTo(email.getToEmail());
      helper.setSubject(email.getSubject());
      helper.setText(email.getMessageBody(), true);

      javaMailSender.send(mimeMessage);
      System.out.println("Email sent HTML successfully");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return "Email sent HTML successfully";
  }

  @Override
  public String sendAttachmentEmail(EmailEntity email) {
    return "";
  }
}
