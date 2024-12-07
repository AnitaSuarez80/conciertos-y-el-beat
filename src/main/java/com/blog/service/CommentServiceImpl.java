package com.blog.service;

import java.security.InvalidParameterException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.CommentEntity;
import com.blog.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired private CommentRepository commentRepository;

    @Override
    public void createComment(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);        
    }

    @Override
    public Optional<CommentEntity> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void updateComment(Long id, CommentEntity comment) {
        CommentEntity commentDB = getCommentById(id).orElseThrow(() -> new InvalidParameterException("Invalid comment id"));    
        commentDB.setContent(comment.getContent());
        commentRepository.save(commentDB);
    }
    
}
