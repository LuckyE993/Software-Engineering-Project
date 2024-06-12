package com.example.demo.controller;

import com.example.demo.entity.users;
import com.example.demo.mapper.UserMapper;
import com.example.demo.services.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.Result;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class userController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Results register(@RequestBody users  registerRequest) {
        String userPhoneNumber = registerRequest.getUserPhoneNumber();
        if (userService.findByUserPhoneNumber(userPhoneNumber) != null) {
            return Results.error().message("手机号已注册").code(Result.USER_ALREADY_EXISTS);
        }
        boolean success = userService.registerUser(userPhoneNumber);
        if (success) {
            return Results.ok().message("注册成功").code(Result.USER_REGISTER_SUCCESS);
        } else {
            return Results.error().message("注册失败").code(Result.USER_REGISTER_FAIL);
        }
    }


    @PostMapping("/login")
//    public users findByUserPhoneNumber(String userPhoneNumber)
    public Results login(@RequestBody users loginUserInfo) {
        String userPhoneNumber = loginUserInfo.getUserPhoneNumber();
        String userPasswd = loginUserInfo.getUserPasswd();
        System.out.println(userPhoneNumber + " " + userPasswd);
        users user = userService.findByUserPhoneNumber(userPhoneNumber);
        if (user != null && userService.checkPassword(user, userPasswd)==1) {
            String token = JwtUtils.generateToken(user.getUserName());
            return Results.ok().message("登录成功").data("token",token).code(Result.PASSWORD_CORRECT);
        } else if (user != null && userService.checkPassword(user, userPasswd)==2) {
            return Results.error().message("密码错误").code(Result.PASSWORD_ERROR);
        }
        return Results.error().message("用户无").code(Result.USER_NONEXISTENT);
    }
    @GetMapping("/info")
    public Results info(String token){
       String userPhoneNumber = JwtUtils.getClaimsByToken(token).getSubject();
       String url = "https://img2.baidu.com/it/u=1325995315,4158780794&fm=26&fmt=auto&gp=0.jpg";
       return Results.ok().data("userPhoneNumber",userPhoneNumber).data("avatar",url);
    }

    @PostMapping("/updateUser")
    public Results userInsertOrUpdateUser(@RequestBody users user) {
        boolean success = userService.userUpdateUser(user);
        if (success) {
            return Results.ok().message("用户信息更新成功").code(Result.ADMIN_UPDATE_USER_SUCCESS);
        } else {
            return Results.error().message("用户信息更新失败").code(Result.ADMIN_UPDATE_USER_FAIL);
        }
    }

    @PostMapping("/logout")
    public Results logout(){
        return Results.ok().message("退出成功").code(Result.USER_LOGOUT_SUCCESS);
    }

}
