package com.sand;

import com.sand.objects.Coach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WithAnnotations
{
  public static void main(String[] args)
  {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Coach badmintonCoach = context.getBean("badmintonCoach", Coach.class);
    Coach soccerCoach = context.getBean("soccerCoach", Coach.class);
    Coach tennisCoach = context.getBean("tennisCoach", Coach.class);

    System.out.println(badmintonCoach.getDailyWorkout());
    System.out.println(badmintonCoach.getDailyFortune());

    System.out.println(soccerCoach.getDailyWorkout());
    System.out.println(soccerCoach.getDailyFortune());

    System.out.println(tennisCoach.getDailyWorkout());
    System.out.println(tennisCoach.getDailyFortune());

    context.close();
  }
}
