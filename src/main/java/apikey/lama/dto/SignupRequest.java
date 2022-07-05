package apikey.lama.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * @author Ghonim
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class SignupRequest {

    @NotEmpty
    @NotBlank
    private String username;

    @NotEmpty
    @Email
    @NotBlank
    private String email;

    private String autherities;

    @NotBlank
    @NotEmpty
    private String password;

}
