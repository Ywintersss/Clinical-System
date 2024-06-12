package Project.Scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

// Schedule class, schedule for each individual doctor
public class Schedule {
    private String scheduleID;
    private String doctorID;
    private ArrayList<Appointment> appointments; // List of appointments
    private String startTime;
    private String endTime;
    private String date;

    public Schedule() {
        this.scheduleID = scheduleID;
        this.doctorID = doctorID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        // Initialize the list of appointments for the doctor
        this.appointments = new ArrayList<>();
    }
    public String getScheduleID() {
        return scheduleID;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointments(Appointment appointments) {
        this.appointments.add(appointments);
    }

    public void removeAppointment(Appointment appointments) {
        this.appointments.remove(appointments);
    }
}
