package com.example.backend.Mapper;

import com.example.backend.entity.RequiredFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface RequiredFoodMapper {
    @Select("select * from requiredfood")
    List<RequiredFood> listRequiredFood() ;
}
