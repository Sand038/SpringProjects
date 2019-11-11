package com.sand.service.impl;

import com.sand.service.FortuneService;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService
{
  @Override
  public String getFortune()
  {
    return "Today is your lucky day!";
  }
}
