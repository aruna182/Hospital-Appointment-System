package com.srgec.Hospital.Appointment.Management.System.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null &&
                authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            try {
                String username =
                        jwtService.extractUsername(token);

                System.out.println("User : " + username);

            } catch (Exception e) {
                response.sendError(
                        HttpServletResponse.SC_UNAUTHORIZED,
                        "Invalid Token");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}