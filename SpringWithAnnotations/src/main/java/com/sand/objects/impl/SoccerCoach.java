package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach
{
  private FortuneService fortuneService;

  public SoccerCoach()
  {
  }

  //This doesn't have to be setter method always. It can be a any method that has autowired annotation
  @Autowired
  @Qualifier("unhappyFortuneService")
  public void setFortuneService(FortuneService fortuneService)
  {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout()
  {
    return "Soccer coach: run for 30 minutes";
  }

  @Override
  public String getDailyFortune()
  {
    return fortuneService.getFortune();
  }
}
