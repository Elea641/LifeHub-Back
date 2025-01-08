package com.LifeHub_Back.user.application;

import com.LifeHub_Back.user.domain.dto.UserDto;
import com.LifeHub_Back.user.domain.service.interfaces.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAll() {
        try {
            return  ResponseEntity.ok().body(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/myself")
    public ResponseEntity<UserDto> getCurrentUser() {
        try {
            UserDto currentUser = userService.getCurrentUser();
            return ResponseEntity.ok().body(currentUser);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
