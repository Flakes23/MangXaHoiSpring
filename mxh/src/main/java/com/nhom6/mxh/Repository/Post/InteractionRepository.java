package com.nhom6.mxh.Repository.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom6.mxh.Models.Post.Interaction;
import com.nhom6.mxh.Models.Post.Post;
import com.nhom6.mxh.Models.User.User;

public interface InteractionRepository extends JpaRepository<Interaction, Long>{
    Interaction findByPostAndUser(Post post, User user);
}
