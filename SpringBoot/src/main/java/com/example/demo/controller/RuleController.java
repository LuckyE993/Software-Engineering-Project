package com.example.demo.controller;

import com.example.demo.entity.RPRequest;
import com.example.demo.entity.rule;
import com.example.demo.services.RuleService;
import com.example.demo.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @GetMapping("/{ruleId}")
    public Results getRuleById(@PathVariable Integer ruleId) {
        rule rule = ruleService.findById(ruleId);
        if (rule != null) {
            return Results.ok().data("rule", rule);
        } else {
            return Results.error().message("规则不存在");
        }
    }

    @GetMapping("/user/{userId}")
    public Results getRulesByUserId(@PathVariable Integer userId) {
        List<rule> rules = ruleService.findByUserId(userId);
        if (rules.isEmpty()) {
            return Results.error().message("用户未设置规则");
        } else {
            return Results.ok().data("rules", rules);
        }
    }

    @PostMapping("/addRuleAndPrizes")
    public Results addRuleAndPrizes(@RequestBody RPRequest request) {
        boolean success = ruleService.insertRuleAndPrizes(request.getRule(), request.getPrizes());
        if (success) {
            return Results.ok().message("规则和奖品添加成功");
        } else {
            return Results.error().message("规则和奖品添加失败");
        }
    }
    //Todo: UpdateRuleAndPrizes

    @PutMapping("/updateRule")
    public Results updateRule(@RequestBody rule rule) {
        boolean success = ruleService.updateRule(rule);
        if (success) {
            return Results.ok().message("规则更新成功");
        } else {
            return Results.error().message("规则更新失败");
        }
    }

    @DeleteMapping("/{ruleId}")
    public Results deleteRule(@PathVariable Integer ruleId) {
        boolean success = ruleService.deleteRule(ruleId);
        if (success) {
            return Results.ok().message("规则删除成功");
        } else {
            return Results.error().message("规则删除失败");
        }
    }
}