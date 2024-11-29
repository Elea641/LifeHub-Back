package com.LifeHub_Back.configuration.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configure(http))
                .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // You can disable csrf protection by removing this line
                        .ignoringRequestMatchers("/api/auth/register", "/api/auth/login")
                        .disable()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//
                )
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(
                                "/api/tasks",
                                "/api/**"
                        ).permitAll()
                        //.requestMatchers("/api/teams/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
                        .anyRequest().authenticated()
                );

        //.exceptionHandling((exception) -> exception
        //.authenticationEntryPoint(authenticationEntryPoint)
        //.accessDeniedHandler(accessDeniedHandler)
        //)
        //.authenticationProvider(authenticationProvider)

        //.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
