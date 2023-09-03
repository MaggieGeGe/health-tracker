package com.example.backend.controller;

import com.example.backend.Service.RequiredFoodService;
import com.example.backend.entity.RequiredFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController //rest 封格的controller
@RequestMapping("/requiredfood")
public class RequiredFoodController {

    @Autowired
    RequiredFoodService requiredFoodService;

    @GetMapping("/list")
    public List<RequiredFood> listRequiredFood(){
        return requiredFoodService.listRequiredFood();
    }

}
