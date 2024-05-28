package Project.Controller;

import Project.Users.Gender;
import Project.Users.Patient;
import Project.Users.Doctor;
import Project.Users.User;
import Project.Utilities.File;

import java.io.IOException;
import java.util.ArrayList;

public class userDataManager {
    // Add user to txt file
    public static void addPatient(String username, String password, String name, String email, String phoneNo,  String age, String gender, String image) {
        String data = File.formatData(username, password, name, email, phoneNo, age, gender, image);
        try {
            File.writeToFile("Patient.txt", data, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addDoctor(String username, String password,String name, String email, String phoneNo,  String age, String gender, String image,
                          String years, String specialization, String position, String schedule) {
        String data = File.formatData(username, password, name, email, phoneNo, age, gender, image,
                                    years, specialization, position, schedule);
        try {
            File.writeToFile("Doctors.txt", data, true);
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
    public static User getUser(String username, String password) {
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
                            return new Patient(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5],
                                    Integer.parseInt(dataArray[6]), Gender.valueOf(dataArray[7]), dataArray[8],
                                    Double.parseDouble(dataArray[9]), Double.parseDouble(dataArray[10]));
                        }
                        else if(file.contains("Doctor")){
                            return new Doctor(dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5],
                                    Integer.parseInt(dataArray[6]), Gender.valueOf(dataArray[7]), dataArray[8],
                                    Integer.parseInt(dataArray[9]), dataArray[10], dataArray[11]);
                        }
                        System.out.println(file + " OK");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {


    }
}

