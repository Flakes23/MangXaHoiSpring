package com.nhom6.mxh.Services.ServiceImpls.User;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhom6.mxh.DTO.AboutDTO;
import com.nhom6.mxh.Models.User.About;
import com.nhom6.mxh.Repository.User.AboutRepository;
import com.nhom6.mxh.Services.Service.User.AboutService_Chung;

public class AboutService_ChungImpl implements AboutService_Chung {
    @Autowired
    public AboutRepository aboutRepository;

    public AboutService_ChungImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public About getAbout(AboutDTO aboutDTO) {
        About about = new About();
        about.setId(aboutDTO.getId());
        about.setName(aboutDTO.getName());
        return about;
    }

    @Override
    public AboutDTO geAboutDTO(About about) {
        AboutDTO aboutDTO = new AboutDTO();
        aboutDTO.setId(about.getId());
        aboutDTO.setName(about.getName());
        return aboutDTO;

    }

    @Override
    public void save(About about) {
        aboutRepository.save(about);
    }

}
