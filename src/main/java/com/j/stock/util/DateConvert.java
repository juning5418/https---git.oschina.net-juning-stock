/**
 * Project: tourerp-core-java
 * 
 * File Created at 2013-1-12
 * $Id$
 * 
 * Copyright 2009 Hangzhou Unibon Technology Inc., All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Unibon Technology Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with tourerp.cn .
 */
package com.j.stock.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import net.sf.cglib.core.Converter;

/**
 * TODO Comment of DateConvert
 *
 */
public class DateConvert implements Converter {

    private static String dateFormatStr = "yyyy/MM/dd";  
    private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat(dateFormatStr);  
      
    private static String dateLongFormatStr = dateFormatStr+" HH:mm:ss";  
    private static SimpleDateFormat dateTimeLongFormat = new SimpleDateFormat(dateLongFormatStr);  
  
    @SuppressWarnings("unchecked")
    public Object convert(Class arg0, Object arg1) {  
        if(arg1==null){
            return null;
        }
        String className = arg1.getClass().getName();  
        //java.sql.Timestamp  
        if ("java.util.Date".equalsIgnoreCase(className)) {  
            try {  
                SimpleDateFormat df = new SimpleDateFormat(dateFormatStr + " HH:mm:ss");  
                return df.parse(dateTimeLongFormat.format(arg1));  
            } catch (Exception e) {  
                try {  
                    SimpleDateFormat df = new SimpleDateFormat(dateFormatStr);  
                    return df.parse(dateTimeFormat.format(arg1));  
                } catch (ParseException ex) {  
                    e.printStackTrace();  
                    return null;  
                }  
            }  
        }else{//java.util.Date,java.sql.Date  
            String p = (String) arg1;  
            if (p == null || p.trim().length() == 0) {  
                return null;  
            }  
            try {  
                SimpleDateFormat df = new SimpleDateFormat(dateFormatStr + " HH:mm:ss");  
                return df.parse(p.trim());  
            } catch (Exception e) {  
                try {  
                    SimpleDateFormat df = new SimpleDateFormat(dateFormatStr);  
                    return df.parse(p.trim());  
                } catch (ParseException ex) {  
                    e.printStackTrace();  
                    return null;  
                }  
            }  
        }  
    }  
      
    public static String formatDateTime(Object obj) {  
        if (obj != null)  
            return dateTimeFormat.format(obj);  
        else  
            return "";  
    }  
      
    public static String formatLongDateTime(Object obj) {  
        if (obj != null)  
            return dateTimeLongFormat.format(obj);  
        else  
            return "";  
    }

	@Override
	public Object convert(Object arg0, Class arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}  

}
