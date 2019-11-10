package com.sand;

import com.sand.objects.Coach;
import com.sand.objects.impl.CricketCoach;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WithXMLConfig
{
  public static void main(String[] args)
  {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    Coach coach = context.getBean("myCoach", Coach.class);
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());

    CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);
    System.out.println(cricketCoach.getDailyWorkout());
    System.out.println(cricketCoach.getDailyFortune());
    System.out.println(cricketCoach.getEmailAddress());
    System.out.println(cricketCoach.getTeam());

    context.close();
  }
}
