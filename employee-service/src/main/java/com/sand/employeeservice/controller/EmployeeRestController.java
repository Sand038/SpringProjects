package com.sand.employeeservice.controller;

import java.util.List;

import com.sand.employeeservice.entity.Employee;
import com.sand.employeeservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController
{
  private EmployeeService employeeService;
  
  @Autowired
  public EmployeeRestController(EmployeeService employeeService)
  {
    this.employeeService = employeeService;
  }
  
  @GetMapping("/employees")
  public List<Employee> findAll()
  {
    return employeeService.findAll();
  }
  
  @GetMapping("/employees/{id}")
  public Employee findEmployee(@PathVariable int id)
  {
    Employee employee = employeeService.findById(id);
    if (employee == null)
    {
      throw new RuntimeException("Employee not found - " + id);
    }
    return employee;
  }
  
  @PostMapping("/employees")
  public Employee addEmployee(@RequestBody Employee employee)
  {
    employee.setId(0);
    employeeService.save(employee);
    return employee;
  }
  
  @PutMapping("/employees")
  public Employee updateEmployee(@RequestBody Employee employee)
  {
    employeeService.save(employee);
    return employee;
  }
  
  @DeleteMapping("/employees/{id}")
  public String deleteEmployee(@PathVariable int id)
  {
    Employee employee = employeeService.findById(id);
    if (employee == null)
    {
      throw new RuntimeException("Employee not found - " + id);
    }
    employeeService.delete(id);
    return "Deleted employee id - " + id;
  }
}
