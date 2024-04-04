package com.example.config;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class LoveCalculatorApplicationInitializer// implements WebApplicationInitializer {
{

  // @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
    webApplicationContext.register(AppConfig.class);
    DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("coladispatcher", dispatcherServlet);

    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/mywebapp.com/*");

  }

  public void onStartupWithXmlWebApplicationContext() {
    XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
    xmlWebApplicationContext.setConfigLocation("classpath:app-config.xml");

  }
}
