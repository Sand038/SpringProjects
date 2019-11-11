package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach
{
  @Autowired
  @Qualifier("weirdFortuneService")
  private FortuneService fortuneService;

  public TennisCoach()
  {
  }

  @PostConstruct
  public void init() {
    System.out.println("Tennis coach: Init method");
  }

  @PreDestroy
  public void destroy() {
    System.out.println("Tennis coach: Destroy method");
  }

  @Override
  public String getDailyWorkout()
  {
    return "Tennis coach: Practice backhand for 30 minutes";
  }

  @Override
  public String getDailyFortune()
  {
    return fortuneService.getFortune();
  }
}
