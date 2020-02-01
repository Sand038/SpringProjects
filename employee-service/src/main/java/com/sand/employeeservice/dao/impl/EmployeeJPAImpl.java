package com.sand.employeeservice.dao.impl;

import java.util.List;

import com.sand.employeeservice.dao.EmployeeDAO;
import com.sand.employeeservice.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class EmployeeJPAImpl implements EmployeeDAO
{
  private EntityManager entityManager;
  
  @Autowired
  public EmployeeJPAImpl(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }
  
  @Override
  public List<Employee> findAll()
  {
    TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }
  
  @Override
  public Employee findById(int id)
  {
    return entityManager.find(Employee.class, id);
  }
  
  @Override
  public void save(Employee employee)
  {
    Employee updatedEmployee = entityManager.merge(employee);
    employee.setId(updatedEmployee.getId());
  }
  
  @Override
  public void delete(int id)
  {
    Query query = entityManager.createQuery("delete from Employee where id=:employeeId ");
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }
}
