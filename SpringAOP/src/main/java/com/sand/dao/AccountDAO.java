package com.sand.dao;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import com.sand.Account;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO
{
  private static Logger logger = Logger.getLogger(AccountDAO.class.getName());
  
  private String name;
  
  private String serviceCode;
  
  public void addAccount()
  {
    logger.info(getClass() + ": Adding an ACCOUNT");
  }
  
  public List<Account> findAccounts()
  {
    List<Account> accounts = Arrays
        .asList(new Account("Sand", "Fernando"), new Account("Dean", "Jones"), new Account("Andy", "Flower"));
    logger.info(accounts.toString());
    return accounts;
  }
  
  public List<Account> findAccountsWithEx()
  {
    logger.info("Throwing an Exception example");
    throw new RuntimeException();
  }
  
  public String getName()
  {
    logger.info(getClass() + ": in getName");
    return name;
  }
  
  public void setName(String name)
  {
    logger.info(getClass() + ": in setName");
    this.name = name;
  }
  
  public String getServiceCode()
  {
    logger.info(getClass() + ": in getServiceCode");
    return serviceCode;
  }
  
  public void setServiceCode(String serviceCode)
  {
    logger.info(getClass() + ": in setServiceCode");
    this.serviceCode = serviceCode;
  }
}
