package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class users {
    @TableId
    private int userId;
    private String userName;
    private String userPasswd;
    private String userPhoneNumber;
    private Boolean userPermission;
    // Constructors


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Boolean getUserPermission() {
        return userPermission;
    }

    public void setUserPermission(Boolean userPermission) {
        this.userPermission = userPermission;
    }

    @Override
    public String toString() {
        return "users{" +
                "id=" + userId +
                ", username='" + userName + '\'' +
                ", password='" + userPasswd + '\'' +
                ", phonenumber='" + userPhoneNumber + '\'' +
                '}';
    }

}
