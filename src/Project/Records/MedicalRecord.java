package Project.Records;
import Project.Scheduler.Appointment;

public class MedicalRecord {
    private String ID;
    private String PatientID;
    private String Issue;
    private String Prescription;
    private String FollowUpDate;
    private Appointment pastAppointment;

    public MedicalRecord(String ID, String PatientID, String Issue, String prescription, String followUpDate, Appointment pastAppointment) {
        this.ID = ID;
        this.PatientID = PatientID;
        this.Issue = Issue;
        this.Prescription = prescription;
        this.FollowUpDate = followUpDate;
        this.pastAppointment = pastAppointment;
    }

    public String getID() {
        return ID;
    }

    public String getPatientID() {
        return PatientID;
    }

    public String getIssue() {
        return Issue;
    }

    public String getPrescription() {
        return Prescription;
    }

    public String getFollowUpDate() {
        return FollowUpDate;
    }

    public Appointment getPastAppointment() {
        return pastAppointment;
    }

    public void setIssue(String Issue) {
        this.Issue = Issue;
    }

    public void setPrescription(String prescription) {
        this.Prescription = prescription;
    }

    public void setFollowUpDate(String followUpDate) {
        this.FollowUpDate = followUpDate;
    }

    public void setPastAppointment(Appointment pastAppointment) {
        this.pastAppointment = pastAppointment;
    }
}

