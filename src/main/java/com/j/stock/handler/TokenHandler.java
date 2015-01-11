/**
 * @Title: TokenHandler.java
 * @Package com.youpeng.edu.handler
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Juning juning@tourerp.cn   
 * @date 2013-11-18 上午10:12:13 
 * @version V1.0
 */
package com.j.stock.handler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.j.stock.constants.Constants;


/**
 * @author Juning juning@tourerp.cn
 * @ClassName: TokenHandler
 * @Description: token处理类
 * @date 2013-11-18 上午10:12:13
 */
public class TokenHandler {
    private static Logger logger = Logger.getLogger(TokenHandler.class);

    static Map<String, String> springmvc_token = new HashMap<String, String>();

    // 生成一个唯一值的token
    @SuppressWarnings("unchecked")
    public synchronized static String generateGUID(HttpSession session) {
        String token = "";
        try {
            Object obj = session.getAttribute("SPRINGTOKEN");
            if (obj != null)
                springmvc_token = (Map<String, String>) session
                        .getAttribute("SPRINGTOKEN");
            token = new BigInteger(165, new Random()).toString(36)
                    .toUpperCase();
            springmvc_token.put(Constants.DEFAULT_TOKEN_NAME + "." + token,
                    token);
            session.setAttribute("SPRINGTOKEN", springmvc_token);
            session.setAttribute("token", token);
            Constants.TOKEN_VALUE = token;

        } catch (IllegalStateException e) {
            logger.error("generateGUID() mothod find bug,by token session...");
        }
        return token;
    }

    // 验证表单token值和session中的token值是否一致
    @SuppressWarnings("unchecked")
    public static boolean validToken(HttpServletRequest request) {
        String inputToken = getInputToken(request);

        if (inputToken == null) {
            logger.warn("token is not valid!inputToken is NULL");
            return false;
        }

        HttpSession session = request.getSession();
        Map<String, String> tokenMap = (Map<String, String>) session.getAttribute("SPRINGTOKEN");
        if (tokenMap == null || tokenMap.size() < 1) {
            logger.warn("token is not valid!sessionToken is NULL");
            return false;
        }
        String sessionToken = tokenMap.get(Constants.DEFAULT_TOKEN_NAME + "." + inputToken);
//        if (!inputToken.equals(sessionToken)) {
//            logger.warn("token is not valid!inputToken='" + inputToken + "',sessionToken = '" + sessionToken + "'");
//            return false;
//        }
        tokenMap.remove(Constants.DEFAULT_TOKEN_NAME + "." + inputToken);
        session.setAttribute("SPRINGTOKEN", tokenMap);
        String newtoken = "";
        newtoken = new BigInteger(165, new Random()).toString(36).toUpperCase();
        tokenMap.put(Constants.DEFAULT_TOKEN_NAME + "." + newtoken, newtoken);
        session.setAttribute("SPRINGTOKEN", tokenMap);
        session.setAttribute("token", newtoken);
        return true;
    }

    // 获取表单中token值
    @SuppressWarnings("unchecked")
    public static String getInputToken(HttpServletRequest request) {
        Map params = request.getParameterMap();

        if (!params.containsKey(Constants.DEFAULT_TOKEN_NAME)) {
            logger.warn("Could not find token name in params.");
            return null;
        }

        String[] tokens = (String[]) params.get(Constants.DEFAULT_TOKEN_NAME);

        if ((tokens == null) || (tokens.length < 1)) {
            logger.warn("Got a null or empty token name.");
            return null;
        }

        return tokens[0];
    }
}
