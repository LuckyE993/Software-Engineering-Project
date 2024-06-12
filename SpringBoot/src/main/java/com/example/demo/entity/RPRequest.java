package com.example.demo.entity;
import java.util.List;

public class RPRequest {

    private rule rule;
    private List<prize> prizes;

    // Getters and Setters
    public rule getRule() {
        return rule;
    }

    public void setRule(rule rule) {
        this.rule = rule;
    }

    public List<prize> getPrizes() {
        return prizes;
    }

    public void setPrizes(List<prize> prizes) {
        this.prizes = prizes;
    }
}
