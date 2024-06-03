package Project.Records;
import Project.Scheduler.Appointment;
import Project.Users.Gender;
import Project.Utilities.File;
import Project.Users.Patient;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Recorder {

    public static void addRecord(Patient patient, String Issue, String prescription, String followUpDate, Appointment pastAppointment) {
        MedicalRecord medicalRecord = new MedicalRecord(Issue, prescription, followUpDate, pastAppointment);

        // write to txt file
        String data = File.formatData(medicalRecord.getIssue(), medicalRecord.getPrescription(), medicalRecord.getFollowUpDate(), patient.getUsername());
        try {
            File.writeToFile("\\records\\MedicalRecords.txt", data, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        patient.addMedicalRecord(medicalRecord);
    }

    public static void removeRecord(Patient patient, MedicalRecord medicalRecord){
        try {
            ArrayList<String> oldRecord = File.readFile("\\records\\MedicalRecords.txt");
            oldRecord.removeIf(s -> s.equals(medicalRecord.getIssue() + "," + medicalRecord.getPrescription() + "," + medicalRecord.getFollowUpDate() + "," + patient.getUsername()));
            //String[] oldRecordArray = oldRecord.toArray(new String[0]);
            File.updateFile("\\records\\MedicalRecords.txt", oldRecord);

        } catch (IOException e) {
        throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

    }
}
