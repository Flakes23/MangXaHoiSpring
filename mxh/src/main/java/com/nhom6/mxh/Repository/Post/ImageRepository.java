package com.nhom6.mxh.Repository.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom6.mxh.Models.Post.Image;

public interface ImageRepository extends JpaRepository<Image,Long> {
    Image findByUrlImage(String url);
}
