package com.sand.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService
{
  public String getFortune()
  {
    try
    {
      TimeUnit.SECONDS.sleep(2);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return "Expect heavy traffic this morning";
  }
  
  public String getFortuneWithEx()
  {
    throw new RuntimeException("BOOM!");
  }
}
