package com.example.demo.controller;

import com.example.demo.entity.users;

import org.springframework.web.bind.annotation.*;

@RestController
public class paramsController {
    @RequestMapping(value = "/getTest1",method = RequestMethod.GET)
    public String params(@RequestParam(value = "nickname",required = false )String name, String phone) {
        System.out.println("name="+name);
        System.out.println("phone="+phone);
        return "params";
    }

    @RequestMapping(value = "/params2",method = RequestMethod.POST)
    public String params2(String username, String password) {
        System.out.println("userName="+username);
        System.out.println("password="+password);
        return "params2";
    }

    @RequestMapping(value = "/params3",method = RequestMethod.POST)
    public String params3(users user) {
        System.out.println("userName="+user.getUserName());
        System.out.println("password="+user.getUserPasswd());
        return "params3";
    }
    @GetMapping("/test/**")
    public String test() {

        return "test";
    }

}
