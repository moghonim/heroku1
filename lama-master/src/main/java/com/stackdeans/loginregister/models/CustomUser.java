package com.stackdeans.loginregister.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

//@Data
//@Builder
@Table("users")
public class CustomUser implements GrantedAuthority {

    @Id
    private Long id;
    private String username;
    private String email;
    private String password;
    private String picture;
    private Set<Role> roles;

    public CustomUser() {
    }

    public CustomUser(Long id,String username, String email, String password, Set roles, String picture) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.picture=picture;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Set<Role> getRoles() {
        return roles;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setRoles(Set roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getAuthority() {
        return roles.toString();
    }
}
