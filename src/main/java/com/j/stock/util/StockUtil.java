package com.j.stock.util;

import java.math.BigDecimal;
import java.util.Date;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.j.stock.vo.StockVO;

public class StockUtil {

	
	public static void main(String[] args){
		getStock("TBAC");
	}
	public static StockVO getStock(String code){
		StockVO s = new StockVO();
		try {

//			Connection newconnection = Jsoup.connect("http://finance.yahoo.com/q/h?s="+code+"+Headlines");
            Connection newconnection = Jsoup.connect("http://finance.yahoo.com/q/h?s="+code+"");
			newconnection.timeout(20000);
			Document newDoc = newconnection.get();
			Elements newslis = newDoc.select("div#screen div#rightcol table#yfncsumtab").select("li");
            String title = "";
            String time = "";
            String url = "#";
            if(newslis!=null && newslis.size()>0){
                 title = newslis.get(0).text();
                 time = newslis.get(0).select("span").text();
                Elements urls = newslis.get(0).select("a");

                if (!urls.isEmpty()) {
                    for (Element link : urls) {
                        url = link.absUrl("href");
                    }
                }
            }

			
			Connection connection = Jsoup.connect("http://www.nasdaq.com/symbol/"+code);
			connection.timeout(20000);
			Document doc = connection.get();
	        Elements trs = doc.select("div#content_main table#quotes_content_left_InfoQuotesResults").select("tr");
	        Elements name = doc.select("#qwidget_pageheader h1");
	        Elements hs = null;
	        if(name.size()>0){
	        	 hs = name.get(0).select("h1");
                //公司名称
                for(int j = 0;j<hs.size();j++){
                    String text = hs.get(j).text().replaceAll("Stock Quote & Summary Data", "").trim();
                    s.setCompany(text);
                }
	        }else{
//                System.out.println(code);
//	        	return null;
	        }
			//公司代号
			s.setCode(code);

            //当前价
            Elements lastsales = doc.select("#qwidget_lastsale");
            if(lastsales.size()>0){
            	Elements lastsale = lastsales.get(0).select("div");
				//公司名称
	            for(int j = 0;j<lastsale.size();j++){
	                String text = lastsale.get(j).text();
	                s.setCurrentPrice(text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim());
	            }
            }
            
            //涨跌幅(当日)
            Elements qwidgetnetchanges = doc.select("div#qwidget_netchange.qwidget-Green"); 
            if(qwidgetnetchanges.size()>0){
            	Elements qwidgetGreen = qwidgetnetchanges.get(0).select("div");
	            for(int j = 0;j<qwidgetGreen.size();j++){
	                String text = qwidgetGreen.get(j).text();
	                s.setQuoteChangeTd(text);
	            }
            }else{
            	  qwidgetnetchanges = doc.select("div#qwidget_netchange.qwidget-Red");
            	  if(qwidgetnetchanges.size()>0){
            		  Elements qwidgetGreen = qwidgetnetchanges.get(0).select("div");
	  		          for(int j = 0;j<qwidgetGreen.size();j++){
	  		               String text = qwidgetGreen.get(j).text();
	  		               s.setQuoteChangeTd("-"+text);
	  		           }
            	  }
            }
            
            //涨跌额(当日)
            Elements qwidgetPercents = doc.select("div#qwidget_percent.qwidget-Green");
            if(qwidgetPercents.size()>0){
            	Elements qwidgetGreen = qwidgetPercents.get(0).select("div");
	            for(int j = 0;j<qwidgetGreen.size();j++){
	                String text = qwidgetGreen.get(j).text();
	                s.setAmountChangeTd(text);
	            }
            }else{
            	  qwidgetPercents = doc.select("div#qwidget_percent.qwidget-Red");
            	  if(qwidgetPercents.size()>0){
            		  Elements qwidgetGreen = qwidgetPercents.get(0).select("div");
	  		            for(int j = 0;j<qwidgetGreen.size();j++){
	  		                String text = qwidgetGreen.get(j).text();
	  		                s.setAmountChangeTd("-"+text);
	  		            }
            	  }
            	  
            }
            
	        for(int i = 0;i<trs.size();i++){
	            Elements tds = trs.get(i).select("td");
	            int type = 0;
	            for(int j = 0;j<tds.size();j++){
	                String text = tds.get(j).text();
	                if(type>0){
	                	if(type==1){
	                		s.setAmplitude(text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim());
	                	}else if(type==2) {
	                		s.setTradingVolume(text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim());
	                	}else if(type==3) {
	                		s.setMarketCap(text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim());
	                		String data  =  text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim();
	                		BigDecimal d =  new BigDecimal(data);
	                		String curData = s.getCurrentPrice().replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim();
	                		BigDecimal curDataDown =  new BigDecimal(curData);
	                		s.setCapitalization(d.divide(curDataDown, 2, BigDecimal.ROUND_HALF_UP).toString());
	                		 
	                	}else if(type==4) {
	                		s.setPe(text.replaceAll(" ", "").replaceAll("\\$", "").replaceAll(",", "").trim());
	                	}else if(type==5){
//	                		s.setCurrentPrice(text);
	                	}
	                	 type=0;
	            	}
	                if(text.indexOf("52 Week High/Low")==0){
	                	type=1;//52  amplitude	52周股价幅度
	                }else if(text.indexOf("Share Volume")==0){
	                	type=2;//trading_volume	成交量
	                }else if(text.indexOf("Market cap")==0){
	                	type=3;//market_cap	市值
	                }else if(text.indexOf("P/E Ratio")==0){
	                	type=4;//PE	市盈率
	                }else if(text.indexOf("Previous Close")==0){
//	                	type=5;//昨天当前价
	                }
	               
	            }
	        }
	        /*********************************今日盘前***************************************/
	        //盘前
            Connection pConnection  = Jsoup.connect("http://www.nasdaq.com/symbol/"+code+"/premarket");
            pConnection.timeout(20000);
	    	doc = pConnection.get();
//            connection.timeout(20000);
	    	 //涨跌幅(今日盘前)
            qwidgetnetchanges = doc.select("div#qwidget_netchange.qwidget-Green"); 
            if(qwidgetnetchanges.size()>0){
            	Elements qwidgetGreen = qwidgetnetchanges.get(0).select("div");
	            for(int j = 0;j<qwidgetGreen.size();j++){
	                String text = qwidgetGreen.get(j).text();
	                s.setQuoteChangeTb(text);
	            }
            }else{
            	  qwidgetnetchanges = doc.select("div#qwidget_netchange.qwidget-Red");
            	  if(qwidgetnetchanges.size()>0){
            		  Elements qwidgetGreen = qwidgetnetchanges.get(0).select("div");
	  		            for(int j = 0;j<qwidgetGreen.size();j++){
	  		                String text = qwidgetGreen.get(j).text();
	  		                s.setQuoteChangeTb("-"+text);
	  		            }
            	  }
            	 
            }
            
            //涨跌额(今日盘前)
            qwidgetPercents = doc.select("div#qwidget_percent.qwidget-Green");
            if(qwidgetPercents.size()>0){
            	Elements qwidgetGreen = qwidgetPercents.get(0).select("div");
	            for(int j = 0;j<qwidgetGreen.size();j++){
	                String text = qwidgetGreen.get(j).text();
	                s.setAmountChangeTb(text);
	            }
            }else{
            	  qwidgetPercents = doc.select("div#qwidget_percent.qwidget-Red");
            	  if(qwidgetPercents.size()>0){
            		  Elements qwidgetGreen = qwidgetPercents.get(0).select("div");
	  		            for(int j = 0;j<qwidgetGreen.size();j++){
	  		                String text = qwidgetGreen.get(j).text();
	  		                s.setAmountChangeTb("-"+text);
	  		            }
            	  }
            	  
            }

            /*********************************昨日盘后****************************************/
	    	//盘后

            Connection phConnection  = Jsoup.connect("http://www.nasdaq.com/symbol/"+code+"/after-hours");
            phConnection.timeout(20000);
            doc = phConnection.get();

//	    	doc = Jsoup.connect("http://www.nasdaq.com/symbol/"+code+"/after-hours").get();
	    	 //涨跌幅(昨日盘后)
            qwidgetnetchanges = doc.select("div#qwidget_netchange.qwidget-Green"); 
            if(qwidgetnetchanges.size()>0){
            	Elements qwidgetGreen = qwidgetnetchanges.get(0).select("div");
	            for(int j = 0;j<qwidgetGreen.size();j++){
	                String text = qwidgetGreen.get(j).text();
	                s.setQuoteChangeYa(text);
	            }
            }else{
            	  qwidgetnetchanges = doc.select("div#qwidget_netchange.qwidget-Red");
            	  if(qwidgetnetchanges.size()>0){
            		  Elements qwidgetGreen = qwidgetnetchanges.get(0).select("div");
	  		            for(int j = 0;j<qwidgetGreen.size();j++){
	  		                String text = qwidgetGreen.get(j).text();
	  		                s.setQuoteChangeYa("-"+text);
	  		            }
            	  }
            	 
            }
            
            //涨跌额(昨日盘后)
            qwidgetPercents = doc.select("div#qwidget_percent.qwidget-Green");
            if(qwidgetPercents.size()>0){
            	Elements qwidgetGreen = qwidgetPercents.get(0).select("div");
	            for(int j = 0;j<qwidgetGreen.size();j++){
	                String text = qwidgetGreen.get(j).text();
	                s.setAmountChangeYa(text);
	            }
            }else{
            	  qwidgetPercents = doc.select("div#qwidget_percent.qwidget-Red");
            	  if(qwidgetPercents.size()>0){
            		  Elements qwidgetGreen = qwidgetPercents.get(0).select("div");
	  		            for(int j = 0;j<qwidgetGreen.size();j++){
	  		                String text = qwidgetGreen.get(j).text();
	  		                s.setAmountChangeYa("-"+text);
	  		            }
            	  }
            	
            }
	        
	        s.setCreatedDate(new Date());
	        s.setStockInfoTime(time);
	        s.setStockInfoUrl(url);
	        s.setStockTitle(title);
	        return s;
        } catch (Exception e) {
            System.out.println("time out:"+code);
            e.printStackTrace();
//            getStock(code);
        }
        return null;
		
	}
}
