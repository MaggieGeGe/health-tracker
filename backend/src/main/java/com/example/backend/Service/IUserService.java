package com.example.backend.Service;

import com.example.backend.Mapper.UserMapper;
import com.example.backend.controller.request.UserPageRequest;
import com.example.backend.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {

    @Select("select * from user")
    List<User> listUsers();

    Object page(UserPageRequest userPageRequest);
}
