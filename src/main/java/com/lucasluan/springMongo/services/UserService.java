package com.lucasluan.springMongo.services;

import com.lucasluan.springMongo.domain.User;
import com.lucasluan.springMongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> finAll(){
        return userRepository.findAll();
    }
}