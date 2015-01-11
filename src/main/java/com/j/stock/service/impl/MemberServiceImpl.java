package com.j.stock.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.stock.dao.MemberDao;
import com.j.stock.response.JsonResponse;
import com.j.stock.service.MemberServcie;
import com.j.stock.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberServcie{

	@Autowired
    private MemberDao memberDao;
	 
	@Override
	public JsonResponse checkuser(MemberVO member) {
		JsonResponse j = new JsonResponse();
        Map<String,Object> param = memberDao.checkuser(member);
        if (param != null && !param.isEmpty() && param.get("user") != null ) {
        	MemberVO user = (MemberVO)param.get("user");
        	
        	if(user != null ) {
        		if(user.getEmail().equals(member.getEmail())){
        			j.setMsg("error1");//此邮箱已注册！
        		}else if(user.getMobile().equals(member.getMobile())){
        			j.setMsg("error2");//此手机已注册！
        		}else if(user.getUsername().equals(member.getUsername())){
        			j.setMsg("error3");//此用户名已注册！
        		}
                j.setSuccess(false);
            }
        }
        return j;
	}

	/**
	 * 新增会员
	 */
	@Override
	public MemberVO adduser(MemberVO member) {
		return  memberDao.adduser(member);
	}

	/**
	 * 验证登入账号
	 */
	@Override
	public JsonResponse logonCheckuser(MemberVO member) {
		JsonResponse j = new JsonResponse();
        Map<String,Object> param = memberDao.logonCheckuser(member);
        if (param != null && !param.isEmpty() && param.get("user") != null ) {
        	MemberVO user = (MemberVO)param.get("user");
        	member.setId(user.getId());
        	if(user != null ) {
        		
            }else{
            	j.setMsg("error4");//登入失败！
                j.setSuccess(false);
            }
        }else{
        	j.setSuccess(false);
        }
        return j;
	}

}
