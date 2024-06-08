package Project.Records;
import Project.Utilities.File;
import Project.Utilities.Utilities;

import java.io.*;
import java.util.ArrayList;

public class Recorder {

    public static void addRecord(String patientID, String Issue, String prescription, String followUpDate, String appointmentID) {
        String recordID = Utilities.generateID("RC","\\records\\MedicalRecords.txt");

        // write to txt file
        String data = File.formatData(recordID, patientID, Issue, prescription, followUpDate, appointmentID);
        try {
            File.appendToFile("\\records\\MedicalRecords.txt", data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void removeRecord(String RecordID, String PatientID) {
        try {
            ArrayList<String> oldRecord = File.readFile("\\records\\MedicalRecords.txt");
            ArrayList<String[]> oldRecordArray = File.parseData(oldRecord);

            oldRecordArray.removeIf(s -> s[0].equals(RecordID) && s[1].equals(PatientID));

            // write to txt file
            File.updateFile("\\records\\MedicalRecords.txt", oldRecordArray);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        //addRecord("PA1", "test", "test", "test", "AP1");
        removeRecord("RC1", "PA1");
    }
}
