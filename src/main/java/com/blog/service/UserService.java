package com.blog.service;

import java.util.Optional;

import com.blog.entity.UserEntity;

public interface UserService {
    void createUser(UserEntity user);
    Optional<UserEntity> getUserById(Long id);
    Optional<UserEntity> getUserByUserName(String username);
    Optional<UserEntity> getUserByEmail(String email);
}
