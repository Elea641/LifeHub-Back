package com.LifeHub_Back.user.domain.service;

import com.LifeHub_Back.user.domain.service.interfaces.ISecurityContextAuthentificationService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class SecurityContextAuthentificationService implements ISecurityContextAuthentificationService {

    @Override
    public Authentication getAuthentication() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("User is not authenticated");
        }
        return authentication;
    }
}
