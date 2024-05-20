package Project.Scheduler;

import Project.Records.MedicalRecord;
import Project.Records.Recorder;
import Project.Users.Doctor;
import Project.Users.Patient;
import Project.Scheduler.Appointment;



//Controller for schedules and appointments among patients and doctors
public class Scheduler {
    // Create a new appointment
    public static void makeAppointment(Doctor doctor, Patient patient, String description) {
        //String AppointmentID = generateID();

        Appointment appointment = new Appointment(patient, doctor, description);

        doctor.getSchedule().addAppointments(appointment);

        patient.addAppointment(appointment);
        //Write to appointment file

    }

    public static void cancelAppointment(Doctor doctor, Patient patient, Appointment appointment) {
        doctor.getSchedule().removeAppointment(appointment);
        patient.getAppointments().remove(appointment);

        //Delete from appointment file
    }

    public static void completeAppointment(String issue, String prescription, String followUpDate, Appointment appointment) {
        Patient patient = appointment.getPatient();
        Doctor doctor = appointment.getDoctor();

        cancelAppointment(doctor, patient, appointment);

        MedicalRecord medicalRecord = doctor.writeMedicalRecord(issue, prescription, followUpDate, appointment);

        //write to medical record file
        Recorder.addRecord(patient, issue ,prescription, followUpDate, appointment);

        //delete from appointment file

    }
}
