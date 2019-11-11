package com.sand;

import com.sand.objects.impl.HockeyCoach;
import com.sand.objects.impl.SwimCoach;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WithConfigClass
{
  public static void main(String[] args)
  {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
    HockeyCoach hockeyCoach = context.getBean("hockeyCoach", HockeyCoach.class);

    System.out.println(swimCoach.getDailyWorkout());
    System.out.println(swimCoach.getDailyFortune());

    System.out.println(swimCoach.getEmail());
    System.out.println(swimCoach.getTeam());

    System.out.println(hockeyCoach.getDailyWorkout());
    System.out.println(hockeyCoach.getDailyFortune());

    context.close();
  }
}
