package com.j.stock.dao;

import com.j.stock.vo.User;


public interface UserDao {
    User getUserById(String userId);
    
    String addUser(User user);
    
    int updateUser(User user);
    
    int deleteUser(String userId);
}
