package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.DetailView;
import Project.Payments.*;
import Project.Scheduler.Appointment;
import Project.Scheduler.AppointmentDetail;
import Project.Users.Patient;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Objects;

public class AddPaymentRecord extends DetailView{
    private ObservableList<Patient> patients;
    private ObservableList<AppointmentDetail> appointmentDetails;
    private ComboBox<String> patientID;
    private ComboBox<AppointmentDetail> patientAppointment;
    private TextField consultation;
    private TextField others;
    private ComboBox<String> paymentMethod;
    private Button save;


    public AddPaymentRecord() {
        super("Add Payment Record");

        patients = ClinicalSystem.getUserDataManager().getAllPatients();
        appointmentDetails = ClinicalSystem.getScheduler().getAllAppointmentDetails();

        patientID = new ComboBox<String>();
        patientID.setPromptText("Select Patient ID.");

        for (Patient patient : patients) {
            patientID.getItems().add(patient.getID());
        }

        patientAppointment = new ComboBox<AppointmentDetail>();
        patientAppointment.setOnMouseClicked(e -> {
            patientAppointment.getItems().clear();
            if (patientID.getValue() == null) {
                Notification.information("Please select a patient first.");
                return;
            }

            for (AppointmentDetail appointmentDetail : appointmentDetails) {
                if (appointmentDetail.getAppointment().getPatientID().equals(patientID.getValue()) && appointmentDetail.getAppointment().getIsPaid().equals("Unpaid")) {
                    patientAppointment.getItems().add(appointmentDetail);
                }
            }
        });

        patientAppointment.setOnAction(e -> {
            if (patientID.getValue() == null) {
                Notification.information("Please select a patient first.");
                return;
            }

            if (patientAppointment.getValue() == null) {
                consultation.setText("");
                return;
            }

            consultation.setText(Integer.toString(patientAppointment.getValue().getDoctor().getConsultationFee()));
        });

        addSelectionContainer("Patient ID", patientID);

        addSelectionContainer("Appointment", patientAppointment);

        consultation = new TextField();
        addContent("Consultation", consultation);


        others = new TextField();
        others.setPromptText("RM250");
        others.setText("0");

        addContent("Others", others);

        paymentMethod = new ComboBox<>();
        paymentMethod.setPromptText("Select Payment Method");
        paymentMethod.getItems().addAll("PHYSICAL", "EWALLET", "CARD", "BANKTRANSFER");
        addSelectionContainer("Payment Method", paymentMethod);


        save = new Button("Save");
        save.setPrefHeight(40);
        save.setPrefWidth(100);

        save.setOnAction(e ->{
            if (paymentMethod.getValue() == null) {
                Notification.information("Please select a payment method.");
                return;
            }

            if (Objects.equals(others.getText(), "")) {
                others.setText("0");
            }

            ArrayList<String> data = getInputData();
            System.out.println(data);

            String patientID = data.get(0);
            String appointmentID = patientAppointment.getValue().getAppointment().getAppointmentID();
            String amount = "RM" + (Integer.parseInt(data.get(2)) + Integer.parseInt(data.get(3)));
            String paymentMethod = data.get(4);
            String date = Utilities.getCurrentDate()+" "+Utilities.getCurrentTime();

            try {
                ClinicalSystem.getPaymentHandler().makePayment(appointmentID, patientID, amount, paymentMethod, date);
                Notification.information("Payment Record Added");

                ClinicalSystem.back();
                ClinicalSystem.refresh(new ViewPaymentRecord().getTable());
            } catch (Exception ex) {
                Notification.error("Failed to Add Payment Record");
            }


        });

        addButtonIntoContainer(save);
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

