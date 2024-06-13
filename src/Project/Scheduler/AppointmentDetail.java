package Project.Scheduler;

import Project.Users.*;

import java.util.HashMap;

public class AppointmentDetail {
    private Doctor doctor;
    private Patient patient;
    private Schedule schedule;
    private String appointmentTime;
    private String description;

    public AppointmentDetail(Doctor doctor, Patient patient, Schedule schedule, String appointmentTime, String description) {
        this.doctor = doctor;
        this.patient = patient;
        this.schedule = schedule;
        this.appointmentTime = appointmentTime;
        this.description = description;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getDescription() {
        return description;
    }
}
