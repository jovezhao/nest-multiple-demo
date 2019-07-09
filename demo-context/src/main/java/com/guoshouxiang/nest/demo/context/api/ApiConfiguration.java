package com.guoshouxiang.nest.demo.context.api;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ApiConfiguration {
    @Bean
    public ServletRegistrationBean V1Registration() {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(com.guoshouxiang.nest.demo.api.v1.ApiConfiguration.class);

        DispatcherServlet dispatcherServlet
                = new DispatcherServlet(applicationContext);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/api/v1/*");
        registrationBean.setName("api_v1");

        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean V2Registration() {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(com.guoshouxiang.nest.demo.api.v2.ApiConfiguration.class);

        DispatcherServlet dispatcherServlet
                = new DispatcherServlet(applicationContext);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/api/v2/*");
        registrationBean.setName("api_v2");

        return registrationBean;
    }
}
