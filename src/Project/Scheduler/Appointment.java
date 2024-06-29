package Project.Scheduler;

import Project.Controller.UserDataManager;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Users.Patient;
import Project.Users.User;
import javafx.collections.ObservableList;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;

// Appointment class, template for an appointment
public class Appointment {
    private final String appointmentID;
    private final String scheduleID;
    private final String patientID;
    private String time;
    private String description;
    private String isPaid;

    public Appointment(String appointmentID, String scheduleID, String patientID, String time, String description, String isPaid) {
        this.appointmentID = appointmentID;
        this.scheduleID = scheduleID;
        this.patientID = patientID;
        this.time = time;
        this.description = description;
        this.isPaid = isPaid;
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


    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getIsPaid() {
        return isPaid;
    }


    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setPaid(String isPaid) {
        this.isPaid = isPaid;
    }
}
