package com.j.stock.util;

import java.io.Serializable;

import com.j.stock.vo.MemberVO;

public class SessionInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4681364235537558691L;
	private MemberVO user;

	public MemberVO getUser() {
		return user;
	}

	public void setUser(MemberVO user) {
		this.user = user;
	}
   
    
}
