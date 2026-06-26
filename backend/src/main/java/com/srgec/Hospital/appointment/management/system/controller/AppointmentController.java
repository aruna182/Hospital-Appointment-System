package com.srgec.Hospital.Appointment.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.srgec.Hospital.Appointment.Management.System.model.Appointment;
import com.srgec.Hospital.Appointment.Management.System.service.AppointmentService;



@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public Appointment bookAppointment(
            @RequestBody Appointment appointment) {

        return service.bookAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {

        return service.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(
            @PathVariable Long id) {

        return service.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(
            @PathVariable Long id) {

        return service.deleteAppointment(id);
    }
}