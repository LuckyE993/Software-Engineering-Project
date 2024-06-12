package com.example.demo.entity;

public class rule {

    private Integer ruleId;

    private Integer userId;
    private String ruleName;
    private String ruleDepartment;
    private String ruleDescribe;
    private Integer peopleSelect;
    private Integer prizeListId;
    private Integer lotteryMethod;
    private Integer peopleListId;

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDepartment() {
        return ruleDepartment;
    }

    public void setRuleDepartment(String ruleDepartment) {
        this.ruleDepartment = ruleDepartment;
    }

    public String getRuleDescribe() {
        return ruleDescribe;
    }

    public void setRuleDescribe(String ruleDescribe) {
        this.ruleDescribe = ruleDescribe;
    }

    public Integer getPeopleSelect() {
        return peopleSelect;
    }

    public void setPeopleSelect(Integer peopleSelect) {
        this.peopleSelect = peopleSelect;
    }

    public Integer getPrizeListId() {
        return prizeListId;
    }

    public void setPrizeListId(Integer prizeListId) {
        this.prizeListId = prizeListId;
    }

    public Integer getLotteryMethod() {
        return lotteryMethod;
    }

    public void setLotteryMethod(Integer lotteryMethod) {
        this.lotteryMethod = lotteryMethod;
    }

    public Integer getPeopleListId() {
        return peopleListId;
    }

    public void setPeopleListId(Integer peopleListId) {
        this.peopleListId = peopleListId;
    }
}
