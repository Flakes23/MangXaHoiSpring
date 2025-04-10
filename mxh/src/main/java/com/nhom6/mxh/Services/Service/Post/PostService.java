package com.nhom6.mxh.Services.Service.Post;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nhom6.mxh.DTO.PostDTO;
import com.nhom6.mxh.Models.Post.Comment;
import com.nhom6.mxh.Models.Post.Post;
import com.nhom6.mxh.Models.User.User;

@Service
public interface PostService {
    List<Post> findByActive(boolean active);
    List<Post> findByUserPosts(User user);
    Post findById(Long id);
    void save(Post post);
    void delete(Long id);
    Long getGenerationId();
    List<Comment> findByCommentsOrderByCreateAtDesc(Post post);
    List<Object[]> findPostAndCommentAndReplyCount(Post post, boolean active);
    Long countInteraction(Post post);
}
