package com.j.stock.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.j.stock.vo.StockVO;




public class Test {

	public static void main(String[] args)
	{
		
		//http://www.nasdaq.com/symbol/${l.code} atrm
		//http://www.nasdaq.com/aspx/symbolnamesearch.aspx?q=A
		String code = "a";
		try {
			Document doc = Jsoup.connect("http://www.nasdaq.com/symbol/"+code).get();
			String datas = "";
			  //当前价
            Elements lastsales = doc.select("#qwidget_lastsale");
            if(lastsales.size()>0){
            	Elements lastsale = lastsales.get(0).select("div");
				//公司名称
	            for(int j = 0;j<lastsale.size();j++){
	                String text = lastsale.get(j).text();
	                datas = text;
	            }
            }
			//http://www.nasdaq.com/symbol/atrm/time-sales
			 Elements trs = doc.select("table.datatable1_qn").select("tr");
			for(int i = 0;i<trs.size();i++){
	            Elements tds = trs.get(i).select("td");
	            int type = 0;
	            for(int j = 0;j<tds.size();j++){
	            	
	                String text = tds.get(j).text();
	                if(type>0){
	                	if(type==1){
	                		
	                	}else if(type==2) {
	                		
	                	}else if(type==3) {
	                		String data  =  text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim();
	                		System.out.println(text);
	                		BigDecimal d =  new BigDecimal(data);
	                		String curData = datas.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim();
	                		System.out.println(curData);
	                		BigDecimal curDataDown =  new BigDecimal(curData);
	                		System.out.println(d.divide(curDataDown, 2, BigDecimal.ROUND_HALF_UP).toString());
	                	}else if(type==4) {
	                		
	                	}else if(type==5) {
	                		
	                	}
	                	 
	                	 type=0;
	            	}
	                if(text.indexOf("52 Week High /Low")>=0){
	                	type=1;//52  amplitude	52周股价幅度
	                }else if(text.indexOf("Share Volume")>=0){
	                	type=2;//trading_volume	成交量
	                }else if(text.indexOf("Market cap")>=0){
	                	type=3;//market_cap	市值 
	                }else if(text.indexOf("P/E Ratio")>=0){
	                	type=4;//pe	市盈率
	                }
	               
	            }
	        }
            

            
			 String code1 = "A";
		} catch (Exception e) {
			e.printStackTrace();
		}  
      
	
	}
}
