package Project.Controller;

import Project.ClinicalSystem;
import Project.Interface.Pages.MedicalRecord;
import Project.Interface.Pages.PaymentHistory;
import Project.Payments.Payment;
import Project.Payments.PaymentHandler;
import Project.Payments.PaymentMethod;
import Project.Users.*;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserDataManager {
    private static UserDataManager instance;
    private UserDataManager() {}
    public static UserDataManager getInstance() {
        if(instance == null) {
            instance = new UserDataManager();
        }
        return instance;
    }
    // Add user to txt file
    public void addPatient(String ...userData) {
        if (userData.length < 9) {
            return;
        }
        String path = "\\users\\Patient.txt";
        String ID = Utilities.generateID("PA", path) + ",";

        String medicalRecordPath = "\\records\\MedicalRecords.txt";
        String medicalRecordID = Utilities.generateID("MR", medicalRecordPath) + ",";

        String data = File.formatData(userData);
        try {
            File.appendToFile(path, ID + medicalRecordID + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDoctor(String ...userData) {
        String doctorPath = "\\users\\Doctor.txt";
        String ID = Utilities.generateID("DO", doctorPath) + ",";

        String schedulePath = "\\schedules\\Schedules.txt";
        String ScheduleID = Utilities.generateID("SC", schedulePath) + ",";

        String data = File.formatData(userData);
        try {
            File.appendToFile(doctorPath, ID + ScheduleID + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdmin(String username, String password) {
        String data = File.formatData(username, password);
        try {
            File.appendToFile("Admin.txt",data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to get and authorize a user based on username and password
     *
     * @param username User's username
     * @param password User's password
     * @return A user extended object, either a Patient or Doctor
     */

    // Read and Gets user from txt file with username and password
    public User getUser(String username, String password) {
        try {
            //get all user files from user directory and iterate through them
            for (String file : File.getAllDbFilesFromDirectory("\\users\\")) {
                //read all user data from the file
                ArrayList<String> userData = File.readFile(file);

                //parse all user data
                ArrayList<String[]> parseUserData = File.parseData(userData);

                //iterate through each individual user's data
                for (String[] dataArray : parseUserData) {
                    //check if username and password match
                    if (username.equals(dataArray[1]) && password.equals(dataArray[2])) {
                        //create user based on user type
                        if(file.contains("Patient")){
                            return new Patient(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5],
                                    Integer.parseInt(dataArray[6]), Gender.valueOf(dataArray[7]),
                                    Double.parseDouble(dataArray[8]), Double.parseDouble(dataArray[9]), dataArray[10]);
                        }
                        else if(file.contains("Doctor")){
                            return new Doctor(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5],
                                    Integer.parseInt(dataArray[6]), Gender.valueOf(dataArray[7]),
                                    Integer.parseInt(dataArray[8]), dataArray[9], dataArray[10], dataArray[11]);
                        } else if (file.contains("Admin")) {
                            return new Admin(dataArray[0], dataArray[1], dataArray[2]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public ObservableList<Patient> getAllPatients() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Patient.txt");
            ArrayList<String[]> parsePatientData = File.parseData(userData);

            ObservableList<Patient> FXPatientData = FXCollections.observableArrayList();
            for (String[] data : parsePatientData) {
                FXPatientData.add(new Patient(data[0], data[1], data[2], data[3], data[4], data[5],
                        Integer.parseInt(data[6]),Gender.valueOf(data[7]), Double.parseDouble(data[8]), Double.parseDouble(data[9]), data[10]));
            }

            return FXPatientData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Doctor> getAllDoctors() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Doctor.txt");
            ArrayList<String[]> parseDoctorData = File.parseData(userData);

            ObservableList<Doctor> FXDoctorData = FXCollections.observableArrayList();

            for (String[] data : parseDoctorData) {
                FXDoctorData.add(new Doctor(data[0], data[1], data[2], data[3], data[4], data[5],
                        Integer.parseInt(data[6]), Gender.valueOf(data[7]), Integer.parseInt(data[8]), data[9], data[10], data[11]));
            }

            return FXDoctorData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Admin> getAllAdmins() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Admin.txt");
            ArrayList<String[]> parseAdminData = File.parseData(userData);

            ObservableList<Admin> FXAdminData = FXCollections.observableArrayList();

            for (String[] data : parseAdminData) {
                FXAdminData.add(new Admin(data[0], data[1], data[2]));
            }

            return FXAdminData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateUser(String path, String[] data) {
        String userID = data[0];
        System.out.println(data);

        try {
            ArrayList<String> userData = File.readFile(path);
            ArrayList<String[]> toBeUpdatedUserData = File.parseData(userData);

            for (int i = 0; i < toBeUpdatedUserData.size(); i++) {
                String[] dataArray = toBeUpdatedUserData.get(i);
                if (userID.equals(dataArray[0])) {
                    dataArray = data;
                }
                toBeUpdatedUserData.set(i, dataArray);
            }
            File.updateFile(path, toBeUpdatedUserData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        //addPatient("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test");
    }
}

