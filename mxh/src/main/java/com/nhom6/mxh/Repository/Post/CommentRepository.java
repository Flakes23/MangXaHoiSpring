package com.nhom6.mxh.Repository.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhom6.mxh.Models.Post.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    
}
