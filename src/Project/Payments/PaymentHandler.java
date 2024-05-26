package Project.Payments;

import Project.Users.Patient;

import java.time.LocalDateTime;

public class PaymentHandler {
    public static void makePayment (String paymentID, double amount, Patient patient, PaymentMethod paymentMethod, LocalDateTime date){
        Payment payment = new Payment(paymentID, amount, patient, paymentMethod,date);

        // write into PaymentHistory.txt
    }


}
