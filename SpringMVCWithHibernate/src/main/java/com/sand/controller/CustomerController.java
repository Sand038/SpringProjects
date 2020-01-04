package com.sand.controller;

import com.sand.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
  @Autowired
  private CustomerService customerService;
  
  @GetMapping("/list")
  public String listCustomers(Model model)
  {
    model.addAttribute("customers", customerService.getCustomers());
    return "list-customers";
  }
}
