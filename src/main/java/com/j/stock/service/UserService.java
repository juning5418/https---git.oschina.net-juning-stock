package com.j.stock.service;

import com.j.stock.vo.User;


public interface UserService {

	User getUserById(String userId);
    
    String addUser(User user);
    
    int updateUser(User user);
    
    int deleteUser(String userId);
}
