package com.example.demo.services.impl;

import com.example.demo.entity.prize;
import com.example.demo.entity.rule;
import com.example.demo.mapper.RuleMapper;
import com.example.demo.services.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

//    @Autowired
//    private RuleMapper ruleMapper;
//
//    @Override
//    public rule findById(Integer ruleId) {
//        return ruleMapper.findById(ruleId);
//    }
//
//    @Override
//    public List<rule> findByUserId(Integer userId) {
//        return ruleMapper.findByUserId(userId);
//    }
//
//    @Override
//    public boolean insertRule(rule rule) {
//        return ruleMapper.insertRule(rule) > 0;
//    }
//
//    @Override
//    public boolean updateRule(rule rule) {
//        return ruleMapper.updateRule(rule) > 0;
//    }
//
//    @Override
//    public boolean deleteRule(Integer ruleId) {
//        return ruleMapper.deleteRule(ruleId) > 0;
//    }
//
//    @Override
//    @Transactional
//    public boolean insertRuleAndPrizes(rule rule, List<prize> prizes) {
//        int ruleResult = ruleMapper.insertRule(rule);
//        if (ruleResult > 0) {
//            for (prize prize : prizes) {
//                prize.setPrizeListId(rule.getPrizeListId());
//                ruleMapper.insertPrize(prize);
//            }
//            return true;
//        }
//        return false;
//    }

    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public rule findById(Integer ruleId) {
        return ruleMapper.findById(ruleId);
    }

    @Override
    public List<rule> findByUserId(Integer userId) {
        return ruleMapper.findByUserId(userId);
    }



    @Override
    @Transactional
    public boolean insertRuleAndPrizes(rule rule, List<prize> prizes) {
        int ruleResult = ruleMapper.insertRule(rule);
        if (ruleResult > 0) {
            for (prize prize : prizes) {
                prize.setPrizeListId(rule.getPrizeListId());
                ruleMapper.insertPrize(prize);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean updateRule(rule rule) {
        return ruleMapper.updateRule(rule) > 0;
    }

    @Override
    public boolean deleteRule(Integer ruleId) {
        rule rule = ruleMapper.findById(ruleId);
        if (rule != null) {
            ruleMapper.deletePrizesByPrizeListId(rule.getPrizeListId());
            return ruleMapper.deleteRule(ruleId) > 0;
        }
        return false;
    }

}