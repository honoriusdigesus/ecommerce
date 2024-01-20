package com.ada.ecommerce.services;

import com.ada.ecommerce.dto.EmailNotificationDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService{
    private JavaMailSender javaMailSender;
    @Override
    public void send(EmailNotificationDTO emailNotificationDTO) {
        if (emailNotificationDTO.isHasTemplate()){
            sendTemplate(emailNotificationDTO);
        }else {
            sendPlainText(emailNotificationDTO);
        }
    }

    public void sendPlainText(EmailNotificationDTO email){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getBody());
        javaMailSender.send(mailMessage);
    }

    public void sendTemplate(EmailNotificationDTO email){
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        try {
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        javaMailSender.send(mailMessage);
    }
}
