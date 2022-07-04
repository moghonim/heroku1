package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.models.Auth;
import com.stackdeans.loginregister.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Train {

    @Autowired
    private AuthRepository authRepository;

    @Bean
    public void print(){
        Auth auth=authRepository.findById("aec093c2-c981-44f9-9a4a-365ad1d2f05e").map(key1->{
            Auth auth1=new Auth();
            auth1.setApi_key(key1.getApi_key());
            auth1.setUser_id(key1.getUser_id());
            return auth1;
        }).block();


        System.out.println(auth.getUser_id());

    }
}
