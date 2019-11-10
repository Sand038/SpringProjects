package com.sand.service.impl;

import com.sand.service.FortuneService;

public class HappyFortuneService implements FortuneService
{
  @Override
  public String getFortune()
  {
    return "Today is your lucky day!";
  }
}
