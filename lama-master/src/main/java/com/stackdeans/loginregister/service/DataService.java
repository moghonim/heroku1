package com.stackdeans.loginregister.service;

import com.stackdeans.loginregister.dto.LoginRequest;
import com.stackdeans.loginregister.dto.Response;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.sql.DataSource;
import java.util.ArrayList;

@Service
public class DataService {



    public ResponseEntity<?> getData(LoginRequest loginRequest){
//        WebClient.ResponseSpec responseSpec=WebClient.create().post().uri()



        Response res=new Response();
        if(loginRequest.getEmail().equals("ahmed@gmail.com")&&loginRequest.getPassword().equals("123456")){

            ArrayList<String> list=new ArrayList<>();
            list.add("super_admin");
            list.add("customer");
            res.setPermissions(list);
            res.setToken("aec093c2-c981-44f9-9a4a-365ad1d2f05e");




                System.out.println(                ResponseEntity.ok().header("Access-Control-Allow-Origin","*").header("Access-Control-Request-Method","POST, GET, OPTIONS").header("Access-Control-Allow-Headers", "*").body(res));
//                return  ResponseEntity.ok(res);

          return  ResponseEntity.ok().header("Access-Control-Allow-Origin","Access-Control-Allow-Origin").header("Access-Control-Request-Method","POST, GET, OPTIONS").header("Access-Control-Allow-Headers", "*").body(res);
        }
        else{
                return ResponseEntity.badRequest().build();
                   }


    }

}
