package com.LifeHub_Back.user.domain.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String role;
    @Column(name = "created_At")
    private LocalDateTime createdAt;

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

    public User(String email, String password, String role, LocalDateTime createdAt) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public static class Builder {
        private String email;
        private String password;
        private String role;
        private LocalDateTime createdAt;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public User build() {
            return new User(email, password, role, createdAt);
        }
    }

    public static Builder builder() {
        return new Builder();
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        if (!role.equals("Admin") && !role.equals("User")) {
            throw new IllegalArgumentException("Invalid role: must be 'Admin' or 'User'");
        }
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        this.role = role.startsWith("ROLE_") ? role : "ROLE_" + role.toUpperCase();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
