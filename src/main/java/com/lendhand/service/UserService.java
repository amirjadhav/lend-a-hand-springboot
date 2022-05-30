package com.lendhand.service;

import java.util.List;

import com.lendhand.model.Users;

public interface UserService {

    Users addUser(Users user);

    List<Users> getAllUsers();

    Users getUser(String id);

    Users updateUser(Users user);

}
