package apikey.lama.service;

import apikey.lama.dto.LoginRequest;
import apikey.lama.dto.LoginResponse;
import apikey.lama.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {

@Autowired
    CustomUserRepository customUserRepository;

    public ResponseEntity<?> getData(LoginRequest loginRequest){
//        WebClient.ResponseSpec responseSpec=WebClient.create().post().uri()



        LoginResponse res=new LoginResponse();
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
