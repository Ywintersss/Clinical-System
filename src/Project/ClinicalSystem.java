package Project;

import Project.Controller.userDataManager;
import Project.Scheduler.Appointment;
import Project.Scheduler.Schedule;
import Project.Users.Doctor;
import Project.Users.Gender;
import Project.Users.Patient;
import Project.Users.User;
import Project.Records.MedicalRecord;
import Project.Scheduler.Scheduler;
import Project.Utilities.File;

import javax.print.Doc;
import java.io.IOException;
public class ClinicalSystem {
    public static User login(String username, String password) {
        //TODO validation
        User user = userDataManager.getUser(username, password);
        if (user != null) {
            if (user instanceof Patient) {
                Patient patient = (Patient) user;
                System.out.println(patient.getGender());
                return patient;
            } else if (user instanceof Doctor) {
                Doctor doctor = (Doctor) user;
                System.out.println(doctor.getPosition());
                return doctor;
            }
        }
        return null;
    }

    public static void register(String username, String password) {
        //
        return;
    }
    public static void main(String[] args) {
        User user = login("Username1", "Password1");

        System.out.println(user);

        Doctor TTJ = new Doctor("Bloople", "password", "TTJ", "TTJ@gmail", "012-111 8888", 12, Gender.MALE, "", 10, "Cardiology", "Doctor");
        Schedule TTJschedule = TTJ.getSchedule();
        Patient patient = new Patient("password", "Shawn", "Shawn@gmail", "012-111 8888", "12", 12, Gender.MALE, "", 134, 40);

        Scheduler.makeAppointment(TTJ, patient, "description");

        System.out.println(TTJ.getSchedule().getAppointments().get(0));
        Scheduler.cancelAppointment(TTJ, patient, TTJschedule.getAppointments().get(0));

        System.out.println(TTJ.getSchedule().getAppointments());

    }
}
