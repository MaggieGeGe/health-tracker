package com.example.backend.controller;

import com.example.backend.mapper.UserMapper;
import com.example.backend.Service.UserService;
import com.example.backend.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController //rest 封格的controller
@RequestMapping("/user")
@Tag(name = "user")//link：http://localhost:9090/swagger-ui/index.html
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;



    @PostMapping
    @Operation(summary = "Add new or update")
    public boolean addUser(@RequestBody User user){//requestbody change the json to java object

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



}
