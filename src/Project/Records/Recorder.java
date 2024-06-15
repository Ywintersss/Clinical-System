package Project.Records;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class Recorder {
    private static Recorder instance;
    private Recorder() { }
    public static Recorder getInstance() {
        if(instance == null) {
            instance = new Recorder();
        }
        return instance;
    }

    public void addRecord(String ...patientData) {
        String path = "\\records\\MedicalRecords.txt";
        String recordID = Utilities.generateID("RC", path) + ",";

        // write to MedicalRecords.txt
        String data = File.formatData(patientData);
        try {
            File.appendToFile(path, recordID + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<MedicalRecord> getAllRecords() {
        try {
            ArrayList<String> oldRecord = File.readFile("\\records\\MedicalRecords.txt");
            ArrayList<String[]> oldRecordArray = File.parseData(oldRecord);
            ObservableList<MedicalRecord> medicalRecordList = FXCollections.observableArrayList();

            for (String[] dataArray : oldRecordArray) {
                MedicalRecord medicalRecord = new MedicalRecord(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
                medicalRecordList.add(medicalRecord);
            }
            return medicalRecordList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<MedicalRecord> getPatientMedicalRecord(String patientID) {
        try {
            ObservableList<MedicalRecord> medicalRecordList = getAllRecords();
            medicalRecordList.removeIf(medicalRecord -> !medicalRecord.getPatientID().equals(patientID));

            return medicalRecordList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeRecord(String RecordID, String PatientID) {
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

    public void main(String[] args) {
        //addRecord("PA1", "test", "test", "test", "AP1");
        removeRecord("RC1", "PA1");
    }
}
