package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

public class HockeyCoach implements Coach
{
  private FortuneService fortuneService;

  public HockeyCoach(FortuneService fortuneService)
  {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout()
  {
    return "Hockey coach: Run for 30 minutes";
  }

  @Override
  public String getDailyFortune()
  {
    return fortuneService.getFortune();
  }
}
