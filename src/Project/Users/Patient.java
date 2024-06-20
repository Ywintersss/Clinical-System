package Project.Users;

import Project.Payments.Payment;
import Project.Scheduler.Appointment;
import Project.Records.MedicalRecord;
import java.util.ArrayList;

public class Patient extends User {
    private double height, weight;

    public Patient(String ID, String username, String password, String name, String email, String contact,
                   int age, Gender gender, double height, double weight) {
        super(ID, username, password, name, email, contact, age, gender);
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
