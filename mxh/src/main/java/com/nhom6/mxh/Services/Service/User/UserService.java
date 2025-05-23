package com.nhom6.mxh.Services.Service.User;

import java.util.List;

import com.nhom6.mxh.DTO.UserDTO;
import com.nhom6.mxh.Models.User.User;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "*")

public interface UserService {
    List<User> fillAll();
    User findById(long userId);
    User findByUserWithUserAbouts(Long id);
    void saveUser(User user);
    User login(String email, String rawPassword);
    User findByEmail(String email);
    boolean isEmailExist(String email);
    void setIsOnline(User user);
    void setIsOffline(User user);
    List<User> findAllByFirstNameOrLastName(String name);
    List<User> searchUser(String name);
}
