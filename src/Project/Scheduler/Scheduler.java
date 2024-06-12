package Project.Scheduler;

import Project.Users.Gender;
import Project.Users.Patient;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;


//Controller for schedules and appointments among patients and doctors
public class Scheduler {
    private static Scheduler instance;
    private Scheduler() {}
    public static Scheduler getInstance() {
        if(instance == null) {
            instance = new Scheduler();
        }
        return instance;
    }

    public ObservableList<Appointment> getAllAppointments(){
        try {
            ArrayList<String> appointmentData = File.readFile("\\schedules\\Appointments.txt");
            ArrayList<String[]> parseAppointmentData = File.parseData(appointmentData);

            ObservableList<Appointment> FXAppointmentData = FXCollections.observableArrayList();
            for (String[] data : parseAppointmentData) {
                FXAppointmentData.add(new Appointment(data[0], data[1], data[2], data[3], data[4]));
            }

            return FXAppointmentData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Create a new appointment
    public void makeAppointment(String scheduleID, String patientID, String time, String description) {
        String appointmentID = Utilities.generateID("AP", "\\schedules\\appointments.txt");
        //Write to appointment file
        String appointmentData = File.formatData(appointmentID, scheduleID,patientID, time, description);
        try {
            File.appendToFile("\\schedules\\appointments.txt", appointmentData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void cancelAppointment(String doctorID, String patientID, Appointment appointment) {

        //Delete from appointment file
    }

    public void completeAppointment(String issue, String prescription, String followUpDate, Appointment appointment) {
//        cancelAppointment(doctor, patient, appointment);
//
//        MedicalRecord medicalRecord = doctor.writeMedicalRecord(issue, prescription, followUpDate, appointment);
//
        //write to medical record file
//        Recorder.addRecord(patient, issue ,prescription, followUpDate, appointment);

        //delete from appointment file

    }
}
