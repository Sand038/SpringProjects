package com.sand.service.impl;

import com.sand.service.FortuneService;

import org.springframework.stereotype.Component;

@Component
public class WeirdFortuneService implements FortuneService
{
  @Override
  public String getFortune()
  {
    return "Today is a weird day!";
  }
}
