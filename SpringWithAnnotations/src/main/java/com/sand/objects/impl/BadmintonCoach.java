package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach
{
  private FortuneService fortuneService;

  @Autowired
  public BadmintonCoach(@Qualifier("happyFortuneService") FortuneService fortuneService)
  {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout()
  {
    return "Badminton coach: Practice drop for 30 minutes";
  }

  @Override
  public String getDailyFortune()
  {
    return fortuneService.getFortune();
  }
}
