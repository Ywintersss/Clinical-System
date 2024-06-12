package Project.Scheduler;

import Project.Users.Doctor;
import Project.Users.Patient;
import java.time.LocalDateTime;

// Appointment class, template for an appointment
public class Appointment {
    private final String appointmentID;
    private final String scheduleID;
    private final String patientID;
    private String time;
    private String description;

    public Appointment(String appointmentID, String scheduleID, String patientID, String time, String description) {
        this.appointmentID = appointmentID;
        this.scheduleID = scheduleID;
        this.patientID = patientID;
        this.time = time;
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

    public String getTimeTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
