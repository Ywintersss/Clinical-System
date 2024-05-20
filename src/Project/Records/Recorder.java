package Project.Records;
import Project.Scheduler.Appointment;
import Project.Utilities.File;
import Project.Users.Patient;

public class Recorder {

    public static void addRecord(Patient patient, String Issue, String prescription, String followUpDate, Appointment pastAppointment) {
        MedicalRecord medicalRecord = new MedicalRecord(Issue, prescription, followUpDate, pastAppointment);

        // write to txt file


        patient.addMedicalRecord(medicalRecord);
    }
}
