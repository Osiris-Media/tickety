package com.osiris.tickety.infra.interceptors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created By francislagueu on 7/3/24
 */
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    @Value("${miscellaneous.max-response-time-to-log-in-ms}")
    private final int maxResponseTimeToLogInMs;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new TimeExecutionInterceptor()).addPathPatterns("/**");
        registry
                .addInterceptor(new LogSlowResponseTimeInterceptor(this.maxResponseTimeToLogInMs))
                .addPathPatterns("/**");
    }
}
