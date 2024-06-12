package com.example.demo.services.impl;


import com.example.demo.entity.People;
import com.example.demo.entity.prize;
import com.example.demo.entity.rule;
import com.example.demo.mapper.PeopleMapper;
import com.example.demo.mapper.PrizeMapper;
import com.example.demo.mapper.RuleMapper;
import com.example.demo.services.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private PrizeMapper prizeMapper;

    @Autowired
    private PeopleMapper peopleMapper;

    @Override
    @Transactional
    public boolean performLottery(Integer ruleId) {
        // 查询规则
        rule rule = ruleMapper.findById(ruleId);
        if (rule == null) {
            return false;
        }

        // 查询奖品
        List<prize> prizes = prizeMapper.findByPrizeListId(rule.getPrizeListId());
        if (prizes.isEmpty()) {
            return false;
        }

        // 查询人员
        List<People> peopleList = peopleMapper.findByPeopleListId(rule.getPeopleListId().toString());
        if (peopleList.isEmpty()) {
            return false;
        }

        // 计算总奖品数量
        int totalPrizes = prizes.stream().mapToInt(prize -> Integer.parseInt(prize.getPrizeCount())).sum();
        if (totalPrizes > peopleList.size()) {
            totalPrizes = peopleList.size(); // 奖品数量不能超过人员数量
        }

        // 创建奖品列表
        List<String> prizeNames = prizes.stream()
                .flatMap(prize -> IntStream.range(0, Integer.parseInt(prize.getPrizeCount())).mapToObj(i -> prize.getPrizeName()))
                .collect(Collectors.toList());

        // 随机打乱奖品列表
        Collections.shuffle(prizeNames);

        // 分配奖品
        for (int i = 0; i < totalPrizes; i++) {
            peopleMapper.updatePeoplePrize(peopleList.get(i).getPeopleId(), prizeNames.get(i));
        }

        return true;
    }
}
