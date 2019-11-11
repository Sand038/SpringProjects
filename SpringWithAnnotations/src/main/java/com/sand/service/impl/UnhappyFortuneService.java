package com.sand.service.impl;

import com.sand.service.FortuneService;

import org.springframework.stereotype.Component;

@Component
public class UnhappyFortuneService implements FortuneService
{
  @Override
  public String getFortune()
  {
    return "Today is NOT your lucky day!";
  }
}
