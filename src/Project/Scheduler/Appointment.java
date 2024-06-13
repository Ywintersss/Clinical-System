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
    private String patientName;
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

    public String getPatient() {
        ObservableList<Patient> data = UserDataManager.getInstance().getAllPatients();
        for (Patient patient : data) {
            if (patient.getID().equals(patientID)) {
                this.patientName = patient.getName();
            }
        }
        return patientName;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getDoctor() {
        ObservableList<Schedule> schedules = Scheduler.getInstance().getAllSchedules();
        Doctor user = (Doctor) UserSession.getInstance().getCurrentUser();
        String doctorID = user.getID();
        ArrayList<String> data = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if (schedule.getDoctorID().equals(doctorID) && schedule.getScheduleID().equals(scheduleID)) {
                data.add(user.getName());
            }
        }
        String doctor = data.get(0);
        return doctor;
    }

    public String getDate() {
        ObservableList<Schedule> schedules = Scheduler.getInstance().getAllSchedules();
        User user = UserSession.getInstance().getCurrentUser();
        String doctorID = user.getID();
        ArrayList<String> data = new ArrayList<>();

        for (Schedule schedule : schedules) {
            if (schedule.getDoctorID().equals(doctorID) && schedule.getScheduleID().equals(scheduleID)) {
                data.add(schedule.getDate());
            }
        }
        return data.get(0);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
