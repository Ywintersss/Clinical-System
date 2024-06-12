package Project.Payments;

import Project.Users.Patient;
import Project.Utilities.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentHandler {
    public static void makePayment (String paymentID,  String patientID, String amount, PaymentMethod paymentMethod, String date){
        Payment payment = new Payment(paymentID, patientID,  amount, paymentMethod, date);

        // write into PaymentHistory.txt
    }

    public static ObservableList<Payment> getAllPaymentHistory() {
        try {
            ArrayList<String> userData = File.readFile("\\payments\\PaymentHistory.txt");
            ArrayList<String[]> parsePaymentData = File.parseData(userData);

            ObservableList<Payment> FXPaymentData = FXCollections.observableArrayList();

            for (String[] data : parsePaymentData) {
                FXPaymentData.add(new Payment(data[0], data[1], data[2], PaymentMethod.valueOf(data[3]), data[4]));
            }

            return FXPaymentData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
