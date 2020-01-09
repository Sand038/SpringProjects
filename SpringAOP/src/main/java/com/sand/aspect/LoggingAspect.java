package com.sand.aspect;

import java.util.List;
import java.util.logging.Logger;

import com.sand.Account;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
  private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());
  
  @Before("com.sand.aspect.PointCutExpressions.forDAOPackageWithoutGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint joinPoint)
  {
    logger.info("=====>>>>> Executing @Before advice on " + joinPoint.getSignature().toShortString());
    
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    logger.info("Method: " + methodSignature);
    
    Object[] args = joinPoint.getArgs();
    for (Object arg : args)
    {
      logger.info(arg.toString());
    }
  }
  
  @AfterReturning(pointcut = "execution(* com.sand.dao.AccountDAO.findAccounts(..))", returning = "result")
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result)
  {
    String method = joinPoint.getSignature().toString();
    logger.info("=====>>>>> Executing @AfterReturning on method: " + method);
    result.forEach(e -> e.setName(e.getName().toUpperCase()));
  }
  
  @AfterThrowing(pointcut = "execution(* com.sand.dao.AccountDAO.findAccounts*())", throwing = "exception")
  public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception)
  {
    String method = joinPoint.getSignature().toString();
    logger.info("=====>>>>> Executing @AfterThrowing on method: " + method);
    logger.info("=====>>>>> Exception is: " + exception);
  }
  
  @After("execution(* com.sand.dao.AccountDAO.findAccounts*())")
  public void afterFinallyFindAccountAdvice(JoinPoint joinPoint)
  {
    String method = joinPoint.getSignature().toString();
    logger.info("=====>>>>> Executing @After (finally) on method: " + method);
  }
  
  @Around("execution(* com.sand.service.*.getFortune*(..))")
  public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
  {
    String method = proceedingJoinPoint.getSignature().toString();
    logger.info("=====>>>>> Executing @Around on method: " + method);
    
    long start = System.currentTimeMillis();
    Object result;
    try
    {
      result = proceedingJoinPoint.proceed();
    }
    catch (Exception e)
    {
      // Instead of handling the exception here. We can log the exception and rethrow it (So the exception is logged and also the main app is aware of it)
      logger.warning(e.getMessage());
      result = "BOOM!, there was a exception while executing method";
    }
    long end = System.currentTimeMillis();
    
    logger.info("=====>>>>> Duration: " + (end - start) / 1000 + " seconds");
    
    return result;
  }
  
  ////  @Before("execution(public * add*())")
  //  @Before("execution(public * com.sand.dao.*.*(..))")
  //  public void beforeAddAccountAdvice() {
  //    logger.info("=====>>>>> Executing @Before advice on addAccount()");
  //  }
}
