package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Song Weiwei
 * @date 2019-12-01
 * AOP示例 定义方面组件Aspect（pointCut + Advice）
 */

//@Component
//@Aspect
public class AlphaAspect {

    // 定义切点pointCut
    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointCut() {

    }

    // 定义通知Advice
    // 连接点（调用业务组件）之前处理逻辑
    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

    // 连接点（调用业务组件）之后处理逻辑
    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }

    // 返回值之后处理逻辑
    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    // 抛异常时处理逻辑
    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    // 调目标组件前后都处理逻辑
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        Object obj = joinPoint.proceed();
        System.out.println("around after");
        return obj;
    }

}
