package com.kgisl.springjson;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import com.kgisl.springjson.dao.ContactDAO;
import com.kgisl.springjson.dao.ContactDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.kgisl")
public class MvcWebConfig implements WebMvcConfigurer {

   @Override
   public void configureViewResolvers(ViewResolverRegistry registry) {
      registry.jsp("/WEB-INF/views/", ".jsp");
   }

   /**
    * Static Resource (CSS or JS) mapping
    */
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {

      // Register resource handler for CSS and JS
      registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/", "D:/statics/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());

      // Register resource handler for images

      registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
   }

   @Bean
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
       dataSource.setUsername("root");
       dataSource.setPassword("");

       return dataSource;
   }

   @Bean
   public ContactDAO getContactDAO() {
       return new ContactDAOImpl(getDataSource());
   }
}
