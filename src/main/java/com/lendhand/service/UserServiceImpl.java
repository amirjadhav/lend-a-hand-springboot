package com.lendhand.service;

import java.util.List;

import com.lendhand.model.Users;
import com.lendhand.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String id) {
        return userRepository.findById(Long.parseLong(id)).get();
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }
}
