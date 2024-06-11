package Project.Payments;

import Project.Users.Patient;
import java.time.LocalDateTime;

public class Payment {
    private String paymentID;
    private String patientID;
    private String amount;
    private PaymentMethod paymentMethod;
    private String date;

    public Payment (String paymentID,  String patientID, String amount,PaymentMethod paymentMethod, String date) {
        this.paymentID = paymentID;
        this.patientID = patientID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public String getPaymentID () {return paymentID;}

    public String getAmount () {return amount;}

    public String getPatientID() {return patientID;}

    public PaymentMethod getPaymentMethod() {return paymentMethod;}

    public String getDate () {return date;}

    public void setAmount(String amount) {this.amount = amount;}

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDate(String date) {
        this.date = date;
    }



}

