package com.j.stock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.j.stock.controller.BaseController;
import com.j.stock.vo.MemberVO;
/**
* @ClassName: ContextHolderUtils 
* @Description: TODO(上下文工具类) 
* @author  
* @date 2013-07-18 09:27:39 
*
 */
public class ContextHolderUtils {
	/**
	 * SpringMvc下获取request
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;

	}
	/**
	 * SpringMvc下获取session
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = getRequest().getSession();
		return session;

	}

	public static final MemberVO getSessionUser() {
	    HttpSession session = getSession();
	    session.setMaxInactiveInterval(-1);
	    if (session.getAttributeNames().hasMoreElements()) {
	        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(BaseController.USER_SESSION);
	        if (sessionInfo != null) {
	            return sessionInfo.getUser();
	        } else {
	            
	            return null;
	        }
	        
	    } else {
	        return null;
	    }
	}
	
}
