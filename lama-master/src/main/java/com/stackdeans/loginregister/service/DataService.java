package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.dto.LoginRequest;
import com.stackdeans.loginregister.dto.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class DataService {

    private final DataSource dataSource;

    public DataService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Mono<ResponseEntity<?>> getData(LoginRequest loginRequest){
        Response res=new Response();
        if(loginRequest.getEmail().equals("ahmed@gmail.com")&&loginRequest.getPassword().equals("123456")){

            ArrayList<String> list=new ArrayList<>();
            list.add("super_admin");
            list.add("customer");
            res.setPermissions(list);
            res.setToken("aec093c2-c981-44f9-9a4a-365ad1d2f05e");
            return Mono.fromSupplier(() -> {

                return ResponseEntity.ok(res);
            });
        }else{
            return Mono.fromSupplier(() -> {
                return ResponseEntity.badRequest().build();
            });        }


    }

}
