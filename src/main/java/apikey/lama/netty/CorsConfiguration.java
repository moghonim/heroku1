package apikey.lama.netty;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.cors.reactive.CorsUtils;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;


@Configuration
@EnableWebFlux
public class CorsConfiguration implements WebFluxConfigurer {

    private static final Logger log = LogManager.getLogger(CorsConfiguration.class);

    private static final String ALLOWED_HEADERS = "x-requested-with, authorization, Content-Type, Authorization, credential, X-XSRF-TOKEN, mode";
    private static final String ALLOWED_METHODS = "GET, PUT, POST, DELETE, OPTIONS";
    private static final String ALLOWED_ORIGIN = "*";
    private static final String MAX_AGE = "3600";

    @Bean
    public WebFilter corsFilter() {
        log.warn("from CorsConfiguration!!!");
        return (ServerWebExchange ctx, WebFilterChain chain) -> {
            ServerHttpRequest request = ctx.getRequest();
            log.warn("after ServerHttpRequest");

            if (CorsUtils.isCorsRequest(request)) {
                log.warn("inside isCorsRequest");
                ServerHttpResponse response = ctx.getResponse();

                HttpHeaders headers = response.getHeaders();
                headers.add("Access-Control-Allow-Origin", ALLOWED_ORIGIN);
                headers.add("Access-Control-Allow-Methods", ALLOWED_METHODS);
                    headers.add("Access-Control-Max-Age", MAX_AGE);
                    headers.add("Access-Control-Allow-Headers", ALLOWED_HEADERS);
    //                if (request.getMethod() == HttpMethod.OPTIONS) {
    //                    response.setStatusCode(HttpStatus.OK);
    //                    return Mono.empty();
    //                }
                }
                return chain.filter(ctx);
            };
        }



        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/test/{param}")
                    .allowedOrigins("*")
                .allowedMethods("POST", "OPTIONS");
    }
}
