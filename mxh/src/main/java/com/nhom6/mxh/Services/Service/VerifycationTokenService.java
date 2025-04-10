package com.nhom6.mxh.Services.Service;

import org.springframework.stereotype.Service;

import com.nhom6.mxh.Models.VerifycationToken;
import com.nhom6.mxh.Models.User.User;
@Service
public interface VerifycationTokenService {
    void registerUser(User user);
    void confirmUser(Long token);
    VerifycationToken findById(Long id);
    void cleanupExpiredTokens();
}
