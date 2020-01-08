package com.sand.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutExpressions
{
  @Pointcut("execution(* com.sand.dao.*.*(..))")
  public void forDAOPackage()
  {
  }
  
  @Pointcut("execution(* com.sand.dao.*.get*(..))")
  public void getter()
  {
  }
  
  @Pointcut("execution(* com.sand.dao.*.set*(..))")
  public void setter()
  {
  }
  
  @Pointcut("forDAOPackage() && !(getter() || setter())")
  public void forDAOPackageWithoutGetterSetter()
  {
  }
}
