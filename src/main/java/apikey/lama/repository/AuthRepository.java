package apikey.lama.repository;

import apikey.lama.models.Auth;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthRepository extends ReactiveCrudRepository<Auth, String> {
        Mono<Auth> findByEmail(String email);
}
