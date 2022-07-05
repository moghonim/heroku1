package apikey.lama.securityapikey;


import apikey.lama.models.Auth;
import apikey.lama.repository.AuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class KeyAuthenticationConverter implements ServerAuthenticationConverter {
    private static final Logger LOG = LoggerFactory.getLogger(KeyAuthenticationConverter.class);
    private static final String API_KEY_HEADER_NAME = "API_KEY";
    @Autowired
    AuthRepository authRepository;


    public KeyAuthenticationConverter() {

    }

    @Override
    public Mono<Authentication> convert(ServerWebExchange exchange) {
        return Mono.justOrEmpty(exchange)
                .flatMap(serverWebExchange -> Mono.justOrEmpty(serverWebExchange.getRequest().getHeaders().get(API_KEY_HEADER_NAME)))
                .filter(headerValues -> !headerValues.isEmpty())
                .flatMap(headerValues -> lookup(headerValues.get(0)));
    }

    /**
     * Lookup authentication token in cache.
     *
     * @param apiKey api key
     * @return
     */
    private Mono<KeyAuthenticationToken> lookup(final String apiKey) {
//        return Mono.fromFuture(tokenCache.get(apiKey));
        return authRepository.findById(apiKey).map(auth -> {
            Auth auth1=new Auth();
            auth1.setApi_key(auth.getApi_key());
            auth1.setUser_id(auth.getUser_id());
            auth1.setAuthorities(auth.getAuthorities());
            KeyAuthenticationToken keyAuthenticationToken=
                    new KeyAuthenticationToken(auth1.getApi_key(),auth1.getEmail(),auth1.getAuthorities());
            return keyAuthenticationToken;
        });
    }
    }

