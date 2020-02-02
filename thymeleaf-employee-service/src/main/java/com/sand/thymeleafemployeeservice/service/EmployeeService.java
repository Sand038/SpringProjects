package com.sand.thymeleafemployeeservice.service;

import java.util.List;

import com.sand.thymeleafemployeeservice.entity.Employee;

public interface EmployeeService
{
  public List<Employee> findAll();
  
  public List<Employee> findAllOrderByFirstName();
  
  public Employee findById(int id);
  
  public void save(Employee employee);
  
  public void delete(int id);
}
