package com.sand;

import java.util.logging.Logger;

import com.sand.config.Config;
import com.sand.dao.AccountDAO;
import com.sand.dao.MembershipDAO;
import com.sand.service.TrafficFortuneService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPDemo
{
  private static Logger logger = Logger.getLogger(SpringAOPDemo.class.getName());
  
  public static void main(String[] args)
  {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    
    logger.info("********************************************** @Before advice and pointcut expressions with declaration **********************************************");
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    accountDAO.addAccount();
    logger.info("=================================================================================================" + System.lineSeparator());
    
    accountDAO.setName("Name");
    accountDAO.setServiceCode("Service Code");
    accountDAO.getName();
    accountDAO.getServiceCode();
    logger.info("=================================================================================================" + System.lineSeparator());
  
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
    membershipDAO.addMemberAccount("Sand");
    logger.info("=================================================================================================" + System.lineSeparator());
    
    logger.info("********************************************** @AfterReturning and @After advices **********************************************");
    logger.info(accountDAO.findAccounts().toString());
    logger.info("=================================================================================================" + System.lineSeparator());
    
    logger.info("********************************************** @AfterThrowing and @After advice **********************************************");
    try
    {
      accountDAO.findAccountsWithEx();
    }
    catch (Exception e)
    {
      logger.info("Caught Exception: " + e);
    }
    logger.info("=================================================================================================" + System.lineSeparator());
    
    logger.info("********************************************** @Around advice **********************************************");
    TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
    logger.info(trafficFortuneService.getFortune());
    logger.info("=================================================================================================" + System.lineSeparator());
  
    logger.info("********************************************** @Around advice with Exception handling **********************************************");
    logger.info(trafficFortuneService.getFortuneWithEx());
    logger.info("=================================================================================================" + System.lineSeparator());
    
    context.close();
  }
}
