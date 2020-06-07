package com.sabancidx.webapps.inventory.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FirstAspect {
    @Before("execution(* com.sabancidx..*Service.*(..))")
    public void first(JoinPoint jp) {
        System.out.println(jp.toString() + " basladi");
    }

    @Around("execution(* com.sabancidx..*Service.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint pjp)
            throws Throwable {
        System.out.println("Around calisacak");
        Object result = pjp.proceed();
        System.out.println("Around bitti");
        return result;
    }

    @Before("within(com.sabancidx..*)")
    public void ilkAspect() {
        System.out.println("It works");
    }

}
