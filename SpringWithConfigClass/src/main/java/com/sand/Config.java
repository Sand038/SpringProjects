package com.sand;

import com.sand.objects.Coach;
import com.sand.objects.impl.HockeyCoach;
import com.sand.objects.impl.SwimCoach;
import com.sand.service.FortuneService;
import com.sand.service.impl.HappyFortuneService;
import com.sand.service.impl.UnhappyFortuneService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.sand")
@PropertySource("classpath:coach.properties")
public class Config
{
  @Bean
  public FortuneService happyFortuneService()
  {
    return new HappyFortuneService();
  }

  @Bean
  public FortuneService unhappyFortuneService()
  {
    return new UnhappyFortuneService();
  }

  @Bean
  public Coach swimCoach()
  {
    return new SwimCoach(happyFortuneService());
  }

  @Bean
  public Coach hockeyCoach()
  {
    return new HockeyCoach(unhappyFortuneService());
  }
}
