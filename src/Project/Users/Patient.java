package Project.Users;

public class Patient extends User {
    private String patientName;
    public Patient(String username, String password, String patientName) {
        super(username, password);
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
