package com.sand.thymeleafemployeeservice.controller;

import java.util.List;

import com.sand.thymeleafemployeeservice.entity.Employee;
import com.sand.thymeleafemployeeservice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController
{
  private EmployeeService employeeService;
  
  @Autowired
  public EmployeeController(EmployeeService employeeService)
  {
    this.employeeService = employeeService;
  }
  
  @GetMapping("/list")
  public String listEmployees(Model model)
  {
    List<Employee> employees = employeeService.findAllOrderByFirstName();
    model.addAttribute("employees", employees);
    return "list-employees";
  }
  
  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model)
  {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "employee-form";
  }
  
  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute("employee") Employee employee)
  {
    employeeService.save(employee);
    return "redirect:/employees/list";
  }
}
