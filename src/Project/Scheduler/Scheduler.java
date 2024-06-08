package Project.Scheduler;

import Project.Utilities.File;
import Project.Utilities.Utilities;
import java.io.IOException;



//Controller for schedules and appointments among patients and doctors
public class Scheduler {
    // Create a new appointment
    public static void makeAppointment(String doctorID, String patientID, String date, String time, String description) {
        String appointmentID = Utilities.generateID("AP", "\\schedules\\appointments.txt");
        String dateTime = date + " " + time;

        //Write to appointment file
        String appointmentData = File.formatData(appointmentID, doctorID, patientID, dateTime, description);
        try {
            File.appendToFile("\\schedules\\appointments.txt", appointmentData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void cancelAppointment(String doctorID, String patientID, Appointment appointment) {

        //Delete from appointment file
    }

    public static void completeAppointment(String issue, String prescription, String followUpDate, Appointment appointment) {
//        cancelAppointment(doctor, patient, appointment);
//
//        MedicalRecord medicalRecord = doctor.writeMedicalRecord(issue, prescription, followUpDate, appointment);
//
        //write to medical record file
//        Recorder.addRecord(patient, issue ,prescription, followUpDate, appointment);

        //delete from appointment file

    }
}
