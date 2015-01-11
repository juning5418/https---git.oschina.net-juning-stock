package com.j.stock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.stock.dao.MemberDao;
import com.j.stock.dao.StockDao;
import com.j.stock.response.JsonResponse;
import com.j.stock.service.StockService;
import com.j.stock.util.StockUtil;
import com.j.stock.vo.MemberVO;
import com.j.stock.vo.StockVO;
@Service
public class StockServiceImpl implements StockService{

	@Autowired
    private MemberDao memberDao;
	
	@Autowired
    private StockDao stockDao;

	@Override
	public JsonResponse addStock(String companyCode,MemberVO loginUser) {
		stockDao.addQuartzStock(StockUtil.getStock(companyCode));
    	return stockDao.addStock(companyCode,loginUser);
	}

	@Override
	public List<StockVO> queryStockByUser(Long id) {
		// TODO Auto-generated method stub
		return stockDao.queryStockByUser(id);
	}

	@Override
	public JsonResponse delStock(String companyCode, MemberVO loginUser) {
		// TODO Auto-generated method stub
		return stockDao.delStock(companyCode,loginUser);
	}
}
