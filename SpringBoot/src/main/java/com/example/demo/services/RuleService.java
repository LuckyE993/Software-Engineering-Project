package com.example.demo.services;

import com.example.demo.entity.prize;
import com.example.demo.entity.rule;

import java.util.List;

public interface RuleService {
//    rule findById(Integer ruleId);
//    List<rule> findByUserId(Integer userId);
//    boolean insertRule(rule rule);
//    boolean updateRule(rule rule);
//    boolean deleteRule(Integer ruleId);
//
//    boolean insertRuleAndPrizes(rule rule, List<prize> prizes);
rule findById(Integer ruleId);
List<rule> findByUserId(Integer userId);
//boolean insertRule(rule rule);
boolean updateRule(rule rule);
boolean deleteRule(Integer ruleId);
boolean insertRuleAndPrizes(rule rule, List<prize> prizes);
}
