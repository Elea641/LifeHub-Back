/*
package com.LifeHub_Back.Entity;


import com.LifeHub_Back.user.domain.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserEntityTest {
    private User user;
    private String userEmail;
    private String userPassword;
    private String userRoleUser;
    private String userRoleAdmin;

    @BeforeEach
    public void setUp() {
        userEmail = "email@mail.com";
        userPassword = "password";
        userRoleUser = "User";
        userRoleAdmin = "Admin";
        user = new User(userEmail, userPassword, userRoleUser, LocalDateTime.of(2025, 1, 8, 10, 0, 0));
    }

    @Test
    void test_User_Id() {
        Long id = 1L;
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void test_User_Password() {

        user.setPassword(userPassword);
        assertEquals("password", user.getPassword());
    }

    @Test
    void test_User_Email() {
        assertEquals(userEmail, user.getEmail());
    }

    @Test
    void test_Invalid_Email() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new User("invalid-email", "User"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void test_Set_Invalid_Email() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setEmail("invalid-email"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void test_User_Role_User() {
        user.setRole(userRoleUser);
        assertEquals("ROLE_USER", user.getRole());
    }

    @Test
    void test_User_Role_Admin() {
        user.setRole(userRoleAdmin);
        assertEquals("ROLE_ADMIN", user.getRole());
    }

    @Test
    void test_Invalid_Role() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> user.setRole("Manager"));
        assertEquals("Invalid role: must be 'Admin' or 'User'", exception.getMessage());
    }

    @Test
    void test_Default_Role_Invalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new User(userEmail, "InvalidRole"));
        assertEquals("Invalid role: must be 'Admin' or 'User'", exception.getMessage());
    }

    @Test
    void test_User_LocalDateTime() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2025, 1, 8, 10, 0, 0);
        LocalDateTime actualDateTime = user.getCreatedAt();

        assertEquals(expectedDateTime, actualDateTime);
    }
}
 */