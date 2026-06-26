package com.srgec.Hospital.Appointment.Management.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srgec.Hospital.Appointment.Management.System.model.Patient;
import com.srgec.Hospital.Appointment.Management.System.repository.PatientRepository;

@Service
public class PatientService {

@Autowired
private PatientRepository repository;

public Patient savePatient(
Patient patient
){

return repository.save(
patient
);

}

public List<Patient> getAllPatients(){

return repository.findAll();

}

public Patient getPatientById(
Long id
){

return repository
.findById(id)
.orElse(null);

}

public Patient updatePatient(
Long id,
Patient patient
){

Patient existingPatient =
repository
.findById(id)
.orElse(null);

if(
existingPatient!=null
){

existingPatient.setPatientName(
patient.getPatientName()
);

existingPatient.setEmail(
patient.getEmail()
);

existingPatient.setPhone(
patient.getPhone()
);

existingPatient.setIssue(
patient.getIssue()
);

return repository.save(
existingPatient
);

}

return null;

}

public String deletePatient(
Long id
){

repository.deleteById(id);

return
"Patient Deleted Successfully";

}

}