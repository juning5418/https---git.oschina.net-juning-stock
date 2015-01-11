package com.j.stock.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.j.stock.vo.MemberVO;

public class SessionTimeoutInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(SessionTimeoutInterceptor.class.getName());
	 
    @Override
    public boolean preHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o) throws Exception {
    	MemberVO user=(MemberVO) hsr.getSession().getAttribute("user");
        if(user==null){
            logger.log(Level.INFO, "user not login");
            hsr1.sendRedirect("/stock/index");
            return false;
        }
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav) throws Exception {
    }
 
    @Override
    public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn) throws Exception {
    }
}
