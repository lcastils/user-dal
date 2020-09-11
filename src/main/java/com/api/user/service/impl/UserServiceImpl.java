package com.api.user.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.user.dto.UserRQ;
import com.api.user.dto.UserRS;
import com.api.user.entity.UserEntity;
import com.api.user.repository.UserRepository;
import com.api.user.service.UserService;
import com.api.user.utils.Converter;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;

    @Override
    public UserRS creatreUser(UserRQ objUser) {
        
        UserEntity userEntity =   Converter.getMapper().map(objUser, UserEntity.class);
        UserEntity userSave =  userRepository.save(userEntity);
        return Converter.getMapper().map(userSave, UserRS.class);
    }

    @Override
    public UserRS getUserByEmail(String email) {
        Optional<UserEntity> response =  userRepository.findByEmailAndIsActive(email, Boolean.TRUE);
        if(response.isPresent()) {
            return Converter.getMapper().map(response.get(), UserRS.class);
        }
        return null;
    }

    @Override
    public UserRS updateUser(UserRQ user) {
        UserEntity userEntity =   Converter.getMapper().map(user, UserEntity.class);
        UserEntity userSave =  userRepository.save(userEntity);
        return Converter.getMapper().map(userSave, UserRS.class);
    }

    @Override
    public UserRS deleteUser(UserRQ user) {
       return updateUser(user);
    }

}
