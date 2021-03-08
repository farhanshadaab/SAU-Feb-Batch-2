package com.au.spring;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@Aspect
@EnableAspectJAutoProxy

public class aop {
	@Before("pointBreak()")
    public static void beforeAnnotation() {
        System.out.println("Before calling the method");
    }
	
	@After("pointBreak()")
    public static void afterAnnotation() {
        System.out.println("after calling the method");
    }
	
	@Pointcut("execution (public void getName())")
    public void pointBreak() {
    	System.out.println("Pointbreak executed");
    }
	
	@AfterReturning(pointcut = "execution(int getId())", returning = "id")
    public void afterreturningannotation(int id) {
        System.out.println("After returning annotation. Returned id number = " + id);
    }

}
