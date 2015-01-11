package com.j.stock.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j.stock.response.JsonResponse;
import com.j.stock.vo.MemberVO;

public interface MemberServcie {

	JsonResponse checkuser(MemberVO member);
	
	MemberVO adduser(MemberVO member);
	
	/**
	 * 登入验证用户
	 * @param member
	 * @return
	 */
	JsonResponse logonCheckuser(MemberVO member);
}
