package com.srgec.Hospital.Appointment.Management.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srgec.Hospital.Appointment.Management.System.model.Doctor;
import com.srgec.Hospital.Appointment.Management.System.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = repository.findById(id).orElse(null);

        if (existingDoctor != null) {

            existingDoctor.setDoctorName(doctor.getDoctorName());
            existingDoctor.setSpecialization(doctor.getSpecialization());
            existingDoctor.setExperience(doctor.getExperience());

            return repository.save(existingDoctor);
        }

        return null;
    }

    public String deleteDoctor(Long id) {

        repository.deleteById(id);

        return "Doctor Deleted Successfully";
    }
}