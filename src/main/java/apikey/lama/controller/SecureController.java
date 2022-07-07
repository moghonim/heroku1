package apikey.lama.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Controller that requires an API key to access.
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class SecureController {
    private static final Logger LOG = LoggerFactory.getLogger(NonSecureController.class);


    @GetMapping(value = "/api/v1/secure")
    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    public Mono<ResponseEntity<?>> secure(ServerHttpSecurity serverHttpSecurity) {
        return Mono.fromSupplier(() -> {
            LOG.info("Received request: /api/v1/secure");
//            return ResponseEntity.ok("\"API_Key\" \":\" \"aec093c2-c981-44f9-9a4a-365ad1d2f05e\"");

            return ResponseEntity.ok("secured with api key");
        });
    }
}
