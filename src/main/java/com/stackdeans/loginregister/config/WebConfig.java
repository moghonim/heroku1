package com.stackdeans.loginregister.config;

import org.hibernate.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private Interceptor inetrceptor;

    @Bean
    public LocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor(){
//        LocaleChangeInterceptor localeChangeInterceptor =new LocaleChangeInterceptor();
//        LocaleChangeInterceptor.DEFAULT_PARAM_NAME("language");
//        return localeChangeInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor);
//        registry.addInterceptor(localeChangeInterceptor());
//    }
}
