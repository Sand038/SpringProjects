package com.sand.dao.impl;

import java.util.List;

import com.sand.dao.CustomerDAO;
import com.sand.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{
  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  @Transactional
  public List<Customer> getCustomers()
  {
    Session currentSession = sessionFactory.getCurrentSession();
    Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
    return query.getResultList();
  }
}
