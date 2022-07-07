package apikey.lama.models;

import lombok.*;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
//@Table("users")
public class CustomUser implements UserDetails {

//    @Id
    private Long id;
    private String username;
    private String email;
    private String password;
    private String picture;
    private String authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(authorities.split(","))
                .map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public CustomUser(String username, String email, String password, String authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities=authorities;
    }
    public String getAuths(){
        return this.authorities;
    }
}
