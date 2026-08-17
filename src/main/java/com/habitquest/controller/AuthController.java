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
    public User register(@RequestParam String username, @RequestParam String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }
}