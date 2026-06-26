package com.srgec.Hospital.Appointment.Management.System.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srgec.Hospital.Appointment.Management.System.model.Appointment;
import com.srgec.Hospital.Appointment.Management.System.model.Doctor;
import com.srgec.Hospital.Appointment.Management.System.model.Patient;

import com.srgec.Hospital.Appointment.Management.System.repository.AppointmentRepository;
import com.srgec.Hospital.Appointment.Management.System.repository.DoctorRepository;
import com.srgec.Hospital.Appointment.Management.System.repository.PatientRepository;

@Service
public class AppointmentService {

@Autowired
private AppointmentRepository repository;

@Autowired
private DoctorRepository doctorRepository;

@Autowired
private PatientRepository patientRepository;

public Appointment bookAppointment(
Appointment appointment
){

Long doctorId =
appointment
.getDoctor()
.getDoctorId();

Long patientId =
appointment
.getPatient()
.getPatientId();

Doctor doctor =
doctorRepository
.findById(
doctorId
)
.orElseThrow(
()->new RuntimeException(
"Doctor not found"
)
);

Patient patient =
patientRepository
.findById(
patientId
)
.orElseThrow(
()->new RuntimeException(
"Patient not found"
)
);

appointment.setDoctor(
doctor
);

appointment.setPatient(
patient
);

return repository.save(
appointment
);

}

public List<Appointment> getAllAppointments(){

List<Appointment> appointments =
repository.findAll();

LocalDate today =
LocalDate.now();

LocalTime now =
LocalTime.now();

Iterator<Appointment> iterator =
appointments.iterator();

while(
iterator.hasNext()
){

Appointment appointment =
iterator.next();

LocalDate appointmentDate =
LocalDate.parse(
appointment.getAppointmentDate()
);

LocalTime appointmentTime =
LocalTime.parse(
appointment.getAppointmentTime()
);

boolean expired =

appointmentDate.isBefore(
today
)

||

(

appointmentDate.equals(
today
)

&&

appointmentTime.isBefore(
now
)

);

if(expired){

Long patientId =
appointment
.getPatient()
.getPatientId();

repository.deleteById(
appointment
.getAppointmentId()
);

patientRepository
.deleteById(
patientId
);

iterator.remove();

}

}

return appointments;

}

public Appointment getAppointmentById(
Long id
){

return repository
.findById(id)
.orElse(null);

}

public String deleteAppointment(
Long id
){

repository.deleteById(id);

return
"Appointment Cancelled Successfully";

}

}