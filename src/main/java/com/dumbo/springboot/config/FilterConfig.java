package com.dumbo.springboot.config;

import com.dumbo.springboot.Filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean MyFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        MyFilter myFilter = new MyFilter();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.addUrlPatterns("/test/*");
        filterRegistrationBean.setName("MyFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

//    @Bean
//    public FilterRegistrationBean SecondFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//
//    }
}
