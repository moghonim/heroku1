package apikey.lama.repository;
import apikey.lama.models.CustomUser;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CustomUserRepository extends ReactiveCrudRepository<CustomUser, Long> {

    Mono<CustomUser> findByUsername(String username);

    Mono<CustomUser> findByEmail(String email);
}
