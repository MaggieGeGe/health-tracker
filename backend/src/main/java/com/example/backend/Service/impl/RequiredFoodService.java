package com.example.backend.Service.impl;

import com.example.backend.Mapper.RequiredFoodMapper;
import com.example.backend.Service.IRequiredFoodService;
import com.example.backend.entity.RequiredFood;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequiredFoodService implements IRequiredFoodService {

    @Autowired
    RequiredFoodMapper requiredFoodMapper;

    @Override
    public List<RequiredFood> listRequiredFood() {
        return requiredFoodMapper.listRequiredFood();
    }
}
