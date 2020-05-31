package com.rest.service;

import com.rest.exceptions.NotFoundException;
import com.rest.model.UserEntity;
import com.rest.repository.UserRepository;
import com.rest.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserEntity save(UserEntity user){
        user.setPassword(HashUtil.makeHash(user.getPassword()));
        UserEntity userEntity = this.userRepository.save(user);
        return userEntity;
    }

    @Transactional
    public UserEntity update(UserEntity user){
        user.setPassword(HashUtil.makeHash(user.getPassword()));
        UserEntity userEntityUpdated = this.userRepository.save(user);
        return userEntityUpdated;
    }

    public UserEntity findById(Long userId){
        Optional<UserEntity> userEntityUpdated = this.userRepository.findById(userId);
        return userEntityUpdated.orElseThrow(()-> new NotFoundException("não foi encontrado o usuario com esse id"));
    }

    public List<UserEntity> listAllUser(){
        List<UserEntity> userEntity = this.userRepository.findAll();
        return userEntity;
    }

    public UserEntity Login(String email, String password){
        String encodedPassword = HashUtil.makeHash(password);
        Optional<UserEntity> userEntity= this.userRepository.findByEmailAndPassword(encodedPassword,email);
        return userEntity.orElseThrow(()-> new NotFoundException("não foi encontrado o usuario com esse id"));
    }


}
