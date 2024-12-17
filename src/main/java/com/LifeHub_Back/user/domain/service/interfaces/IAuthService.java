package com.LifeHub_Back.user.domain.service.interfaces;

import com.LifeHub_Back.user.domain.dto.AuthRequest;
import com.LifeHub_Back.user.domain.dto.AuthResponse;

import java.util.Map;

public interface IAuthService {
    Map<String, String> register(AuthRequest request) throws Exception;

    AuthResponse login(AuthRequest request);
}
