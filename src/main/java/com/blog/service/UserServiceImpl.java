package com.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.UserEntity;
import com.blog.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserEntity user) {
        userRepository.save(user);        
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> getUserByUserName(String username) {
        return userRepository.findByUserName(username);
    }
   
    /*Mi código */
    @Override
    public Optional<UserEntity> getUserByEmail(String email){
        return userRepository.findByEmail(email);
        
    }



}
