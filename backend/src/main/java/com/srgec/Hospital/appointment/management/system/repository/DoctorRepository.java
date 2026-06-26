package com.srgec.Hospital.Appointment.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srgec.Hospital.Appointment.Management.System.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
