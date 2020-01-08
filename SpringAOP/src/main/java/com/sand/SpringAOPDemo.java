package com.sand;

import com.sand.config.Config;
import com.sand.dao.AccountDAO;
import com.sand.dao.MembershipDAO;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAOPDemo
{
  public static void main(String[] args)
  {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    accountDAO.addAccount();
    accountDAO.setName("Name");
    accountDAO.setServiceCode("Service Code");
    accountDAO.getName();
    accountDAO.getServiceCode();
  
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
    membershipDAO.addMemberAccount("Sand");
  
    context.close();
  }
}
