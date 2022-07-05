package apikey.lama.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class LoginResponse {

    private String token;
    private ArrayList<String> permissions;

}
