package com.sand.config;

import java.util.Objects;
import java.util.logging.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sand")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig
{
  @Autowired
  private Environment environment;
  
  private Logger logger = Logger.getLogger(getClass().getName());
  
  @Bean
  public ViewResolver viewResolver()
  {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");
    
    return viewResolver;
  }
  
  @Bean
  public DataSource dataSource()
  {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    try
    {
      dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
    }
    catch (PropertyVetoException e)
    {
      throw new RuntimeException(e);
    }
    logger.info(">>>>> jdbc.url=" + environment.getProperty("jdbc.url"));
    logger.info(">>>>> jdbc.user=" + environment.getProperty("jdbc.user"));
    
    dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
    dataSource.setUser(environment.getProperty("jdbc.user"));
    dataSource.setPassword(environment.getProperty("jdbc.password"));
    
    dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
    
    return dataSource;
  }
  
  private int getIntProperty(String propertyName)
  {
    return Integer.parseInt(Objects.requireNonNull(environment.getProperty(propertyName)));
  }
}
