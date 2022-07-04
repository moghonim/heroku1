package com.stackdeans.loginregister.securityapikey;


import com.github.benmanes.caffeine.cache.AsyncCacheLoader;
import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.stackdeans.loginregister.models.Auth;
import com.stackdeans.loginregister.repository.AuthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@Component
public class KeyAuthenticationConverter implements ServerAuthenticationConverter {
    private static final Logger LOG = LoggerFactory.getLogger(KeyAuthenticationConverter.class);
    private static final String API_KEY_HEADER_NAME = "API_KEY";


    private  AsyncLoadingCache<String, KeyAuthenticationToken> tokenCache;

    public KeyAuthenticationConverter() {
        this.tokenCache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterAccess(5, TimeUnit.MINUTES)
                .buildAsync(new DatabaseCacheLoader());
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
        return Mono.fromFuture(tokenCache.get(apiKey));
    }

    /**
     * Loads the cache authentication data from the database.
     */
    private static class DatabaseCacheLoader implements AsyncCacheLoader<String, KeyAuthenticationToken> {

//        private final DataSource dataSource;
//@Autowired
        @Autowired
        AuthRepository authRepository;
        DatabaseCacheLoader() {

        }

        @Override
        public CompletableFuture<KeyAuthenticationToken> asyncLoad(String key, Executor executor) {
            return CompletableFuture.supplyAsync(() -> {
//                try (Connection conn = dataSource.getConnection()) {
////                    final String sql = "SELECT * FROM auth WHERE api_key = ?";
//                    final String sql = "SELECT * FROM auth WHERE api_key = ?";
//
//                  authRepository.findById(key);

                Auth auth=authRepository.findById(key).map(key1->{
                    Auth auth1=new Auth();
                    auth1.setApi_key(key1.getApi_key());
                    auth1.setUser_id(key1.getUser_id());
                    return auth1;
                }).block();
                if (auth!=null){
                    KeyAuthenticationToken authentication = new KeyAuthenticationToken(key, auth.getUser_id());
                    return authentication;
                }
                else{
                    return null;
                }
//                    try (PreparedStatement ps = conn.prepareStatement(sql)) {
//                        ps.setString(1, key);
//
//                        try (ResultSet rs = ps.executeQuery()) {
//                            if (rs.next()) {
//                                System.out.println(rs.toString());
                // Create an authentication object to hold the credentials, principal,
                // permissions, etc. that will be validated by the KeyAuthenticationManager
//                KeyAuthenticationToken authentication = new KeyAuthenticationToken(key, rs.getString("user_id"));
//                return authentication;
//                            } else {
//                                return null;
//                            }
//                        }
//                    }
//                } catch (SQLException e) {
//                    // In the event of database errors during authentication just log the error and return
//                    // an empty mono which will result in the request failing authentication.
//                    LOG.error("An error occurred during api key authentication.", e);
//                    return null;
//                }
            }, executor);

        }
        @Override
        public CompletableFuture<Map<String, KeyAuthenticationToken>> asyncLoadAll(Iterable<? extends String> keys, Executor executor) {
            throw new UnsupportedOperationException();
        }

        @Override
        public CompletableFuture<KeyAuthenticationToken> asyncReload(String key, KeyAuthenticationToken oldValue, Executor executor) {
            return asyncLoad(key, executor);
        }
    }


}