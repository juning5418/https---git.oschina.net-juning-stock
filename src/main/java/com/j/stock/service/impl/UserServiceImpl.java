package com.j.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.stock.dao.UserDao;
import com.j.stock.service.UserService;
import com.j.stock.vo.User;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public String addUser(User user) {
        return userDao.addUser(user);        
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);        
    }

    @Override
    public int deleteUser(String userId) {
        return userDao.deleteUser(userId);        
    }
}
