package Project.Records;
import Project.Scheduler.Appointment;

public class MedicalRecord {
    private String ID;
    private String PatientID;
    private String Issue;
    private String Description;
    private String Prescription;
    private String FollowUpDate;

    public MedicalRecord(String ID, String PatientID, String Issue, String Description, String prescription, String followUpDate) {
        this.ID = ID;
        this.PatientID = PatientID;
        this.Issue = Issue;
        this.Description = Description;
        this.Prescription = prescription;
        this.FollowUpDate = followUpDate;
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

    public String getDescription() {
        return Description;
    }

    public String getPrescription() {
        return Prescription;
    }

    public String getFollowUpDate() {
        return FollowUpDate;
    }


    public void setIssue(String Issue) {
        this.Issue = Issue;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setPrescription(String prescription) {
        this.Prescription = prescription;
    }

    public void setFollowUpDate(String followUpDate) {
        this.FollowUpDate = followUpDate;
    }
}

