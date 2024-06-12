package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.prize;
import com.example.demo.entity.rule;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RuleMapper extends BaseMapper<rule>{

    @Select("SELECT * FROM rule WHERE ruleId = #{ruleId}")
    rule findById(Integer ruleId);


    @Select("SELECT * FROM rule WHERE userId = #{userId}")
    List<rule> findByUserId(Integer userId);

    @Insert("INSERT INTO rule (userId, ruleName, ruleDepartment, ruleDescribe, peopleSelect, prizeListId, lotteryMethod, peopleListId) " +
            "VALUES (#{userId}, #{ruleName}, #{ruleDepartment}, #{ruleDescribe}, #{peopleSelect}, #{prizeListId}, #{lotteryMethod}, #{peopleListId})")
    @Options(useGeneratedKeys = true, keyProperty = "ruleId")
    int insertRule(rule rule);

    @Update("UPDATE rule SET ruleName = #{ruleName}, ruleDepartment = #{ruleDepartment}, ruleDescribe = #{ruleDescribe}, " +
            "peopleSelect = #{peopleSelect}, prizeListId = #{prizeListId}, lotteryMethod = #{lotteryMethod}, peopleListId = #{peopleListId} " +
            "WHERE ruleId = #{ruleId}")
    int updateRule(rule rule);

    @Delete("DELETE FROM rule WHERE ruleId = #{ruleId}")
    int deleteRule(Integer ruleId);


    @Insert("INSERT INTO prize (prizeListId, prizeName, prizeCount) " +
            "VALUES (#{prizeListId}, #{prizeName}, #{prizeCount})")
    @Options(useGeneratedKeys = true, keyProperty = "prizeId")
    int insertPrize(prize prize);

    @Select("SELECT * FROM prize WHERE prizeListId = #{prizeListId}")
    List<prize> findPrizesByPrizeListId(Integer prizeListId);

    @Delete("DELETE FROM prize WHERE prizeListId = #{prizeListId}")
    int deletePrizesByPrizeListId(Integer prizeListId);


    @Select("SELECT * FROM prize WHERE prizeId = #{prizeId}")
    prize findPrizeById(Integer prizeId);

}

