package com.LifeHub_Back.user.domain.service;

import com.LifeHub_Back.user.domain.dto.UserDto;
import com.LifeHub_Back.user.domain.entity.User;
import com.LifeHub_Back.user.domain.service.interfaces.ISecurityContextAuthentificationService;
import com.LifeHub_Back.user.domain.service.interfaces.IUserMapperService;
import com.LifeHub_Back.user.domain.service.interfaces.IUserService;
import com.LifeHub_Back.user.infrastructure.interfaces.IUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final IUserMapperService userMapper;
    private final ISecurityContextAuthentificationService securityContextAuthentificationService;

    public UserService(IUserRepository userRepository, IUserMapperService userMapper, ISecurityContextAuthentificationService securityContextAuthentificationService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.securityContextAuthentificationService = securityContextAuthentificationService;
    }

    public List<UserDto> getAllUsers() throws Exception {
        Authentication authentication = securityContextAuthentificationService.getAuthentication();

        if (authentication.isAuthenticated()) {
            List<User> users = userRepository.findAll();

            if (users != null && !users.isEmpty()) {
                return users.stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList());
            } else {
                throw new NoSuchElementException("No users found");
            }
        } else {
            throw new AccessDeniedException("User is not authenticated");
        }
    }

    public UserDto getCurrentUser() throws Exception {
        Authentication authentication = securityContextAuthentificationService.getAuthentication();

        if (authentication.isAuthenticated()) {
            String currentUsername = authentication.getName();
            Optional<User> currentUser = userRepository.findByEmail(currentUsername);
            if (currentUser.isPresent()) {
                return userMapper.toDto(currentUser.get());
            } else {
                throw new UserPrincipalNotFoundException("User not found");
            }
        } else {
            throw new AccessDeniedException("User is not authenticated");
        }
    }
}
