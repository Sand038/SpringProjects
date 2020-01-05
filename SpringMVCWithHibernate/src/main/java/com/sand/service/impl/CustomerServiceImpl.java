package com.sand.service.impl;

import java.util.List;

import com.sand.dao.CustomerDAO;
import com.sand.entity.Customer;
import com.sand.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService
{
  @Autowired
  private CustomerDAO customerDAO;
  
  @Override
  @Transactional
  public List<Customer> getCustomers()
  {
    return customerDAO.getCustomers();
  }
  
  @Override
  @Transactional
  public void saveCustomer(Customer customer)
  {
    customerDAO.saveCustomer(customer);
  }
  
  @Override
  @Transactional
  public Customer getCustomer(int id)
  {
    return customerDAO.getCustomer(id);
  }
  
  @Override
  @Transactional
  public void deleteCustomer(int id)
  {
    customerDAO.deleteCustomer(id);
  }
}
