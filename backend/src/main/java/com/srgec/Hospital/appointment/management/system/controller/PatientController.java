package com.srgec.Hospital.Appointment.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.srgec.Hospital.Appointment.Management.System.model.Patient;
import com.srgec.Hospital.Appointment.Management.System.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient savePatient(
            @RequestBody Patient patient) {

        return service.savePatient(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {

        return service.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(
            @PathVariable Long id) {

        return service.getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(
            @PathVariable Long id,
            @RequestBody Patient patient) {

        return service.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(
            @PathVariable Long id) {

        return service.deletePatient(id);
    }
}