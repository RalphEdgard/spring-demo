package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* org.example.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Log: calling method -> " + joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* org.example.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("log: finished method -> " + joinPoint.getSignature().getName());
    }
}
