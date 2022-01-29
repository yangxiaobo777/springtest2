package com.yang.advice;

import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class MyAspect1 {
    @Around("execution(* com.yang.service..*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("====qing====");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("======hou======");
        return proceed;
    }
}
