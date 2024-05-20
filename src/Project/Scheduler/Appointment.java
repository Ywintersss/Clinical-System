package Project.Scheduler;

import Project.Users.Doctor;
import Project.Users.Patient;
import java.time.LocalDateTime;

// Appointment class, template for an appointment
public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime dateTime;
    private String description;

    public Appointment(Patient patient, Doctor doctor, String description) {
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = LocalDateTime.now();
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDate() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDate(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
