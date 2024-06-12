package com.example.demo.mapper;

import com.example.demo.entity.prize;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PrizeMapper {
    @Select("SELECT * FROM prize WHERE prizeListId = #{prizeListId}")
    List<prize> findByPrizeListId(Integer prizeListId);
}
