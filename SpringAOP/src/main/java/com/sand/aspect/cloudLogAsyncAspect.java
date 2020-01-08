package com.sand.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class cloudLogAsyncAspect
{
  @Before("com.sand.aspect.PointCutExpressions.forDAOPackageWithoutGetterSetter()")
  public void logToCloudAsync()
  {
    System.out.println("\n=====>>>>> Logging to cloud in async fashion");
  }
}
