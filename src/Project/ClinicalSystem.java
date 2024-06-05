package Project;

import Project.Interface.Layout;
import Project.Interface.Pages.*;

import Project.Controller.userDataManager;
import Project.Interface.Pages.Components.*;
import Project.Scheduler.Appointment;
import Project.Scheduler.Scheduler;
import Project.Scheduler.Schedule;
import Project.Users.*;
import Project.Records.MedicalRecord;
import Project.Records.Recorder;
import Project.Scheduler.Scheduler;
import Project.Utilities.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ClinicalSystem {
    private static Layout layout;
    private static boolean loggedIn = false;
    private static int role = 0;
    public static void login(String username, String password) {
        //TODO validation
        User user = userDataManager.getUser(username, password);
        if (user != null) {
            Notification.information("Login Successful");
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                System.out.println(patient.getGender());
                layout.setContent(new Home().getHome());
                layout.setHeaderPopUp(new PopUpPatient());
                role = 1;
            } else if (user instanceof Doctor) {
                Doctor doctor = (Doctor) user;
                System.out.println(doctor.getPosition());
                layout.setContent(new DoctorMainPage().getDoctorMainPage());
                layout.setHeaderPopUp(new PopUpDoctor());
                role = 2;
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                layout.setContent(new AdminMainPage().getAdminMainPage());
                layout.setHeaderPopUp(new PopUpAdmin());
                role = 3;
            }
            loggedIn = true;
            Notification.information("Login Successful");
        } else {
            Notification.error("Login Failed");
        }
    }

    public static void logout() {
        layout.setContent(new Home().getHome());
        layout.setHeaderPopUp(new PopUpDefault());
    }

    public static void register(int flag, String ...args) {
        if (flag == 1) {
            userDataManager.addPatient(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
        } else if (flag == 2) {
            //userDataManager.addAdmin();
        } else if (flag == 3) {
            //userDataManager.addDoctor();
        }
    }
    public static Layout getLayout() {
        if (layout == null) {
            layout = new Layout();
        }
        return layout;
    }

    public static ObservableList<Patient> getAllPatients() {
        ArrayList<String[]> patientData = userDataManager.getAllPatients();

        ObservableList<Patient> FXpatientData = FXCollections.observableArrayList();
        for (String[] data : patientData) {
            FXpatientData.add(new Patient(data[0], data[1], data[2], data[3], data[4], data[5],
                    Integer.parseInt(data[6]),Gender.valueOf(data[7]), Integer.parseInt(data[8]), Integer.parseInt(data[9])));
        }

        return FXpatientData;
    }
    public static void main(String[] args) {

    }
}
