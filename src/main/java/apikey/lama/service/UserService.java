package apikey.lama.service;

import apikey.lama.models.CustomUser;
import apikey.lama.repository.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    CustomUserRepository userRepository;

    public Flux<CustomUser> getAll() {
        return userRepository.findAll();
    }
}

