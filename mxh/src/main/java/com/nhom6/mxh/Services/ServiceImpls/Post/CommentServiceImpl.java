package com.nhom6.mxh.Services.ServiceImpls.Post;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nhom6.mxh.Exceptions.CustomException;
import com.nhom6.mxh.Exceptions.ErrorCode;
import com.nhom6.mxh.Models.Post.Comment;
import com.nhom6.mxh.Repository.Post.CommentRepository;
import com.nhom6.mxh.Services.Service.Post.CommentService;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void save(Comment comment) {
        try {
            log.info("Save comment");
            if (comment.getId() == null) {
                comment.setId(getGenerationId());
            }
            commentRepository.save(comment);
        } catch (DataIntegrityViolationException e) {
            log.error("Error saving comment");
            throw new CustomException(ErrorCode.COMMENT_UNABLE_TO_SAVE);
        } catch (DataAccessException e) {
            throw new CustomException(ErrorCode.DATABASE_ACCESS_ERROR);
        }
    }

    public Long getGenerationId() {
        UUID uuid = UUID.randomUUID();
        return uuid.getMostSignificantBits() & 0x1FFFFFFFFFFFFFL;
    }

    @Override
    public Comment findById(Long id) {
        try {
            log.info("Finding comment by id: {}", id);
            Optional<Comment> comment = commentRepository.findById(id);
            return comment.isPresent() ? comment.get() : null;
        } catch (EntityNotFoundException e) {
            log.error("Couldn't find comment by id: {}", id);
            throw new CustomException(ErrorCode.COMMENT_NOT_FOUND);
        } catch (DataAccessException e) {
            throw new CustomException(ErrorCode.DATABASE_ACCESS_ERROR);
        }
    }

}
