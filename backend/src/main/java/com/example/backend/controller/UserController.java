package com.example.backend.controller;

import com.example.backend.Mapper.UserMapper;
import com.example.backend.Service.IUserService;
import com.example.backend.Service.impl.UserService;
import com.example.backend.common.Result;
import com.example.backend.controller.request.UserPageRequest;
import com.example.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@CrossOrigin
@RestController //rest 封格的controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Integer addUser(@RequestBody User user){//requestbody change the json to java object
        return userService.addUser(user);
    }
    @GetMapping("/list")
    public List<User> listUsers(){
        List<User> users =  userMapper.listUsers();
        return users;

    }

    @DeleteMapping("/{id}")
    public Integer deleteUser(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }

    @GetMapping("/page") //query by page
    public Map<String, Object> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String username,
                                        @RequestParam String phone){
        pageNum = (pageNum-1)*pageSize;
        username = "%"+username+"%";
        phone = "%"+phone+"%";
        List<User> all = userMapper.selectPage(pageNum, pageSize, username,phone);
        Integer total = userMapper.selectTotal(username,phone);
        Map<String, Object> res =  new HashMap<>();
        res.put("data",all);
        res.put("total",total);
        return res;
    }

//    public Result page(UserPageRequest userPageRequest){
//        userService.page(userPageRequest);
//        return Result.success(userService.page(userPageRequest));
//
//    }

}
