package com.shiyanlou.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    // @Before("execution(public * com.shiyanlou.spring.aop.aspectj.CustomerBo.addCustomer(..))")
    // public void logBefore(JoinPoint joinPoint){
    //     System.out.println("logBefore() is running ...");
    //     System.out.println("hijacked:"+joinPoint.getSignature().getName());
    //     System.out.println("**********");
    // }

    // @After("execution(public * com.shiyanlou.spring.aop.aspectj.CustomerBo.deleteCustomer(..))")
    // public void logAfter(JoinPoint joinPoint){
    //     System.out.println("logAfter() is running ...");
    //     System.out.println("hijacked:"+joinPoint.getSignature().getName());
    //     System.out.println("**********");
    // }

 // 将 Advicd 和 Pointcut 分开

    @Before("com.shiyanlou.spring.aop.aspectj.PointcutsDefinition.customerLog()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("logBefore() is running ...");
        System.out.println("hijacked:"+joinPoint.getSignature().getName());
        System.out.println("**********");
    }

    @After("com.shiyanlou.spring.aop.aspectj.PointcutsDefinition.customerLog()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("logAfter() is running ...");
        System.out.println("hijacked:"+joinPoint.getSignature().getName());
        System.out.println("**********");
    }
}