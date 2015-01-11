/**   
* @Title: AvoidDuplicateSubmission.java 
* @Package com.youpeng.edu.interceptor 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Juning juning@tourerp.cn   
* @date 2013-11-18 上午11:37:24 
* @version V1.0   
*/
package com.j.stock.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



/**
 * <input type="hidden" name="token" value="${TOKEN}">
 * @author: tangjn
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCreate {
    boolean createToken() default false;
}

