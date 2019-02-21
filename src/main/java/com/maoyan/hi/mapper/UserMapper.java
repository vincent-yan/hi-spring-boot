package com.maoyan.hi.mapper;

import com.maoyan.hi.Entity.User;

import java.util.List;

public interface UserMapper{

     List<User> selectAll();

     User getDetail(int id);

     int addUser(User user);

     int updateUser(User user);

     boolean delete(int id);
}
