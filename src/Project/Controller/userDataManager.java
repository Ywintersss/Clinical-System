package Project.Controller;

import Project.Users.*;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import java.io.IOException;
import java.util.ArrayList;

public class userDataManager {
    // Add user to txt file
    public static void addPatient(String ...userData) {
        if (userData.length < 9) {
            System.out.println("less");
            return;
        }
        String path = "\\users\\Patient.txt";
        String ID = Utilities.generateID(path) + ",";
        String data = File.formatData(userData);
        try {
            File.writeToFile(path, ID + data, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addDoctor(String ...userData) {
        String path = "\\users\\Doctor.txt";
        String ID = Utilities.generateID(path) + ",";
        String data = File.formatData(userData);
        try {
            File.writeToFile(path, data, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addAdmin(String username, String password) {
        String data = File.formatData(username, password);
        try {
            File.writeToFile("Admin.txt",data, true);
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
    public static User getUser(String username, String password){
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
                            return new Admin(dataArray[1], dataArray[2]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<String[]> getAllPatients() {
        try {
            ArrayList<String> userData = File.readFile("\\users\\Patient.txt");
            return File.parseData(userData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        addPatient("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test");
    }
}

