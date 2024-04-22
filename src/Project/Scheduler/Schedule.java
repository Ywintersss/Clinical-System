package Project.Scheduler;

import java.util.ArrayList;

// Schedule class, schedule for each individual doctor
public class Schedule {
    private ArrayList<Appointment> appointments; // List of appointments

    public Schedule() {
        // Initialize the list of appointments for the doctor
        this.appointments = new ArrayList<>();
    }


    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointments(Appointment appointments) {
        this.appointments.add(appointments);
    }
}
