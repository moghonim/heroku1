package com.stackdeans.loginregister.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//@Builder
//@Data
@Table("auth")
public class Auth {

    @Id
    private String api_key ;
    private String user_id ;

    private String username;

    public Auth() {
    }

    public Auth(String user_id, String api_key, String username) {
        this.user_id = user_id;
        this.api_key = api_key;
        this.username = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
