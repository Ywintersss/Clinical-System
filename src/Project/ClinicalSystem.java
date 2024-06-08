package Project;

import Project.Interface.Layout;
import Project.Interface.Pages.*;


import Project.Interface.Pages.Components.*;
import Project.Scheduler.Appointment;
import Project.Scheduler.Scheduler;
import Project.Scheduler.Schedule;
import Project.Controller.UserDataManager;
import Project.Interface.Pages.Components.PopUpAdmin;
import Project.Interface.Pages.Components.PopUpDefault;
import Project.Interface.Pages.Components.PopUpDoctor;
import Project.Interface.Pages.Components.PopUpPatient;
import Project.Users.*;


public class ClinicalSystem {
    private static Layout layout;
    private static UserDataManager userDataManager = UserDataManager.getInstance();
    private static int role = 0;

    public static void login(String username, String password) {
        //TODO validation
        User user = userDataManager.getUser(username, password);
        if (user != null) {
            Notification.information("Login Successful");
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                layout.setContent(new Home().getHome());
                layout.setHeaderPopUp(new PopUpPatient());
                role = 1;
                System.out.println(((Patient) user).getWeight());
                UserSession.getInstance().setCurrentUser(patient);
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
            Notification.information("Login Successful");
        } else {
            Notification.error("Login Failed");
        }
    }

    public static void logout() {
        layout.setContent(new Home().getHome());
        layout.setHeaderPopUp(new PopUpDefault());
        UserSession.getInstance().clearSession();
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

    public static UserDataManager getUserDataManager() {
        return userDataManager;
    }

    public static void main(String[] args) {

    }
}
