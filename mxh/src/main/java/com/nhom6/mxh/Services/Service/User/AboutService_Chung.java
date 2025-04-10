package com.nhom6.mxh.Services.Service.User;

import com.nhom6.mxh.DTO.AboutDTO;
import com.nhom6.mxh.Models.User.About;

public interface AboutService_Chung {
    About getAbout(AboutDTO aboutDTO);
    AboutDTO geAboutDTO(About about);
    void save(About about);

}
