package com.sand.employeeservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.sand.employeeservice.dao.EmployeeRepository;
import com.sand.employeeservice.entity.Employee;
import com.sand.employeeservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringDataEmployeeServiceImpl implements EmployeeService
{
  private EmployeeRepository employeeRepository;
  
  @Autowired
  public SpringDataEmployeeServiceImpl(EmployeeRepository employeeRepository)
  {
    this.employeeRepository = employeeRepository;
  }
  
  @Override
  public List<Employee> findAll()
  {
    return employeeRepository.findAll();
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
