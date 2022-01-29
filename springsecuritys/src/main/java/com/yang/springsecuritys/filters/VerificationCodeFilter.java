package com.yang.springsecuritys.filters;

import com.yang.springsecuritys.expections.VerificationCodeException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author yang
 * @className VerificationCodeFilter
 * @description TODO
 * @date 2021/12/20 11:08
 * @Version 1.0
 */

public class VerificationCodeFilter extends OncePerRequestFilter {


    private AuthenticationFailureHandler authenticationFailureHandler = new MyAuthenticationFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
          String requestURI = request.getRequestURI();
          if(!"/auth/form".equals(request.getRequestURI())){
              filterChain.doFilter(request,response);
          }else {
              try{
                  verificationCode(request);
                  filterChain.doFilter(request,response);
              }catch (VerificationCodeException e){
                  authenticationFailureHandler.onAuthenticationFailure(request,response,e);
              }

          }
    }

    private void verificationCode(HttpServletRequest request) throws VerificationCodeException {
        String requestCode = request.getParameter("captcha");
        HttpSession session = request.getSession();
        String saveCode = (String)session.getAttribute("captcha");
        if(!StringUtils.isEmpty(saveCode)){
            session.removeAttribute("captcha");
        }

        if(StringUtils.isEmpty(requestCode) || StringUtils.isEmpty(saveCode) || !requestCode.equals(saveCode)){
            throw new VerificationCodeException();
        }
    }
}
