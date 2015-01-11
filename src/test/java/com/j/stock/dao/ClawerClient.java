package com.j.stock.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClawerClient {
	/** 
	 * 当有些网页中存在一些嵌套的redirect连接时，它就会报Server redirected too many times这样的错误， 
	 * 这是因为此网页内部又有一些代码是转向其它网页的，循环过多导致程序出错。如果只想抓取本URL中的网页内容， 
	 * 而不愿意让它有其它 的网页跳转，可以用以下的代码。 
	 * @param myurl 
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	public static String clawer2(String myurl) throws Exception{
		URL urlmy = new URL(myurl);
		HttpURLConnection con = (HttpURLConnection) urlmy.openConnection();
		con.setFollowRedirects(true);
		con.setInstanceFollowRedirects(false);
		con.connect();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		String s = "";
		StringBuffer sb = new StringBuffer("");
		while ((s = br.readLine()) != null) {
		sb.append(s+"\r\n");
		
		}
	    return sb.toString();
	}
}
