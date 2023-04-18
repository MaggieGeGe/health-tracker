package com.example.backend.Service;

import com.example.backend.entity.RequiredFood;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRequiredFoodService {

    @Select("select * from requiredfood")
    List<RequiredFood> listRequiredFood() ;
}
