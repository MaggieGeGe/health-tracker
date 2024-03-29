package com.example.backend.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.backend.mapper.UserMapper;
import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    public boolean addUser(User user){

        return saveOrUpdate(user);
    }


//    @Autowired
//    private UserMapper userMapper;
//
//    public int addUser(User user){
//        if(user.getId()==null){ //no id:add
//            return userMapper.insert(user);
//        }else {// yes :update
//            return userMapper.update(user);
//
//        }
//    }




}
