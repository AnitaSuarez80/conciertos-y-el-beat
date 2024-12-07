package com.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.entity.UserEntity;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String userIdentifier) throws UsernameNotFoundException{
        Optional<UserEntity> optionalUser = userService.getUserByUserName(userIdentifier);

        if(!optionalUser.isPresent()){
            optionalUser = userService.getUserByEmail(userIdentifier);
        }
        if(optionalUser.isPresent()){
            session.setAttribute("username_session_id", optionalUser.get().getId());
            UserEntity user = optionalUser.get();
            return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles()
                .build();
        }else{
            throw new UsernameNotFoundException("User not found!");
        }
    }

    
}
