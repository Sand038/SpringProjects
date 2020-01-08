package com.sand.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO
{
  
  private String name;
  
  private String serviceCode;
  
  public void addAccount()
  {
    System.out.println(getClass() + ": Adding an ACCOUNT");
  }
  
  public String getName()
  {
    System.out.println(getClass() + ": in getName");
    return name;
  }
  
  public void setName(String name)
  {
    System.out.println(getClass() + ": in setName");
    this.name = name;
  }
  
  public String getServiceCode()
  {
    System.out.println(getClass() + ": in getServiceCode");
    return serviceCode;
  }
  
  public void setServiceCode(String serviceCode)
  {
    System.out.println(getClass() + ": in setServiceCode");
    this.serviceCode = serviceCode;
  }
}
