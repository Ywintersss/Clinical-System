package Project.Users;

import Project.Records.MedicalRecord;
import Project.Scheduler.Appointment;
import Project.Records.MedicalRecord;
import Project.Scheduler.Schedule;

import java.util.ArrayList;

public class Doctor extends User {
    private Schedule schedules;
    private String scheduleID;
    private int yearsOfExperience;
    private String specialization;
    private String position;
    public Doctor(String ID, String username, String password, String name, String email, String phoneNo,
                  int age, Gender gender, int yearsOfExperience, String specialization, String position, String scheduleID) {
        super(ID, username, password, name, email, phoneNo, age, gender);
        this.yearsOfExperience = yearsOfExperience;
        this.specialization = specialization;
        this.position = position;
        this.scheduleID = scheduleID;
        // Initialize the doctor's schedule
        this.schedules = new Schedule();
    }
    public Schedule getSchedules() {
        return schedules;
    }

    public String getScheduleID() {
        return scheduleID;
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
