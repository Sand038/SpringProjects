package com.sand.objects.impl;

import com.sand.objects.Coach;
import com.sand.service.FortuneService;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach
{
  private FortuneService fortuneService;

  @Value("${coach.email}")
  private String email;

  @Value("${coach.team}")
  private String team;

  public SwimCoach(FortuneService fortuneService)
  {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout()
  {
    return "Swim coach: Swim for 30 minutes";
  }

  @Override
  public String getDailyFortune()
  {
    return fortuneService.getFortune();
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getTeam()
  {
    return team;
  }

  public void setTeam(String team)
  {
    this.team = team;
  }
}
