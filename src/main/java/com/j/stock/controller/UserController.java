package com.j.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.j.stock.response.JsonResponse;
import com.j.stock.service.UserService;
import com.j.stock.vo.MemberVO;


@Controller
public class UserController extends BaseController{
    @Autowired
    private UserService userService;    
    
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public @ResponseBody Object userInfo(@PathVariable String userId) {
        return userService.getUserById(userId);
    }
 
}
