package com.yibo.springbootwebdemo;

import com.yibo.springbootwebdemo.servlet.MyServletRequestListener;
import com.yibo.springbootwebdemo.spring.boot.MySpringFilter;
import com.yibo.springbootwebdemo.spring.boot.MySpringServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.yibo.springbootwebdemo.servlet"})
public class SpringBootWebDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootWebDemoApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean registrationBean(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(new MySpringServlet());
		servletRegistrationBean.setName("springboot-myServlet");
		servletRegistrationBean.addUrlMappings("/spring-boot/myServlet");
		servletRegistrationBean.addInitParameter("name","yibo");
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new MySpringFilter());
		filterRegistrationBean.addServletNames("springboot-myServlet");
		filterRegistrationBean.addUrlPatterns("/spring-boot/myServlet");
		filterRegistrationBean.setDispatcherTypes(DispatcherType.ASYNC,DispatcherType.FORWARD,DispatcherType.REQUEST);
		return filterRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
		servletListenerRegistrationBean.setListener(new MyServletRequestListener());
		return servletListenerRegistrationBean;
	}

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.sources(SpringBootWebDemoApplication.class);
		return builder;
	}
}

