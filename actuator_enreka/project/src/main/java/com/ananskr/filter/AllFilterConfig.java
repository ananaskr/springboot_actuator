package com.ananskr.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllFilterConfig {
    @Autowired
    private AllFilter allFilter;


    @Bean
    public FilterRegistrationBean registerallFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(allFilter);
        registration.addUrlPatterns("/*");
        registration.setName("allFilter");
        return registration;
    }
}
