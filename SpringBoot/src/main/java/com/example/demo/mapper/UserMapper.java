package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<users> {
    @Select("SELECT userId, userName, userPasswd, userPhoneNumber, userPermission FROM user WHERE (userPhoneNumber = #{userPhoneNumber})")
    users findByUserPhoneNumber(String userPhoneNumber);

    @Insert("INSERT INTO user (userName, userPasswd, userPhoneNumber, userPermission) VALUES (#{userName}, #{userPasswd}, #{userPhoneNumber}, #{userPermission})")
    Integer registerInsertUser(users user);

    @Select("SELECT userID,userName, userPasswd, userPhoneNumber, userPermission FROM user")
    List<users> queryUsers();

    @Insert("INSERT INTO user (userName, userPasswd, userPhoneNumber, userPermission) VALUES (#{userName}, #{userPasswd}, #{userPhoneNumber}, #{userPermission})")
    Integer adminInsertUser(users user);

    @Update("UPDATE user SET userName = #{userName}, userPasswd = #{userPasswd}, userPermission = #{userPermission} WHERE userPhoneNumber = #{userPhoneNumber}")
    Integer adminUpdateUser(users user);


    @Select("SELECT userId, userName, userPasswd, userPhoneNumber, userPermission FROM user WHERE userPhoneNumber = #{userPhoneNumber}")
    List<users> queryDeleteUsers(String userPhoneNumber);

    @Delete("DELETE FROM user WHERE userId = #{userId}")
    Integer deleteUserById(int userId);


    @Insert("INSERT INTO user (userName, userPasswd, userPhoneNumber, userPermission) VALUES (#{userName}, #{userPasswd}, #{userPhoneNumber}, #{userPermission})")
    Integer userInsertUser(users user);

    @Update("UPDATE user SET userName = #{userName}, userPasswd = #{userPasswd} WHERE userPhoneNumber = #{userPhoneNumber}")
    Integer userUpdateUser(users user);

}
