package com.LifeHub_Back.user.domain.service.interfaces;

import org.springframework.security.core.Authentication;

import java.nio.file.AccessDeniedException;

public interface ISecurityContextAuthentificationService {
    Authentication getAuthentication() throws AccessDeniedException;
}
