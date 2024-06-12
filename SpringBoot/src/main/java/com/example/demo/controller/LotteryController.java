package com.example.demo.controller;


import com.example.demo.services.LotteryService;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
public class LotteryController {

    @Autowired
    private LotteryService lotteryService;

    @PostMapping("/perform")
    public Results performLottery(@RequestParam Integer ruleId) {
        boolean success = lotteryService.performLottery(ruleId);
        if (success) {
            return Results.ok().message("抽奖成功");
        } else {
            return Results.error().message("抽奖失败");
        }
    }
}
