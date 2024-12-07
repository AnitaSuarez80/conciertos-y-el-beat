package com.blog.service;

import java.util.List;
import java.util.Optional;

import com.blog.entity.PostEntity;


public interface PostService {
    List<PostEntity> getAllPost();

    Optional<PostEntity> getPostById(Long id);

    List<PostEntity> getPostByUserId(Long userId);

    void createPost(PostEntity post);

    void updatePost(Long id, PostEntity post);

    void deletePostById(Long id);
    
    List<PostEntity> searchPostByTitle(String title);

}
