package com.sand.aspect;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect
{
  private Logger logger = Logger.getLogger(getClass().getName());
  
  @Pointcut("execution(* com.sand.controller.*.*(..))")
  private void forControllerPackage()
  {
  }
  
  @Pointcut("execution(* com.sand.service.*.*(..))")
  private void forServicePackage()
  {
  }
  
  @Pointcut("execution(* com.sand.dao.*.*(..))")
  private void forDaoPackage()
  {
  }
  
  @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
  private void forAppFlow()
  {
  }
  
  @Before("forAppFlow()")
  public void before(JoinPoint joinPoint)
  {
    String method = joinPoint.getSignature().toShortString();
    String arguments = Arrays.toString(joinPoint.getArgs());
    logger.info("=====>>>>> in @Before: Calling method: " + method + ", Arguments: " + arguments);
  }
  
  @AfterReturning(pointcut = "forAppFlow()", returning = "result")
  public void afterReturning(JoinPoint joinPoint, Object result)
  {
    String method = joinPoint.getSignature().toShortString();
    logger.info("=====>>>>> in @AfterReturning: Calling method: " + method + ", Return: " + result);
  }
}
