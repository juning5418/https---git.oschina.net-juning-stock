/* 
 * Stock
 *
 * Copyright (c) 2009 Hangzhou ValueSoft Inc., All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ValueSoft Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with ValueSoft.com.
 * 
 * Revision History
 * Date      		Programmer       Notes
 * 2013-12-29   	    juning		     Initial
 **********************************************************************
*/
package com.j.stock.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.j.stock.response.JsonResponse;
import com.j.stock.service.MemberServcie;
import com.j.stock.service.StockService;
import com.j.stock.vo.MemberVO;

@Controller
public class StockCtrl extends BaseController{
	
	private static final Log logger = LogFactory.getLog(StockCtrl.class);
	 
	@Autowired
    private MemberServcie memberService; 
	
	@Autowired
    private StockService stockService; 
	 /*
     * 显示布置作业的题目里的题目
     */
    @RequestMapping(value = "/user/addStock/{companyCode}")
    public JsonResponse addStock(@PathVariable String companyCode,HttpServletRequest request) {
    	MemberVO loginUser = (MemberVO)request.getSession().getAttribute(USER);
    	return stockService.addStock(companyCode,loginUser);
    }
    
    @RequestMapping(value = "/user/delStock/{companyCode}")
    public JsonResponse delStock(@PathVariable String companyCode,HttpServletRequest request) {
    	MemberVO loginUser = (MemberVO)request.getSession().getAttribute(USER);
    	return stockService.delStock(companyCode,loginUser);
    }
	
}
