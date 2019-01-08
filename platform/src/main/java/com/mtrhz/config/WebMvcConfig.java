package com.mtrhz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author Solrsky
 * @date 2019/1/8
 */
@Configuration
@ComponentScan(basePackages = "com.mtrhz")
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    public ViewResolver mvcViewResolver() {
        InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
        resourceViewResolver.setPrefix("/WEB-INF/views");
        resourceViewResolver.setSuffix(".jsp");
        return resourceViewResolver;
    }

}
