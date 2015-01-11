package com.j.stock.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.j.stock.dao.BaseDao;
import com.j.stock.dao.StockDao;
import com.j.stock.response.JsonResponse;
import com.j.stock.util.StockUtil;
import com.j.stock.vo.MemberStockCompanyVO;
import com.j.stock.vo.MemberVO;
import com.j.stock.vo.StockCompanyVO;
import com.j.stock.vo.StockVO;

@Repository
public class StockDaoImpl extends BaseDao implements StockDao{

	@Override
	public JsonResponse addStock(String companyCode, MemberVO loginUser) {
    	JsonResponse j = new JsonResponse();

		StockCompanyVO sc = new StockCompanyVO();
		sc.setCode(companyCode.toUpperCase());
		sc.setDataStatus(1);
		sc.setCreatedDate(new Date());
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("code", companyCode.toUpperCase());
		StockCompanyVO s = (StockCompanyVO)this.queryForObject("Stock_stockCompany.loadstockCompanyVOList", m);
		if(s==null){
			this.insert("Stock_stockCompany.insertstockCompanyVO", sc);
		}
		
		MemberStockCompanyVO msc = new MemberStockCompanyVO();
		msc.setCode(companyCode.toUpperCase());
		msc.setCompanyCode(companyCode.toUpperCase());
		msc.setCreatedBy(loginUser.getId());
		msc.setCreatedDate(new Date());
		msc.setMemberId(loginUser.getId());
		m.put("createdBy", loginUser.getId());
		MemberStockCompanyVO mscv = (MemberStockCompanyVO)this.queryForObject("Stock_MemberStockCompany.checkMemberStockCompanyVOList", m);
		if(mscv==null){
			this.insert("Stock_MemberStockCompany.insertMemberStockCompanyVO", msc);
		}
		return j;
	}

	@Override
	public List<StockVO> queryStockByUser(Long id) {
		// TODO Auto-generated method stub
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("createdBy", id);
		return (List<StockVO>) this.queryForList("Stock_Stock.loadStockVOList", m);
	}

	@Override
	public JsonResponse delStock(String companyCode, MemberVO loginUser) {
		JsonResponse j = new JsonResponse();
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("code", companyCode);
		m.put("createdBy", loginUser.getId());
		this.delete("Stock_MemberStockCompany.deleteMemberStocksCompanyCode", m);
		return j;
	}

	@Override
	public void addQuartzStock(StockVO stock) {
		Map<String,Object> m = new HashMap<String,Object>();
		if(stock!=null){
			m.put("code", stock.getCode());
			this.delete("Stock_Stock.deleteStockVOsByCode", m);
			this.insert("Stock_Stock.insertStockVO", stock);
		}
		
	}

	@Override
	public List<StockCompanyVO> queryStocks() {
		// TODO Auto-generated method stub
		return (List<StockCompanyVO>) this.queryForList("Stock_stockCompany.loadstockCompanyVO", null);
	}

}
