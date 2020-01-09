package com.sand.dao;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO
{
  private static Logger logger = Logger.getLogger(MembershipDAO.class.getName());
  
  public boolean addMemberAccount(String name)
  {
    logger.info(getClass() + ": Adding a MEMBERSHIP ACCOUNT");
    return true;
  }
}
