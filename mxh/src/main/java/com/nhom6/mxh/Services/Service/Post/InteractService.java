package com.nhom6.mxh.Services.Service.Post;

import org.springframework.stereotype.Service;

import com.nhom6.mxh.Models.Post.Interact;

@Service
public interface InteractService {
    Interact findById(Long id);
}
