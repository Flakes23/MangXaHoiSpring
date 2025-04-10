package com.nhom6.mxh.Services.ServiceImpls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nhom6.mxh.Models.Mail;
import com.nhom6.mxh.Services.Service.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    
    @Value("${spring.mail.username}") // Lấy email gửi mặc định từ cấu hình
    private String defaultMailFrom;

    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) {
        try {
            log.info("📧 Sending email to: {}", mail.getMailFrom());

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getMailSubject()); // Tiêu đề email
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom())); // Người gửi
            mimeMessageHelper.setTo(mail.getMailTo()); // Người nhận
            mimeMessageHelper.setText(mail.getMailContent(), true); // Nội dung (có thể là HTML)

            javaMailSender.send(mimeMessage);
            log.info("✅ Email sent successfully to {}", mail.getMailTo());

        } catch (MessagingException e) {
            log.error("❌ Error sending email: {}", e.getMessage());
        }
    }

    @Override
    public Mail getMail(String mailTo, String content, String subject) {
        return Mail.builder()
                .mailFrom(defaultMailFrom)  // Gán email mặc định làm người gửi
                .mailTo(mailTo)
                .mailSubject(subject)
                .mailContent(content)
                .build();
    }
}
