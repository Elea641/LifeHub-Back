package com.LifeHub_Back.user.domain.entity;

import jakarta.persistence.*;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;

    public User() {}

    public User(String email, String role) {
        setEmail(email);
        setRole(role);
    }

    public User(String email, String password, String role) {
        setEmail(email);
        setPassword(password);
        setRole(role);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
       this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        if (role == null || (!role.equals("Admin") && !role.equals("User"))) {
            throw new IllegalArgumentException("Invalid role: must be 'Admin' or 'User'");
        }
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
