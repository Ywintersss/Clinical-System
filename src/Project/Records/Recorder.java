package Project.Records;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * <h3>UserDataManager class, a singleton class for controlling and interacting with the db and user data</h3>
 *
 *
 */
public class Recorder {
    private static Recorder instance;

    // private constructor so it can only be instantiated once through the class itself
    private Recorder() { }

    // instantiate the class if it doesn't exist already
    public static Recorder getInstance() {
        if(instance == null) {
            instance = new Recorder();
        }
        return instance;
    }

    // adding a medical record
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

    public void addFeedback(String ...feedbackData) {
        String path = "\\records\\Feedback.txt";
        String feedbackID = Utilities.generateID("FB", path) + ",";

        // write to Feedback.txt
        String data = File.formatData(feedbackData);
        try {
            File.appendToFile(path, feedbackID + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Feedback> getAllFeedback() {
        try {
            ArrayList<String> feedbackData = File.readFile("\\records\\Feedback.txt");
            ArrayList<String[]> parseFeedbackData = File.parseData(feedbackData);
            ObservableList<Feedback> FXFeedbackData = FXCollections.observableArrayList();

            for (String[] data : parseFeedbackData) {
                FXFeedbackData.add(new Feedback(data[0], data[1], data[2], data[3]));
            }
            return FXFeedbackData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeFeedback(String feedbackID) {
        String path = "\\records\\Feedback.txt";

        try{
            ArrayList<String> feedbackData = File.readFile(path);
            ArrayList<String[]> parseFeedbackData = File.parseData(feedbackData);

            parseFeedbackData.removeIf(s -> s[0].equals(feedbackID));

            File.updateFile(path, parseFeedbackData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // get all medical records
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

    // get a patient's medical record
    public ObservableList<MedicalRecord> getPatientMedicalRecord(String patientID) {
        try {
            ObservableList<MedicalRecord> medicalRecordList = getAllRecords();
            medicalRecordList.removeIf(medicalRecord -> !medicalRecord.getPatientID().equals(patientID));

            return medicalRecordList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // remove a medical record
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
