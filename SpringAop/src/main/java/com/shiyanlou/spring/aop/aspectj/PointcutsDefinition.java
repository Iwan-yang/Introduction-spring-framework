package com.shiyanlou.spring.aop.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutsDefinition {

    @Pointcut("execution(* com.shiyanlou.spring.aop.aspectj.CustomerBo.*(..))")
    public void customerLog() {
    }
}