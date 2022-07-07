package apikey.lama.controller;

import apikey.lama.dto.UserDto;
import apikey.lama.models.CustomUser;
import apikey.lama.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
//@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public Flux<CustomUser> getAll() {
        return userService.getAll();
    }


}
