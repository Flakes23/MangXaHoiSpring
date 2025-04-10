package com.nhom6.mxh.Services.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nhom6.mxh.DTO.AboutDTO;
import com.nhom6.mxh.Models.User.About;
import com.nhom6.mxh.Models.User.UserAbout;
import com.nhom6.mxh.Models.User.User;

@Service
public interface AboutService {

    List<About> fillAll();
    About findById(long aboutId);
    void save(About about);
    List<UserAbout> findByUser(User user);

}