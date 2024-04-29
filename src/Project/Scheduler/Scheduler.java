package Project.Scheduler;

import Project.Users.Doctor;
import Project.Users.Patient;


public class Scheduler {
    // Create a new appointment
    public void makeAppointment(Doctor doctor, Patient patient, Appointment appointment) {
        //String AppointmentID = generateID();

        doctor.getSchedule().addAppointments(appointment);
        //patient.getSchedule().addAppointments(appointment);
    }
}
