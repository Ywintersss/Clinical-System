package Project.Payments;

import Project.Users.Patient;

import java.time.LocalDateTime;

public class PaymentHandler {
    public static void makePayment (String paymentID,  String patientID, String amount, PaymentMethod paymentMethod, String date){
        Payment payment = new Payment(paymentID, patientID,  amount, paymentMethod, date);

        // write into PaymentHistory.txt
    }


}
