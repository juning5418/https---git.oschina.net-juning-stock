package com.j.stock.quartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.j.stock.dao.StockDao;
import com.j.stock.util.StockUtil;
import com.j.stock.vo.StockCompanyVO;

public class QuartzJob {

	@Autowired
    private StockDao stockDao;


    public void work() {
        List<StockCompanyVO> list = stockDao.queryStocks();

        if(list!=null){
            int size = list.size();
//            if(list.size()>3){
//                size =  list.size()/3;
//            }

            for(int ii=0 ;ii < size ; ii ++){
                StockCompanyVO sc = list.get(ii);
                String code = sc.getCode();
                stockDao.addQuartzStock(StockUtil.getStock(code));
            }
        }

        System.out.println("Quartz的任务调度！！！");
    }

	public void work1() {
		List<StockCompanyVO> list = stockDao.queryStocks();

		if(list!=null){
            int size = list.size();
            if(list.size()>3){
                size =  list.size()/3;
            }

			for(int ii=0 ;ii < size ; ii ++){
				StockCompanyVO sc = list.get(ii);
				String code = sc.getCode();
			    stockDao.addQuartzStock(StockUtil.getStock(code));
			}
		}
		
        System.out.println("Quartz的任务调度！！！");  
    }
	
	public void getOneInfoWork() {
		List<StockCompanyVO> list = stockDao.queryStocks();
		if(list!=null){
            int size = list.size();
            int start = 0;
            if(list.size()>3){
                start = list.size()/3;
                size = 2 *(list.size()/3);
            }
			for(int ii=start ;ii < size ; ii ++){
				StockCompanyVO sc = list.get(ii);
				String code = sc.getCode();
			    stockDao.addQuartzStock(StockUtil.getStock(code));
			}
		}
        System.out.println("Quartz2的任务调度！！！");
    }

    public void getTowInfoWork() {
        List<StockCompanyVO> list = stockDao.queryStocks();
        if(list!=null){
            int size = list.size();
            int start = 0;
            if(list.size()>3){
                start = 2 *(list.size()/3);
            }
            for(int ii=start ;ii < size ; ii ++){
                StockCompanyVO sc = list.get(ii);
                String code = sc.getCode();
                stockDao.addQuartzStock(StockUtil.getStock(code));
            }
        }
        System.out.println("Quartz3的任务调度！！！");
    }

}
