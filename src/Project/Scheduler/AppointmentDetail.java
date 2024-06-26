package Project.Scheduler;

import Project.Users.*;

/**
 * <h3>AppointmentDetail class, template for a compilation of related appointment information which includes:</h3>
 * Appointment (Object), Doctor (Object), Patient (Object), Schedule (Object), AppointmentTime (String)
 *
*/

public class AppointmentDetail {
    private Appointment appointment;
    private Doctor doctor;
    private Patient patient;
    private Schedule schedule;
    private String appointmentTime;
    private String description;
    private String isPaid;

    public AppointmentDetail(Appointment appointment, Doctor doctor, Patient patient, Schedule schedule, String appointmentTime, String description, String isPaid) {
        this.appointment = appointment;
        this.doctor = doctor;
        this.patient = patient;
        this.schedule = schedule;
        this.appointmentTime = appointmentTime;
        this.description = description;
        this.isPaid = isPaid;
    }
    public Appointment getAppointment(){
        return appointment;
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

    public String getIsPaid() {
        return isPaid;
    }

    @Override
    public String toString() {
        return this.getAppointment().getAppointmentID() + " " + this.getSchedule().getDate() + " " + this.getAppointment().getTime();
    }
}
