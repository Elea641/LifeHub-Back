package com.LifeHub_Back.auth.domain.service;

import com.LifeHub_Back.auth.domain.dto.AuthRequest;
import com.LifeHub_Back.auth.domain.dto.AuthResponse;
import com.LifeHub_Back.auth.domain.service.interfaces.IAuthService;
import com.LifeHub_Back.user.domain.entity.User;
import com.LifeHub_Back.user.infrastructure.interfaces.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService implements IAuthService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(IUserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public Map<String, String> register(AuthRequest request) throws Exception {
        request.validate();
        if (!repository.findByEmail(request.getEmail()).isPresent()) {
            User user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role("ROLE_USER")
                    .createdAt(LocalDateTime.now())
                    .build();

            repository.save(user);

            Map<String, String> response= new HashMap<>();
            response.put("message", "Account successfully created");
            return response;

        } else {
            throw new Exception("Impossible to create your account with this information");
        }
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("role", user.getRole());

        String jwtToken = jwtService.generateToken(extraClaims, user);

        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
