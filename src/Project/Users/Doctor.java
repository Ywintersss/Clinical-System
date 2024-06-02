package Project.Users;

import Project.Records.MedicalRecord;
import Project.Scheduler.Appointment;
import Project.Records.MedicalRecord;
import Project.Scheduler.Schedule;

public class Doctor extends User {
    private int yearsOfExperience = 10;
    private String specialization;
    private String position;
    private Schedule schedule;
    public Doctor(String username, String password, String name, String email, String phoneNo, int age, Gender gender, int yearsOfExperience, String specialization, String position) {
        super(username, password, name, email, phoneNo, age, gender);
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
        this.position = position;
        // Initialize the doctor's schedule
        this.schedule = new Schedule();
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPosition() {
        return position;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public MedicalRecord writeMedicalRecord(String Issue, String prescription, String followUpDate, Appointment appointment) {
        MedicalRecord medicalRecord = new MedicalRecord(Issue, prescription, followUpDate, appointment);
        return medicalRecord;
    }
}
