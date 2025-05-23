package com.nhom6.mxh.Services.ServiceImpls;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nhom6.mxh.Exceptions.CustomException;
import com.nhom6.mxh.Exceptions.ErrorCode;
import com.nhom6.mxh.Models.Mail;
import com.nhom6.mxh.Models.VerifycationToken;
import com.nhom6.mxh.Models.User.User;
import com.nhom6.mxh.Repository.VerifycationRepository;
import com.nhom6.mxh.Services.Service.MailService;
import com.nhom6.mxh.Services.Service.VerifycationTokenService;
import com.nhom6.mxh.Services.Service.User.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class VerifycationTokenServiceImpls implements VerifycationTokenService {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @Autowired
    private VerifycationRepository verifycationTokenRepository;

    // Gui mail
    @Override
    public void registerUser(User user) {
        try {
            log.info("Send user registration with email: {}", user.getEmail());
            Long id = generateToken();

            LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(5);

            // Tao doi tuong mail chua link xac nhan

            VerifycationToken verifycationToken = VerifycationToken.builder()
                    .id(id)
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .password(user.getPassword())
                    .setExpiryDate(localDateTime)
                    .build();
            Mail mail = mailService.getMail(user.getEmail(),
                    "http://localhost:8080/confirmUser?token=" + verifycationToken.getId(), "Xác nhận tài khoản");
            mailService.sendMail(mail);
            verifycationTokenRepository.save(verifycationToken);
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ErrorCode.NOTIFICATION_UNABLE_TO_SAVE);
        } catch (DataAccessException e) {
            throw new CustomException(ErrorCode.DATABASE_ACCESS_ERROR);
        }
    }

    // xac nhan token tai khoan
    @Override
    public void confirmUser(Long token) {
        try {
            log.info("Confirm user with token: {}", token);
            VerifycationToken verifycationToken = findById(token);
            User user = User.builder()
                    .firstName(verifycationToken.getFirstName())
                    .lastName(verifycationToken.getLastName())
                    .email(verifycationToken.getEmail())
                    .password(verifycationToken.getPassword())
                    .build();

            // neu xac nhan duoc thi luu user va xoa token
            userService.saveUser(user);
            verifycationTokenRepository.delete(verifycationToken);
        } catch (DataIntegrityViolationException e) {
            log.error("Confirm user with token: {}", token);
            throw new CustomException(ErrorCode.NOTIFICATION_UNABLE_TO_UPDATE);
        } catch (DataAccessException e) {
            throw new CustomException(ErrorCode.DATABASE_ACCESS_ERROR);
        }
    }

    // tao id token radom
    private long generateToken() {
        UUID uuid = UUID.randomUUID();
        return uuid.getMostSignificantBits() & 0x1FFFFFFFFFFFFFL; // Lấy phần most significant bits của UUID và đảm bảo
                                                                  // không âm (most significant bit là bit đầu tiên của
                                                                  // UUID)
    }

    // tim kiem token theo id
    @Override
    public VerifycationToken findById(Long id) {
        try {
            log.info("Find token with id: {}", id);
            Optional<VerifycationToken> token = verifycationTokenRepository.findById(id);
            return token.isPresent() ? token.get() : null;
        } catch (EntityNotFoundException e) {
            log.error("Notification not found with id: {}", id);
            throw new CustomException(ErrorCode.NOTIFICATION_NOT_FOUND);
        }
    }

    @Scheduled(fixedDelay = 60000) // Chạy mỗi 1 phút
    @Transactional
    @Override
    public void cleanupExpiredTokens() { // Xóa các token đã hết hạn
        try {
            log.info("Cleanup expired tokens");
            LocalDateTime expiryTime = LocalDateTime.now(); // Xóa các token đã tạo từ 5 phút trước
            List<VerifycationToken> tokens = verifycationTokenRepository.findExpiredVerificationTokens(expiryTime); // tim
                                                                                                                    // token
                                                                                                                    // da
                                                                                                                    // tao
                                                                                                                    // tu
                                                                                                                    // 5p
                                                                                                                    // truoc
            for (VerifycationToken token : tokens) { // duyet qua cac token
                verifycationTokenRepository.delete(token);// xoa token
            }
        } catch (DataIntegrityViolationException e) {
            throw new CustomException(ErrorCode.NOTIFICATION_UNABLE_TO_UPDATE);
        } catch (DataAccessException e) {
            throw new CustomException(ErrorCode.DATABASE_ACCESS_ERROR);
        }
    }

}
