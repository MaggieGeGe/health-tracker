package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//数据库查询接口
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //@Select("select * from user")
    List<User> listUsers();

    @Insert("INSERT INTO user(name,username,age,sex,phone,password) " +
            "VALUES(#{name},#{username},#{age},#{sex},#{phone},#{password})")
    int insert(User user);

    int update(User user);

    @Delete("delete from user where id=#{id}")
    Integer deleteById(@Param("id") Integer id);

    @Select("select * from user where username like #{username}  and phone like #{phone} limit #{pageNum}, #{pageSize}")
    List<User> selectPage(Integer pageNum, Integer pageSize, String username, String phone);

    @Select("select count(*) from user where username like #{username} and phone like #{phone}")
    Integer selectTotal(String username,String phone);
}
