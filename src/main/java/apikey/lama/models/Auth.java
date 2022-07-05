package apikey.lama.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//@Builder
@Data
@Table("auth")
public class Auth {

    @Id
    private String api_key ;
    private Long user_id ;

    private String email;

    private String authorities;

    public Auth() {
    }

    public Auth(Long user_id, String api_key, String username) {
        this.user_id = user_id;
        this.api_key = api_key;
        this.email = username;
    }

    public Auth(Long user_id, String api_key, String username,String authorities) {
        this.user_id = user_id;
        this.api_key = api_key;
        this.email = username;
        this.authorities=authorities;
    }

}
