package com.sand.controller;

import com.sand.entity.Customer;
import com.sand.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  
  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model)
  {
    model.addAttribute("customer", new Customer());
    return "customer-form";
  }
  
  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer)
  {
    customerService.saveCustomer(customer);
    return "redirect:/customer/list";
  }
  
  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("customerId") int id, Model model)
  {
    Customer customer = customerService.getCustomer(id);
    model.addAttribute(customer);
    return "customer-form";
  }
  
  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int id)
  {
    customerService.deleteCustomer(id);
    return "redirect:/customer/list";
  }
}
