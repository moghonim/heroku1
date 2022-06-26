package com.stackdeans.loginregister.config;

import com.stackdeans.loginregister.interceptors.LanguageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


/**
 * @author Ahmed Ghonim
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LanguageInterceptor languageInterceptor;

    @Bean
    public LocaleResolver localeResolver() {
//       SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
//       sessionLocaleResolver.setDefaultLocale(Locale.US);
//       return sessionLocaleResolver;
        return new CookieLocaleResolver();
    }

    /**
     * LocaleChangeInterceptor
     * LocaleChangeInterceptor is a used to change the new Locale
     * based on the value of the language parameter added to a request.
     **/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(languageInterceptor);
        registry.addInterceptor(localeChangeInterceptor());
    }


}
