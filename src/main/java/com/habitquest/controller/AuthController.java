package com.habitquest.controller;

import com.habitquest.model.User;
import com.habitquest.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User registerOrLogin(@RequestParam String username, @RequestParam String password) {
        return userRepository.findByUsername(username)
                .orElseGet(() -> userRepository.save(new User(username, password)));
    }
}
