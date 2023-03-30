package org.bobpark.restlogging.configure;


import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.Ordered;

import org.bobpark.restlogging.configure.condition.RestLoggingCondition;
import org.bobpark.restlogging.configure.properties.RestLoggingProperties;
import org.bobpark.restlogging.filter.RestLoggingFilter;

@AutoConfiguration
@Conditional(RestLoggingCondition.class)
@EnableConfigurationProperties(RestLoggingProperties.class)
public class RestLoggingAutoConfiguration {

    @Bean
    public FilterRegistrationBean<RestLoggingFilter> filter() {
        FilterRegistrationBean<RestLoggingFilter> filter = new FilterRegistrationBean<>();

        filter.addUrlPatterns("*");
        filter.setFilter(new RestLoggingFilter());
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return filter;
    }

}
