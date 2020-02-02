package com.sand.thymeleafemployeeservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.sand.thymeleafemployeeservice.dao.EmployeeRepository;
import com.sand.thymeleafemployeeservice.entity.Employee;
import com.sand.thymeleafemployeeservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
  private EmployeeRepository employeeRepository;
  
  @Autowired
  public EmployeeServiceImpl(EmployeeRepository employeeRepository)
  {
    this.employeeRepository = employeeRepository;
  }
  
  @Override
  public List<Employee> findAll()
  {
    return employeeRepository.findAll();
  }
  
  @Override
  public List<Employee> findAllOrderByFirstName()
  {
    return employeeRepository.findAllByOrderByFirstNameAsc();
  }
  
  @Override
  public Employee findById(int id)
  {
    Optional<Employee> result = employeeRepository.findById(id);
    return result.orElseThrow(() -> new RuntimeException("Employee id not found - " + id));
  }
  
  @Override
  public void save(Employee employee)
  {
    employeeRepository.save(employee);
  }
  
  @Override
  public void delete(int id)
  {
    employeeRepository.deleteById(id);
  }
}
