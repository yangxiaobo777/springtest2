package com.yang.springsecuritys.providers;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author yang
 * @className MyWebAuthenticationDetails
 * @description TODO
 * @date 2021/12/21 10:54
 * @Version 1.0
 */
public class MyWebAuthenticationDetails extends WebAuthenticationDetails {

    private boolean imageCodeIsRrght;

    public boolean getImageCodeIsRrght(){
        return imageCodeIsRrght;
    }

    public MyWebAuthenticationDetails(HttpServletRequest request){
        super(request);
        String requestCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String sessionCode = (String)session.getAttribute("captcha");
        if(!StringUtils.isEmpty(sessionCode)){
            session.removeAttribute("captcha");
        }

        if(!StringUtils.isEmpty(requestCode)||!StringUtils.isEmpty(sessionCode)||requestCode.equals(sessionCode)){
            imageCodeIsRrght = true;
        }

    }
}
