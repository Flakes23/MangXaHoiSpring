package com.nhom6.mxh.Services.Service.Post;


import org.springframework.stereotype.Service;

import com.nhom6.mxh.Models.Post.Image;

@Service
public interface ImageService {
    Image findById(long id);
    void saveImage(Image image);
    Long getGenerationId();
    Image findByImage(String url);
}
