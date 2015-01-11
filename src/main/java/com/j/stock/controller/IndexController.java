package com.j.stock.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.j.stock.response.JsonResponse;
import com.j.stock.service.MemberServcie;
import com.j.stock.service.StockService;
import com.j.stock.service.UserService;
import com.j.stock.util.ContextHolderUtils;
import com.j.stock.vo.MemberVO;
import com.j.stock.vo.StockVO;


@Controller
public class IndexController extends BaseController{
    @Autowired
    private UserService userService;    
    @Autowired
    private MemberServcie memberService;   
    @Autowired
    private StockService stockService; 
    
    private static final Log logger = LogFactory.getLog(IndexController.class);

    /**
     * 登入界面
     *
     * @param
     * @return
     */
	@RequestMapping(value="/index")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("tpl/index");
		return mv;
	}
	
	 /**
     * 登录后返回页面
     * @return
     */
	@RequestMapping(value="/user/home")
	public ModelAndView home(){
		 HttpSession session = ContextHolderUtils.getSession();
         MemberVO user = (MemberVO)session.getAttribute(BaseController.USER);
         List<StockVO> list = (List<StockVO>)stockService.queryStockByUser(user.getId());
		ModelAndView mv = new ModelAndView("tpl/user/stocks");
		 mv.addObject("list", list);
		return mv;
	}
	
	 /**
     * 注册界面
     *
     * @param
     * @return
     */
	@RequestMapping(value="/regist")
	public ModelAndView test(){
		ModelAndView mv = new ModelAndView("tpl/user/regist");
		return mv;
	}
	
	
	 /**
     * 检查用户名称
     * @param student
     * @par am req
     * @return
     */
    @RequestMapping(value = "/checkuser")
    @ResponseBody
    public JsonResponse checkuser(MemberVO member, HttpServletRequest request, HttpServletResponse respones) {
        return memberService.checkuser(member);
    }
    
    /**
     * 注册用户
     * @return
     */
    @RequestMapping(value="/doRegister", method = {RequestMethod.POST})
    public ModelAndView doRegister(MemberVO member, HttpServletRequest request){
    	HttpSession session = ContextHolderUtils.getSession();
        ModelAndView mv = null;
    	if(member!=null){
    		memberService.adduser(member);
            session.removeAttribute(BaseController.USER);
            session.setAttribute(BaseController.USER, member);
            mv = new ModelAndView("redirect:user/home");
            mv.addObject(BaseController.USER, member);
    	}else{
    	    mv = new ModelAndView("redirect:index");
    	}
		return mv;
	}
    
    
    

    /**
     * 登陆操作
     * @param student
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(MemberVO member) {
        HttpSession session = ContextHolderUtils.getSession();
        ModelAndView mv = null;
    	if(member!=null && member.getUsername()!=null && member.getPassword()!=null && !"".equals(member.getUsername())
    			&& !"".equals(member.getPassword())){
    		JsonResponse j = memberService.logonCheckuser(member);
    		if(j.isSuccess()){
    			session.removeAttribute(BaseController.USER);
	            session.setAttribute(BaseController.USER, member);
	            mv = new ModelAndView("redirect:user/home");
	            mv.addObject(BaseController.USER, member);
    		}else{
    			mv = new ModelAndView("redirect:index");
    		}
    	}else{
    	    mv = new ModelAndView("redirect:index");
    	}
		return mv;
    }
    
    
    /**
     * 登陆操作
     * @param student
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/stockInfo")
    public ModelAndView stockInfo(MemberVO member) {
    	 HttpSession session = ContextHolderUtils.getSession();
         MemberVO user = (MemberVO)session.getAttribute(BaseController.USER);
         List<StockVO> list = (List<StockVO>)stockService.queryStockByUser(user.getId());
		ModelAndView mv = new ModelAndView("tpl/user/stocks_news");
		 mv.addObject("list", list);
		return mv;
    }

	
}
