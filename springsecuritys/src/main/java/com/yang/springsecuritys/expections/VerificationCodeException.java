package com.yang.springsecuritys.expections;

import org.springframework.security.core.AuthenticationException;

/**
 * @author yang
 * @className VerificationCodeException
 * @description TODO
 * @date 2021/12/20 11:04
 * @Version 1.0
 */
public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException(){
        super("图形验证码校验失败");
    }
}
