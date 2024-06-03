package Project;

import Project.Interface.Layout;
import Project.Interface.Pages.*;

import Project.Controller.userDataManager;
import Project.Interface.Pages.Components.PopUpAdmin;
import Project.Interface.Pages.Components.PopUpDefault;
import Project.Interface.Pages.Components.PopUpDoctor;
import Project.Interface.Pages.Components.PopUpPatient;
import Project.Scheduler.Appointment;
import Project.Scheduler.Schedule;
import Project.Users.*;
import Project.Records.MedicalRecord;
import Project.Records.Recorder;
import Project.Scheduler.Scheduler;
import Project.Utilities.File;


public class ClinicalSystem {
    private static Layout layout;
    private static boolean loggedIn = false;
    public static void login(String username, String password) {
        //TODO validation
        User user = userDataManager.getUser(username, password);
        if (user != null) {
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                System.out.println(patient.getGender());
                layout.setContent(new Home().getHome());
                layout.setHeaderPopUp(new PopUpPatient());
            } else if (user instanceof Doctor) {
                Doctor doctor = (Doctor) user;
                System.out.println(doctor.getPosition());
                layout.setContent(new DoctorMainPage().getDoctorMainPage());
                layout.setHeaderPopUp(new PopUpDoctor());
            } else if (user instanceof Admin) {
                Admin admin = (Admin) user;
                layout.setContent(new AdminMainPage().getAdminMainPage());
                layout.setHeaderPopUp(new PopUpAdmin());
            }
            loggedIn = true;
        }
    }

    public static void logout() {
        layout.setContent(new Home().getHome());
        layout.setHeaderPopUp(new PopUpDefault());
    }

    public static void register(String username, String password) {
        //
        return;
    }
    public static Layout getLayout() {
        if (layout == null) {
            layout = new Layout();
        }
        return layout;
    }
    public static void main(String[] args) {
        login("Username1", "Password1");

        Doctor TTJ = new Doctor("Bloople", "password", "TTJ", "TTJ@gmail", "012-111 8888", 12, Gender.MALE, 10, "Cardiology", "Doctor");
        Schedule TTJschedule = TTJ.getSchedule();
        Patient patient = new Patient("wynter", "password", "Shawn", "Shawn@gmail", "012-111 8888", 12, Gender.MALE, 134, 40);

        Scheduler.makeAppointment(TTJ, patient, "description");

        System.out.println("2" + TTJ.getSchedule().getAppointments().get(0));
        Scheduler.cancelAppointment(TTJ, patient, TTJschedule.getAppointments().get(0));

        //System.out.println(TTJ.getSchedule().getAppointments());
        Scheduler.makeAppointment(TTJ, patient, "description");
        Appointment appointments = TTJ.getSchedule().getAppointments().get(0);
        //Recorder.addRecord(patient, "Issue", "prescription", "followUpDate", appointments);
        Recorder.removeRecord(patient, new MedicalRecord("Issue", "prescription", "followUpDate", appointments));

    }
}
