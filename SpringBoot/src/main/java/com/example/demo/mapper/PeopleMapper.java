package com.example.demo.mapper;

import com.example.demo.entity.People;
import com.example.demo.entity.prize;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PeopleMapper {

    @Select("SELECT * FROM people WHERE peopleListId = #{peopleListId}")
    List<People> findByPeopleListId(String peopleListId);


    @Insert({
            "<script>",
            "INSERT INTO people (peopleListId, peopleName, peoplePhoneNumber, peoplePrize) VALUES ",
            "<foreach collection='peopleList' item='person' separator=','>",
            "(#{person.peopleListId}, #{person.peopleName}, #{person.peoplePhoneNumber}, #{person.peoplePrize})",
            "</foreach>",
            "</script>"
    })
    int insertPeopleList(@Param("peopleList") List<People> peopleList);
    @Delete("DELETE FROM people WHERE peopleListId = #{peopleListId}")
    int deletePeopleByListId(String peopleListId);

    @Delete("DELETE FROM people")
    int deleteAllPeople();

    @Update("UPDATE people SET peopleName = #{peopleName}, peoplePhoneNumber = #{peoplePhoneNumber}, peoplePrize = #{peoplePrize} WHERE peopleId = #{peopleId}")
    int updatePeople(People people);

    @Update("UPDATE people SET peoplePrize = #{peoplePrize} WHERE peopleId = #{peopleId}")
    int updatePeoplePrize(@Param("peopleId") Integer peopleId, @Param("peoplePrize") String peoplePrize);

}
