package com.j.stock.dao;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "Best Bid /Ask:";
	
		 if(a.indexOf("52 Week High /Low:")==0){
				System.out.println(a.indexOf("52 Week High /Low:"));
		 }

	}

}
