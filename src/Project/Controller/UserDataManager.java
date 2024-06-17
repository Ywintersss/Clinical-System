package Project.Controller;

import Project.Users.*;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 * <h3>UserDataManager class, a singleton class for controlling and interacting with the db and user data</h3>
 *
 *
 */
public class UserDataManager {
    private static UserDataManager instance;
    // private constructor so it can only be instantiated once through the class itself
    private UserDataManager() {}

    // instantiate the class if it doesn't exist already
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

        String data = File.formatData(userData);
        try {
            File.appendToFile(doctorPath, ID + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdmin(String ...userData) {
        String adminPath = "\\users\\Admin.txt";
        String ID = Utilities.generateID("ID", adminPath) + ",";

        String data = File.formatData(userData);
        try {
            File.appendToFile(adminPath, ID + data);
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
                                    Double.parseDouble(dataArray[8]), Double.parseDouble(dataArray[9]));
                        }
                        else if(file.contains("Doctor")){
                            return new Doctor(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5],
                                    Integer.parseInt(dataArray[6]), Gender.valueOf(dataArray[7]),
                                    Integer.parseInt(dataArray[8]), dataArray[9], dataArray[10]);
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


    // gets all stored Patient Data
    public ObservableList<Patient> getAllPatients() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Patient.txt");
            ArrayList<String[]> parsePatientData = File.parseData(userData);

            ObservableList<Patient> FXPatientData = FXCollections.observableArrayList();
            for (String[] data : parsePatientData) {
                FXPatientData.add(new Patient(data[0], data[1], data[2], data[3], data[4], data[5],
                        Integer.parseInt(data[6]),Gender.valueOf(data[7]), Double.parseDouble(data[8]), Double.parseDouble(data[9])));
            }

            //returns an observable list of patients for use in the UI
            return FXPatientData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // gets all stored Doctor Data
    public ObservableList<Doctor> getAllDoctors() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Doctor.txt");
            ArrayList<String[]> parseDoctorData = File.parseData(userData);

            ObservableList<Doctor> FXDoctorData = FXCollections.observableArrayList();

            for (String[] data : parseDoctorData) {
                FXDoctorData.add(new Doctor(data[0], data[1], data[2], data[3], data[4], data[5],
                        Integer.parseInt(data[6]), Gender.valueOf(data[7]), Integer.parseInt(data[8]), data[9], data[10]));
            }

            //returns an observable list of doctors for use in the UI
            return FXDoctorData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // gets all stored Admin Data
    public ObservableList<Admin> getAllAdmins() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Admin.txt");
            ArrayList<String[]> parseAdminData = File.parseData(userData);

            ObservableList<Admin> FXAdminData = FXCollections.observableArrayList();

            for (String[] data : parseAdminData) {
                FXAdminData.add(new Admin(data[0], data[1], data[2]));
            }

            //returns an observable list of admins for use in the UI
            return FXAdminData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // updates a specific user with new data
    public void updateUser(String path, String[] data) {
        //User's ID to identify which user to update
        String userID = data[0];

        try {
            ArrayList<String> userData = File.readFile(path);
            ArrayList<String[]> toBeUpdatedUserData = File.parseData(userData);

            for (int i = 0; i < toBeUpdatedUserData.size(); i++) {
                String[] dataArray = toBeUpdatedUserData.get(i);
                //check if ID matches
                if (userID.equals(dataArray[0])) {
                    //update old data with new data
                    dataArray = data;
                }
                //set new data
                toBeUpdatedUserData.set(i, dataArray);
            }
            File.updateFile(path, toBeUpdatedUserData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // deletes a user
    public void deleteUser(String path, String userID) {
        try {
            ArrayList<String> userData = File.readFile(path);
            ArrayList<String[]> toBeUpdatedDeleteData = File.parseData(userData);

            //removes the data
            toBeUpdatedDeleteData.removeIf(data -> data[0].equals(userID));

            //updates the file with the new data without the deleted data
            File.updateFile(path, toBeUpdatedDeleteData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

