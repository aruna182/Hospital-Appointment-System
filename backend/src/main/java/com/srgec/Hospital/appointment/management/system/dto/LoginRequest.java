package com.srgec.Hospital.Appointment.Management.System.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    private String password;
}