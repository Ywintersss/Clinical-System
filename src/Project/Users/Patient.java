package Project.Users;

import Project.Payments.Payment;
import Project.Scheduler.Appointment;
import Project.Records.MedicalRecord;
import java.util.ArrayList;

public class Patient extends User {
    private double height, weight;
    private ArrayList<Appointment> appointments;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<Payment> paymentHistory;

    public Patient(String ID, String username, String password, String name, String email, String contact, int age, Gender gender, double height, double weight) {
        super(ID, username, password, name, email, contact, age, gender);
        this.height = height;
        this.weight = weight;
        this.appointments = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
        this.paymentHistory = new ArrayList<>();
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

    public void addAppointment(Appointment appointment) {
        this.appointments.add(appointment);
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void removeAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecords.add(medicalRecord);
    }

    public ArrayList<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public ArrayList<Payment> getPaymentHistory() {
        return paymentHistory;
    }

    public void removePaymentHistory(Payment payment) {
        this.paymentHistory.remove(payment);
    }

    public void addPaymentHistory(Payment payment) {
        this.paymentHistory.add(payment);
    }


}
