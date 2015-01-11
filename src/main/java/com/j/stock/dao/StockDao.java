package com.j.stock.dao;

import java.util.List;

import com.j.stock.response.JsonResponse;
import com.j.stock.vo.MemberVO;
import com.j.stock.vo.StockCompanyVO;
import com.j.stock.vo.StockVO;

public interface StockDao {

	JsonResponse addStock(String companyCode,MemberVO loginUser);
	
	 List<StockVO> queryStockByUser(Long id);
	 
	 JsonResponse  delStock(String companyCode, MemberVO loginUser);
	 
	 void addQuartzStock(StockVO stockVO);
	 
	 List<StockCompanyVO> queryStocks();
}
