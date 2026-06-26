package com.srgec.Hospital.Appointment.Management.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srgec.Hospital.Appointment.Management.System.dto.AuthResponse;
import com.srgec.Hospital.Appointment.Management.System.dto.LoginRequest;
import com.srgec.Hospital.Appointment.Management.System.model.User;
import com.srgec.Hospital.Appointment.Management.System.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {

        return userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {

        User user =
                userRepository
                        .findByUsername(
                                request.getUsername()
                        )
                        .orElseThrow(
                                () ->
                                        new RuntimeException(
                                                "Invalid Credentials"
                                        )
                        );

        if (
                !user
                        .getPassword()
                        .equals(
                                request.getPassword()
                        )
        ) {

            throw new RuntimeException(
                    "Invalid Credentials"
            );
        }

        return new AuthResponse(

                "Login Successful",

                user.getRole()

        );
    }

    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }

    public User getUserById(Long id) {

        return userRepository
                .findById(id)
                .orElse(null);

    }

    public List<User> getAllUsers() {

        return userRepository.findAll();

    }
}