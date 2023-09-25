package com.example.backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    private UserService userService;

    @PostMapping
    @Operation(summary = "Add new or update")
    public boolean addUser(@RequestBody User user){//requestbody change the json to java object

        return userService.addUser(user);
    }
    @GetMapping("/list")
    public List<User> listUsers(){
        return userService.list();

    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return userService.removeById(id);
    }

//    @GetMapping("/page") //query by page
//    public Map<String, Object> findPage(@RequestParam Integer pageNum,
//                                        @RequestParam Integer pageSize,
//                                        @RequestParam String username,
//                                        @RequestParam String phone){
//        pageNum = (pageNum-1)*pageSize;
//        username = "%"+username+"%";
//        phone = "%"+phone+"%";
//        List<User> all = userMapper.selectPage(pageNum, pageSize, username,phone);
//        Integer total = userMapper.selectTotal(username,phone);
//        Map<String, Object> res =  new HashMap<>();
//        res.put("data",all);
//        res.put("total",total);
//        return res;
//    }

    @GetMapping("/page") //query by page
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam(defaultValue = "") String username,
                                        @RequestParam(defaultValue = "") String phone){
        IPage<User> page = new Page<>(pageNum,pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!"".equals(username)){
            queryWrapper.like("username",username);
        }
        if(!"".equals(phone)){
            queryWrapper.like("phone",phone);
        }


        IPage<User> userPage = userService.page(page,queryWrapper);
        return userPage;
    }



}
