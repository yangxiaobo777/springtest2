package com.yang.service.impl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.lang.reflect.Method;

/**
 * @author yang
 * @className MyException
 * @description TODO
 * @date 2020/11/26 21:30
 * @Version 1.0
 */

public class MyException implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        methodInvocation.proceed();
        return null;
    }
}
