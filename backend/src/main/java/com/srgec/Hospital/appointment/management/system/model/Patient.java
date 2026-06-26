package com.srgec.Hospital.Appointment.Management.System.model;

import jakarta.persistence.*;

@Entity
public class Patient {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long patientId;

private String patientName;

private String email;

private String phone;

private String issue;

public Patient(){}

public Long getPatientId() {
return patientId;
}

public void setPatientId(Long patientId) {
this.patientId = patientId;
}

public String getPatientName() {
return patientName;
}

public void setPatientName(String patientName) {
this.patientName = patientName;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getIssue() {
return issue;
}

public void setIssue(String issue) {
this.issue = issue;
}

}