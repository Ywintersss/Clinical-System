package Project.Scheduler;

import Project.Users.Doctor;
import Project.Users.Patient;
import java.time.LocalDateTime;

// Appointment class, template for an appointment
public class Appointment {
    private final String appointmentID;
    private final String scheduleID;
    private final String patientID;
    private final String doctorID;
    private String dateTime;
    private String description;

    public Appointment(String appointmentID, String scheduleID, String patientID, String doctorID, String dateTime, String description) {
        this.appointmentID = appointmentID;
        this.scheduleID = scheduleID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
