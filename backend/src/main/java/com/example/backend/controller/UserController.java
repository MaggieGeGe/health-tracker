package com.example.backend.controller;

import com.example.backend.Service.IUserService;
import com.example.backend.common.Result;
import com.example.backend.controller.request.UserPageRequest;
import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController //rest 封格的controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/list")
    public Result listUsers(){
        List<User> users =  userService.listUsers();
        return Result.success(users);

    }

    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest){
        userService.page(userPageRequest);
        return Result.success(userService.page(userPageRequest));

    }

}
