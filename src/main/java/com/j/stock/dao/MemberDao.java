package com.j.stock.dao;


import java.util.Map;

import com.j.stock.vo.MemberVO;

public interface MemberDao {

	/**
	 * 注册验证用户
	 * @param member
	 * @return
	 */
	Map<String,Object> checkuser(MemberVO member);
	
	/**
	 * 登入验证用户
	 * @param member
	 * @return
	 */
	Map<String,Object> logonCheckuser(MemberVO member);
	
	/**
	 * 新增会员
	 * @param member
	 * @return
	 */
	MemberVO adduser(MemberVO member);

}
