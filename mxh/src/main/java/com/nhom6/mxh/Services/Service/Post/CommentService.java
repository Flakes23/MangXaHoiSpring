package com.nhom6.mxh.Services.Service.Post;


import org.springframework.stereotype.Service;
import com.nhom6.mxh.Models.Post.Comment;

@Service
public interface CommentService {
    void save(Comment comment);
    Long getGenerationId();
    Comment findById(Long id);

}
