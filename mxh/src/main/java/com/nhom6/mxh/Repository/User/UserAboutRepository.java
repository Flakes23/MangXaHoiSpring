package com.nhom6.mxh.Repository.User;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom6.mxh.Models.User.About;
import com.nhom6.mxh.Models.User.User;
import com.nhom6.mxh.Models.User.UserAbout;
import java.util.List;

public interface UserAboutRepository extends JpaRepository<UserAbout, Long>{
    UserAbout findByUserAndAbout(User user, About about);
    List<UserAbout> findByUser(User user);
}
