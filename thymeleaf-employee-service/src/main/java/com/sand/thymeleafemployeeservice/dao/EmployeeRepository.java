package com.sand.thymeleafemployeeservice.dao;

import java.util.List;

import com.sand.thymeleafemployeeservice.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
  public List<Employee> findAllByOrderByFirstNameAsc();
}
