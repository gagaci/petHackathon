package com.company.pethackathon.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(EmailService.class);


    private final JavaMailSender mailSender;


    @Override
    @Async
    public void send(String to, String email, String token) {

        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper =
                    new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText("Confirm your account " + token, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject("Confirm your email");
            mimeMessageHelper.setFrom("bayramovxabibulloh@gmail.com");
            mailSender.send(mimeMessage);
//            return ResponseEntity.ok("Email verified successfully!");

        } catch (MessagingException e) {
            LOGGER.error("Failed to send email for: " + email + "\n" + e);
            throw new IllegalArgumentException("Failed to send email for: " + email);
        }
    }
}
