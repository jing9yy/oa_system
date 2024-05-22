package com.team.oa_system.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public class UserMapper {
    @Select("select userId,userName,password,position,permission,department,birthday,userphone from oa_system.user where ")
    public User login(User user);
}
