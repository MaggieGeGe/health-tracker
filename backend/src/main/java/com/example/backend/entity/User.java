package com.example.backend.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
//@TableName("user")
public class User {

    //@TableId(value = "id")
    private Integer id;
    private String name;
    private String username;
    private Integer age;
    private String sex;
    private String phone;
    @JsonIgnore
    private String password;

}


