package com.stackdeans.loginregister.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class Response {

    private String token;
    private ArrayList<String> permissions;

}
