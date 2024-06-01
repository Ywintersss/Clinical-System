package Project.Payments;

import Project.Users.Patient;
import java.time.LocalDateTime;

public class Payment {
    private String paymentID;
    private double amount;
    private Patient patient;
    private PaymentMethod paymentMethod;
    private LocalDateTime date;

    public Payment (String paymentID, double amount, Patient patient, PaymentMethod paymentMethod,LocalDateTime date) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.patient = patient;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public String getPaymentID () {return paymentID;}

    public double getAmount () {return amount;}

    public Patient getPatient() {return patient;}

    public PaymentMethod getPaymentMethod() {return paymentMethod;}

    public LocalDateTime getDate () {return date;}


    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setAmount(double amount) {this.amount = amount;}

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }



}

