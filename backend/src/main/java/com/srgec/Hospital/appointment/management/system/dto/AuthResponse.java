package com.srgec.Hospital.Appointment.Management.System.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String message;

    private String role;
}