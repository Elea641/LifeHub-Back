package com.LifeHub_Back.auth.application.controller;

import com.LifeHub_Back.auth.domain.dto.AuthRequest;
import com.LifeHub_Back.auth.domain.service.interfaces.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IAuthService service;

    public AuthController(IAuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> signUp(@RequestBody AuthRequest user) throws Exception {
            return ResponseEntity.ok().body(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> signIn(@RequestBody AuthRequest user) {
            return ResponseEntity.ok().body(service.login(user));
    }
}
