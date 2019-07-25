package com.kgisl.springjson;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
   public void onStartup(ServletContext servletContext) throws ServletException 
   {
     AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
     context.scan("com.kgisl");
     servletContext.addListener(new ContextLoaderListener(context));
 
     ServletRegistration.Dynamic dispatcher = servletContext.addServlet("mvc", new DispatcherServlet(context));
     dispatcher.setLoadOnStartup(1);
     dispatcher.addMapping("/");
   }
   
   @Override
   protected Class<?>[] getRootConfigClasses() {
      return null;
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { MvcWebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }

}
