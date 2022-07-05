package apikey.lama.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@With
public class ErrorResponse {
    private int status;
    private String message;
    private List<String> errors;


}
