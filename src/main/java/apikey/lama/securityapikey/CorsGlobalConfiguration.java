package apikey.lama.securityapikey;

import io.netty.handler.codec.http.cors.CorsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

//@Configuration
//@EnableWebFlux
public class CorsGlobalConfiguration implements WebFluxConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry corsRegistry) {
//        System.out.println("hello world");
//        corsRegistry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("POST", "GET", "OPTIONS", "DELETE", "PUT")
//                .maxAge(3600);
//    }
}