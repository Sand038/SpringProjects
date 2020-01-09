package com.sand.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAsyncAspect
{
  private static Logger logger = Logger.getLogger(CloudLogAsyncAspect.class.getName());
  
  @Before("com.sand.aspect.PointCutExpressions.forDAOPackageWithoutGetterSetter()")
  public void logToCloudAsync()
  {
    logger.info("=====>>>>> Logging to cloud in async fashion");
  }
}
