package com.j.stock.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.j.stock.dao.BaseDao;
import com.j.stock.dao.MemberDao;
import com.j.stock.util.Md5Util;
import com.j.stock.vo.MemberVO;

@Repository
public class MemberDaoImpl extends BaseDao implements MemberDao{

	/**
	 * 注册验证用户
	 */
	@Override
	public Map<String, Object> checkuser(MemberVO member) {
		 Map<String, Object> map = new HashMap<String, Object>();
	        if (member == null) {
	            return null;
	        }
//	        member.setPassword(Md5Encoder.generateCode(member.getPassword()));
	        MemberVO user = (MemberVO)this.queryForObject("stock_Member.checkMember", member);
	        map.put("user", user);
	        return map;
	}

	/**
	 * 新增用户
	 */
	@Override
	public MemberVO adduser(MemberVO member) {
		
		MemberVO user  = new MemberVO();
		if(member!=null){
			user.setCompanyId(1L);
			user.setCreatedDate(new Date());
			user.setDataStatus(1);
			user.setUsername(member.getUsername());
			user.setPassword(Md5Util.MD5(member.getPassword()));
			user.setEmail(member.getEmail());
			user.setMobile(member.getMobile());
		}
		this.insert("stock_Member.insertMemberVO", user);
		return user;
	}

	/**
	 * 登入验证
	 */
	@Override
	public Map<String, Object> logonCheckuser(MemberVO member) {
		 Map<String, Object> map = new HashMap<String, Object>();
         if (member == null) {
            return null;
         }
	     member.setPassword(Md5Util.MD5(member.getPassword()));
         MemberVO user = (MemberVO)this.queryForObject("stock_Member.logonCheckMember", member);
         map.put("user", user);
         return map;
	}

}
