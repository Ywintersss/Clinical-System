package Project.Users;

public class Doctor extends User {
    private int yearsOfExperience;
    private String specialization;
    private String position;
    private int consultationFee;
    public Doctor(String ID, String username, String password, String name, String email, String phoneNo,
                  int age, Gender gender, int yearsOfExperience, String specialization, String position, int consultationFee) {
        super(ID, username, password, name, email, phoneNo, age, gender);
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
        this.position = position;
        this.consultationFee = consultationFee;
        // Initialize the doctor's schedule
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getPosition() {
        return position;
    }

    public int getConsultationFee() {
        return consultationFee;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setConsultationFee(int consultationFee) {
        this.consultationFee = consultationFee;
    }
}
