package Project.Payments;

import Project.Scheduler.Appointment;
import Project.Users.Patient;
import Project.Utilities.File;
import Project.Utilities.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentHandler {
    private static PaymentHandler instance;
    private PaymentHandler() {}
    public static PaymentHandler getInstance() {
        if(instance == null) {
            instance = new PaymentHandler();
        }
        return instance;
    }
    public void makePayment (String appointmentID, String... userData) {
        String path = "\\payments\\PaymentHistory.txt";
        String appointmentPath = "\\schedules\\appointments.txt";

        String paymentID = Utilities.generateID("PH", path) + ",";

        // write into PaymentHistory.txt
        String data = File.formatData(userData);
        try {
            ArrayList<String[]> parseAppointmentData = File.parseData(File.readFile(appointmentPath));
            for (String[] appointmentData : parseAppointmentData) {
                if (appointmentData[0].equals(appointmentID)) {
                    appointmentData[5] = "Paid";
                }
            }
            File.updateFile(appointmentPath, parseAppointmentData);

            File.appendToFile(path, paymentID + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public ObservableList<Payment> getAllPaymentHistory() {
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

    public ObservableList<Payment> getPatientPaymentHistory(String patientID) {
        ObservableList<Payment> paymentList = getAllPaymentHistory();

        paymentList.removeIf(payment -> !payment.getPatientID().equals(patientID));

        return paymentList;
    }

    public void removePayment(String paymentID) {
        try {
            ArrayList<String> oldPayment = File.readFile("\\payments\\PaymentHistory.txt");
            ArrayList<String[]> oldPaymentArray = File.parseData(oldPayment);

            oldPaymentArray.removeIf(data -> data[0].equals(paymentID));

            File.updateFile("\\payments\\PaymentHistory.txt", oldPaymentArray);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
