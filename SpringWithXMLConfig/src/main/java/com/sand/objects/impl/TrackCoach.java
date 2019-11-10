package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

public class TrackCoach implements Coach
{
  private FortuneService fortuneService;

  public TrackCoach(FortuneService fortuneService)
  {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout()
  {
    return "Track coach: Run a hard 5k";
  }

  @Override
  public String getDailyFortune()
  {
    return "Track coach: " + fortuneService.getFortune();
  }

  public void init() {
    System.out.println("Track coach: Init method");
  }

  public void destroy() {
    System.out.println("Track coach: Destroy method");
  }
}
