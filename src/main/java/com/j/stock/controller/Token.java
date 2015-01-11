/**   
* @Title: Token.java 
* @Package com.youpeng.edu.interceptor 
* @Description: TODO(用一句话描述该文件做什么) 
* @author Juning juning@tourerp.cn   
* @date 2013-11-18 下午12:11:01 
* @version V1.0   
*/
package com.j.stock.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: Token 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Juning juning@tourerp.cn 
 * @date 2013-11-18 下午12:11:01  
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
    boolean needCheckToken() default false;
}
