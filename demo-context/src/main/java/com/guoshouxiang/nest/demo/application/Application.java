package com.guoshouxiang.nest.demo.application;


import com.guoshouxiang.nest.demo.api.v1.ApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(scanBasePackages = {
        "com.guoshouxiang.nest.demo.tasks",
        "com.guoshouxiang.nest.demo.appservice",
        "com.guoshouxiang.nest.demo.infrastructure"
})
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public ServletRegistrationBean V1Registration() {

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.scan("com.guoshouxiang.nest.demo.api.v1");

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
        applicationContext.scan("com.guoshouxiang.nest.demo.api.v2");

        DispatcherServlet dispatcherServlet
                = new DispatcherServlet(applicationContext);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/api/v2/*");
        registrationBean.setName("api_v2");

        return registrationBean;
    }

}
