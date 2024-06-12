package com.example.demo.services;

import com.example.demo.entity.users;

import java.util.List;


public interface UserService {

    users findByUserPhoneNumber(String userPhoneNumber);

    Integer checkPassword(users user, String rawPassword);

    Boolean registerUser(String userPhoneNumber);

    List<users> queryUsers();

    Boolean adminInsertUser(users user);

    Boolean adminUpdateUser(users user);

    List<users> queryDeleteUsers(String userPhoneNumber);

    Boolean userUpdateUser(users user);

    boolean deleteUserById(Integer userId);
    boolean deleteUsersByPhoneNumber(String userPhoneNumber);
}
