package com.sand.config;

import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.sand")
@PropertySource({ "classpath:persistence-mysql.properties" })
public class AppConfig implements WebMvcConfigurer
{
  @Autowired
  private Environment environment;
  
  private Logger logger = Logger.getLogger(getClass().getName());
  
  @Bean
  public DataSource dataSource()
  {
    // create connection pool
    ComboPooledDataSource myDataSource = new ComboPooledDataSource();
    
    // set the jdbc driver
    try
    {
      myDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
    }
    catch (PropertyVetoException exc)
    {
      throw new RuntimeException(exc);
    }
    
    // for sanity's sake, let's log url and user ... just to make sure we are reading the data
    logger.info("jdbc.url=" + environment.getProperty("jdbc.url"));
    logger.info("jdbc.user=" + environment.getProperty("jdbc.user"));
    
    // set database connection props
    myDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
    myDataSource.setUser(environment.getProperty("jdbc.user"));
    myDataSource.setPassword(environment.getProperty("jdbc.password"));
    
    // set connection pool props
    myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
    
    return myDataSource;
  }
  
  private Properties getHibernateProperties()
  {
    // set hibernate properties
    Properties props = new Properties();
    props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
    return props;
  }
  
  // need a helper method 
  // read environment property and convert to int
  
  private int getIntProperty(String propName)
  {
    return Integer.parseInt(Objects.requireNonNull(environment.getProperty(propName)));
  }
  
  @Bean
  public LocalSessionFactoryBean sessionFactory()
  {
    // create session factories
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    
    // set the properties
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
    sessionFactory.setHibernateProperties(getHibernateProperties());
    
    return sessionFactory;
  }
  
  @Bean
  @Autowired
  public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
  {
    // setup transaction manager based on session factory
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory);
    return transactionManager;
  }
  
}









