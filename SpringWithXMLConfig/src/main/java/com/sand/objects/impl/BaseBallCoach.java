package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

public class BaseBallCoach implements Coach
{
  private FortuneService fortuneService;

  public BaseBallCoach(FortuneService fortuneService)
  {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout()
  {
    return "Base ball coach: Spend 30 minutes on batting practice";
  }

  @Override
  public String getDailyFortune()
  {
    return "Base ball coach: " + fortuneService.getFortune();
  }
}
