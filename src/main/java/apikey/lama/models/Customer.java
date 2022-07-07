package apikey.lama.models;

import lombok.Builder;
import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
//@Table("customer")
public class Customer {
//    @Id
    private Long id;
    private String customer_name;
    private String customer_type;
    private String customer_status;

    public boolean hasId() {
        return id != null;
    }
}
