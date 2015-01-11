package com.j.stock.controller;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.j.stock.util.ContextHolderUtils;
import com.j.stock.util.CustomDateEditor;


import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 *
 */
public class BaseController {

    public static final String PAGE_ATTR = "pageAttr";

    /**
     * 保存用户到SESSION
     */
    public static final String PROXY = "proxy";
    
    public static final String USER_SESSION="USER_SESSION";
    
    public static final String STUDENT = "student";
	public static final String USER = "user";
	public static final String TRAINING_CLASS = "trainingClass";
	public static final String TRAINING_CLASS_LIST = "trainingClassList";
	
	public static final String LOGIN_PAGE = "loginPre";
	public static final String ADD = "add";
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";//change to success as to show error message in the same page.
	public static final String LIST_SUCCESS = "list_success";
	public static final String READ_SUCCESS = "read_success";
	public static final String ADD_SUCCESS = "add_success";
	public static final String DELETE_SUCCESS = "delete_success";
	public static final String CONTINUE_ADD = "continue_add";
	public static final int BUYSUCCESS = 1;// 购买课程成功
	public static final int BUYFAILD = -1;// 购买课程失败
	public static final int WHETHERBUY = 0;	// 是否购买课程
	public static final int ALREADYBUY = 2;	// 已经购买该课程
	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 * 
	 * @param binder
	 * 
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		// binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
		
		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {

            @Override
	        public void setAsText(String text) throws IllegalArgumentException {  
	        	if (text == null || (text = text.trim()).length() == 0) {          
	    			return;     
	    		}
	    		try {        //去除html标签    
	    			String str = "";
//	    			String str = text.replaceAll("<[a-zA-Z]+[1-9]?[^><]*>", "")
//	    					.replaceAll("</[a-zA-Z]+[1-9]?>", "");  
	    			str=encode(text);
	    			//str.replace("'", "");
	    			setValue(str);      
	    		} catch (Exception e) 
	    		{          
	    			throw new IllegalArgumentException(e);      
	    		}  
	        }  
	    });  
		
	}
	
	/**
	  * 替换内容中的特殊符号
	  *
	  * @return
	  * @Author
	  */
	 public static String encode(String s) {
		 	s = s.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
	        s = s.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
	        s = s.replaceAll("'", "& #39;");
	        s = s.replaceAll("eval\\((.*)\\)", "");
	        s = s.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']",
	                "\"\"");
	        s = s.replaceAll("script", "");
	        return s;
	 }

    public String getContextPath(){
        HttpSession session = ContextHolderUtils.getSession();
        return session.getServletContext().getContextPath();
    }

}
