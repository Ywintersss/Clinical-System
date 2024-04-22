package Project.Scheduler;

import Project.Users.Doctor;
import Project.Users.Patient;
import java.time.LocalDateTime;

// Appointment class, template for an appointment
public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime date;
    private String description;

    public Appointment(Patient patient, Doctor doctor, String description) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = LocalDateTime.now();
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        Doctor TTJ = new Doctor("Bloople", "password", "TTJ");
        Schedule TTJschedule = TTJ.getSchedule();
        TTJschedule.addAppointments(new Appointment(new Patient("Ywinters", "password", "Shawn"), TTJ,"description"));
        System.out.println(TTJschedule.getAppointments());
    }
}
