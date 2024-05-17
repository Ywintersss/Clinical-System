package Project.Controller;

import Project.Users.Patient;
import Project.Users.Doctor;
import Project.Utilities.File;

import java.io.IOException;
import java.util.ArrayList;

public class userDataManager {
    // Add user to txt file
    public void addPatient(String name, String email, String phoneNo, String username, String password, String age, String gender, String image) {
        String data = File.formatData(name, email, phoneNo, username, password, age, gender, image);
        try {
            File.writeToFile("Patient.txt",data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addDoctor(String name, String email, String phoneNo, String username, String password, String age, String gender, String image,
                          String years, String specialization, String position, String schedule) {
        String data = File.formatData(name, email, phoneNo, username, password, age, gender, image,
                                    years, specialization, position, schedule);
        try {
            File.writeToFile("Doctors.txt",data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addAdmin(String username, String password) {
        String data = File.formatData(username, password);
        try {
            File.writeToFile("Admin.txt",data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read and Gets user from txt file with username and password
    public<T> T getUser(String username, String password) {
        try {
            ArrayList<String> userData = File.readFile("src\\db\\Doctors.txt");
            ArrayList<String[]> parseUserData = File.parseData(userData);
            for (String[] dataArray: parseUserData ){
                if (username.equals(dataArray[1]) && password.equals(dataArray[2])) {
                    System.out.println("OK");
                }
            }
        } catch(IOException e){
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        userDataManager user1= new userDataManager();
        user1.getUser("Kelly","11");
        user1.addPatient("Erison","elon@gmail.com","012-111 1010","elon","1234","14","male","image");
        user1.addDoctor("Erison","elon@gmail.com","012-111 1010","elon","1234","14","male","image",
                            "11", "hearts","Assistant","10am-7pm");
        user1.addAdmin("Ryan","1234");
    }

}

