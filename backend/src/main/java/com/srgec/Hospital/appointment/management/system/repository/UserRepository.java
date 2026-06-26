package com.srgec.Hospital.Appointment.Management.System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srgec.Hospital.Appointment.Management.System.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}