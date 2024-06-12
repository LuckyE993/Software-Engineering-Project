package com.example.demo.controller;

import com.example.demo.entity.users;
import com.example.demo.mapper.UserMapper;
import com.example.demo.services.UserService;
import com.example.demo.utils.Result;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class adminController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @GetMapping("/queryUsers")
    public Results queryUsers() {
        List<users> users = userService.queryUsers();
        return Results.ok().data("users", users).code(Result.ADMIN_QUERY_USERS_SUCCESS);
    }

    @PostMapping("/insertUser")
    public Results adminInsertUser(@RequestBody users user) {
        boolean success = userService.adminInsertUser(user);
        if (success) {
            return Results.ok().message("用户插入成功").code(Result.ADMIN_ADD_USER_SUCCESS);
        } else {
            return Results.error().message("用户插入失败").code(Result.ADMIN_ADD_USER_FAIL);
        }
    }
    @PostMapping("/updateUser")
    public Results adminInsertOrUpdateUser(@RequestBody users user) {
        boolean success = userService.adminUpdateUser(user);
        if (success) {
            return Results.ok().message("用户更新成功").code(Result.ADMIN_UPDATE_USER_SUCCESS);
        } else {
            return Results.error().message("用户更新失败").code(Result.ADMIN_UPDATE_USER_FAIL);
        }
    }
    @DeleteMapping("/deleteUsers")
    public Results deleteUsersByPhoneNumber(@RequestBody users user) {

        String userPhoneNumber = user.getUserPhoneNumber();
        boolean success = userService.deleteUsersByPhoneNumber(userPhoneNumber);
        if (success) {
            return Results.ok().message("用户删除成功").code(Result.ADMIN_DELETE_USER_SUCCESS);
        } else {
            return Results.error().message("用户删除失败").code(Result.ADMIN_DELETE_USER_FAIL);
        }
    }
}
