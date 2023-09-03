package com.example.backend.Service;

import com.example.backend.mapper.RequiredFoodMapper;
import com.example.backend.entity.RequiredFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequiredFoodService{

    @Autowired
    RequiredFoodMapper requiredFoodMapper;

    public List<RequiredFood> listRequiredFood() {
        return requiredFoodMapper.listRequiredFood();
    }
}
