package Project.Scheduler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

// Schedule class, schedule for each individual doctor
public class Schedule {
    private ArrayList<Appointment> appointments; // List of appointments
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Schedule() {
        // Initialize the list of appointments for the doctor
        this.appointments = new ArrayList<>();
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
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
