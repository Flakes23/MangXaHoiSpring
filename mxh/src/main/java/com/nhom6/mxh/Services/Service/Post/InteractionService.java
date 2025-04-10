package com.nhom6.mxh.Services.Service.Post;

import org.springframework.stereotype.Service;

import com.nhom6.mxh.Models.Post.Interaction;
import com.nhom6.mxh.Models.Post.Post;
import com.nhom6.mxh.Models.User.User;

@Service
public interface InteractionService {
    Interaction findById(Long id);
    void saveInteraction(Interaction interaction);
    Interaction findByPostAndUser(Post post, User user);
}
