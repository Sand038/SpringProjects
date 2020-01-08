package com.sand.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO
{
  public boolean addMemberAccount(String name) {
    System.out.println(getClass() + ": Adding a MEMBERSHIP ACCOUNT");
    return true;
  }
}
