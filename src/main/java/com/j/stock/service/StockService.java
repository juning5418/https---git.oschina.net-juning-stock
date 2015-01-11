package com.j.stock.service;

import java.util.List;

import com.j.stock.response.JsonResponse;
import com.j.stock.vo.MemberVO;
import com.j.stock.vo.StockVO;

public interface StockService {

	JsonResponse addStock(String companyCode,MemberVO loginUser);
	
	JsonResponse delStock(String companyCode,MemberVO loginUser);
	
	List<StockVO> queryStockByUser(Long id);
}
