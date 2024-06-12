package com.example.demo.services.impl;

import com.example.demo.entity.users;
import com.example.demo.mapper.UserMapper;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public users findByUserPhoneNumber(String user_phone_number) {
//        QueryWrapper<users> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("userPhoneNumber", user_phone_number);
        return userMapper.findByUserPhoneNumber(user_phone_number);
    }

    @Override
    public Integer checkPassword(users user, String rawPassword) {
        if (user == null) {
            return 0;//Not Exist
        }
        if (user.getUserPasswd().equals(rawPassword)) {
            return 1;//Exist and Password Correct
        } else {
            return 2;//Exist and Password Wrong
        }

    }



    @Override
    public Boolean registerUser(String userPhoneNumber) {
        users user = new users();

        user.setUserPhoneNumber(userPhoneNumber);
        user.setUserPermission(Boolean.FALSE);
        int result = userMapper.registerInsertUser(user);
        return result>0;
    }


    public List<users> queryUsers() {
        return userMapper.queryUsers();
    }

    @Override
    public Boolean adminInsertUser(users user) {

        int result = userMapper.adminInsertUser(user);
        return result > 0;
    }

    public Boolean adminUpdateUser(users user) {
        users existingUser = userMapper.findByUserPhoneNumber(user.getUserPhoneNumber());
        if (existingUser == null) {
            int result = userMapper.adminInsertUser(user);
            return result > 0;
        } else {
            int result = userMapper.adminUpdateUser(user);
            return result > 0;
        }
    }

    public Boolean userUpdateUser(users user) {
        users existingUser = userMapper.findByUserPhoneNumber(user.getUserPhoneNumber());
        if (existingUser == null) {
            int result = userMapper.userInsertUser(user);
            return result > 0;
        } else {
            int result = userMapper.userUpdateUser(user);
            return result > 0;
        }
    }

    @Override
    public List<users> queryDeleteUsers(String userPhoneNumber) {
        return userMapper.queryDeleteUsers(userPhoneNumber);
    }

    @Override
    public boolean deleteUserById(Integer userId) {
        return false;
    }

    @Override
    public boolean deleteUsersByPhoneNumber(String userPhoneNumber) {
        List<users> users = userMapper.queryDeleteUsers(userPhoneNumber);
        boolean allDeleted = true;
        for (users user : users) {
            int result = userMapper.deleteUserById(user.getUserId());
            if (result <= 0) {
                allDeleted = false;
            }
        }
        return allDeleted;
    }

}

