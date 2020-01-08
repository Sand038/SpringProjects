package com.sand.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect
{
  @Before("com.sand.aspect.PointCutExpressions.forDAOPackageWithoutGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint)
  {
    System.out.println("=====>>>>> Executing @Before advice on addAccount()");
    
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    System.out.println("Method: " + methodSignature);
    
    Object[] args = joinPoint.getArgs();
    for (Object arg : args)
    {
      System.out.println(arg);
    }
  }
  
  ////  @Before("execution(public * add*())")
  //  @Before("execution(public * com.sand.dao.*.*(..))")
  //  public void beforeAddAccountAdvice() {
  //    System.out.println("\n=====>>>>> Executing @Before advice on addAccount()");
  //  }
}
