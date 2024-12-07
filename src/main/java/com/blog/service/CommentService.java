package com.blog.service;

import java.util.Optional;

import com.blog.entity.CommentEntity;

public interface CommentService {
    Optional<CommentEntity> getCommentById(Long id);

    void createComment(CommentEntity comment);

    void updateComment(Long id, CommentEntity comment);

    void deleteComment(Long id);
    
}
