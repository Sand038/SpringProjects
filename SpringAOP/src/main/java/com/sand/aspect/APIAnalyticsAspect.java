package com.sand.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class APIAnalyticsAspect
{
  private static Logger logger = Logger.getLogger(APIAnalyticsAspect.class.getName());
  
  @Before("com.sand.aspect.PointCutExpressions.forDAOPackageWithoutGetterSetter()")
  public void performAPIAnalytics()
  {
    logger.info("=====>>>>> Performing API Analytics");
  }
}
