package com.j.stock.dao;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.j.stock.dao.UserDao;
import com.j.stock.vo.User;


public class UserDaoTest extends BaseTest{
//    @Autowired
//    private UserDao userDao;
//    
//    @Test
//    public void testGetUserById() {
//        User user = userDao.getUserById("1");
//        System.out.println(user);
//        Assert.assertNotNull(user);
//    }
//    
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testAddUser() {
//        User user = new User();
//        user.setUserName("张三");
//        user.setPassword("pwd");
//        user.setUserTel("13888888888");
//        String userId = userDao.addUser(user);
//        System.out.println(userId);
//        Assert.assertNotNull(userId);
//    }
//    
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testUpdateUser() {
//        User user = userDao.getUserById("1");
//        user.setUserName("张三");
//        user.setPassword("password");
//        user.setUserId("1");
//        int row = userDao.updateUser(user);
//        System.out.println(row);
//        Assert.assertTrue(row > 0);
//    }
//    
//    @Test
//    @Transactional
//    @Rollback(true)
//    public void testDeleteUser() {
//        int row = userDao.deleteUser("1");
//        Assert.assertTrue(row > 0);
//    }
}
