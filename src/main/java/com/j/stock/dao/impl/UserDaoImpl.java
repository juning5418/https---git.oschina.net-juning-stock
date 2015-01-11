package com.j.stock.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.j.stock.dao.BaseDao;
import com.j.stock.dao.UserDao;
import com.j.stock.vo.User;


@Repository
public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public User getUserById(String userId) {
        return (User) this.queryForObject("UserDao.getUserById", userId);
    }

    @Override
    public String addUser(User user) {
        return (String) this.insert("UserDao.addUser", user);        
    }

    @Transactional(readOnly = false)
    @Override
    public int updateUser(User user) {
        return this.update("UserDao.updateUser", user);        
    }

    @Override
    public int deleteUser(String userId) {
        return this.delete("UserDao.deleteUser", userId);
    }
}
