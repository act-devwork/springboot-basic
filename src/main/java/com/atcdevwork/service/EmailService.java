package com.atcdevwork.service;

import com.atcdevwork.entity.EmailEntity;

public interface EmailService {
  String sendTextEmail(EmailEntity email);
  String sendHtmlEmail(EmailEntity email);
  String sendAttachmentEmail(EmailEntity email);
}
