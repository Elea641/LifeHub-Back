package com.LifeHub_Back.user.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/authentification")
public class AuthentificationController {

    @PostMapping("/sign_up")
    public ResponseEntity<?> signUp () {
        try {
            Map<String, String> response = new HashMap<>();
            response.put("task", "Example task");

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/sign_in")
    public ResponseEntity<?> signIn () {
        try {
            Map<String, String> response = new HashMap<>();
            response.put("task", "Example task");

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
