package Project.Users;

import Project.Records.MedicalRecord;
import Project.Scheduler.Appointment;
import Project.Records.MedicalRecord;
import Project.Scheduler.Schedule;

import java.util.ArrayList;

public class Doctor extends User {
    private ArrayList<Schedule> schedules;
    private int yearsOfExperience;
    private String specialization;
    private String position;
    public Doctor(String ID, String username, String password, String name, String email, String phoneNo, int age, Gender gender, int yearsOfExperience, String specialization, String position) {
        super(ID, username, password, name, email, phoneNo, age, gender);
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
        this.position = position;
        // Initialize the doctor's schedule
        this.schedules = new ArrayList<>();
    }
    public ArrayList<Schedule> getScheduleID() {
        return schedules;
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

    @Override
    public String toString() {
        return getName();
    }

}
