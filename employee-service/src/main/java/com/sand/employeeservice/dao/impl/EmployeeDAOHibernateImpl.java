package com.sand.employeeservice.dao.impl;

import java.util.List;

import com.sand.employeeservice.dao.EmployeeDAO;
import com.sand.employeeservice.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO
{
  private EntityManager entityManager;
  
  @Autowired
  public EmployeeDAOHibernateImpl(EntityManager entityManager)
  {
    this.entityManager = entityManager;
  }
  
  @Override
  public List<Employee> findAll()
  {
    Session session = entityManager.unwrap(Session.class);
    Query<Employee> query = session.createQuery("from Employee", Employee.class);
    return query.getResultList();
  }
  
  @Override
  public Employee findById(int id)
  {
    Session session = entityManager.unwrap(Session.class);
    return session.get(Employee.class, id);
  }
  
  @Override
  public void save(Employee employee)
  {
    Session session = entityManager.unwrap(Session.class);
    session.saveOrUpdate(employee);
  }
  
  @Override
  public void delete(int id)
  {
    Session session = entityManager.unwrap(Session.class);
    Query query = session.createQuery("delete from Employee where id=:employeeId ");
    query.setParameter("employeeId", id);
    query.executeUpdate();
  }
}
