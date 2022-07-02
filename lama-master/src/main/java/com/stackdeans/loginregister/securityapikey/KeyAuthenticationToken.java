package com.stackdeans.loginregister.securityapikey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Represents an authentication token within the example application.
 */
public class KeyAuthenticationToken implements Authentication {

    private final String apiKey;
    private final String principal;
    private boolean authenticated = false;

    public KeyAuthenticationToken(final String apiKey, final String principal) {
        this.apiKey = apiKey;
        this.principal = principal;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        MapReactiveUserDetailsService mapReactiveUserDetailsService = userDetailsService();
//        Map<String,UserDetails> map= (Map<String, UserDetails>) mapReactiveUserDetailsService;
//        UserDetails map.get("user");

//        UserDetails user = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("123456"))
//                .roles("ADMIN")
//                .build();
//        Set<CustomUser> users=new HashSet<>();
//        CustomUser customUser = new CustomUser("ROLE_USER");
//        users.add(customUser);
//        users.add(user);
//        users.add(admin);
        return null;
    }

    @Override
    public Object getCredentials() {
        return apiKey;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return principal;
    }





//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User
//                .withUsername("user")
//                .password(passwordEncoder().encode("123456"))
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User
//                .withUsername("admin")
//                .password(passwordEncoder().encode("123456"))
//                .roles("ADMIN")
//                .build();
//        return new MapReactiveUserDetailsService(user, admin);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}