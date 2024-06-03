package Project.Interface.Pages;

import Project.ClinicalSystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AdminMainPage {
    private GridPane adminMainPage;

    private VBox userAcc;
    private Label userAccLabel;
    private HBox userAccContainer;
    private Button patientBtn;
    private Button doctorBtn;
    private Button adminBtn;

    private VBox appointment;
    private Label appointmentLabel;
    private HBox appointmentContainer;
    private Button addAppointmentBtn;
    private Button approveAppointmentBtn;

    private VBox medicalRecord;
    private Label medicalRecordLabel;
    private HBox medicalRecordContainer;
    private Button updateMedicalRecordBtn;

    private VBox paymentRecord;
    private Label paymentRecordLabel;
    private HBox paymentRecordContainer;
    private Button viewPaymentRecordBtn;

    public AdminMainPage() {
        adminMainPage = new GridPane();
        adminMainPage.setHgap(25);
        adminMainPage.setVgap(35);
        adminMainPage.setPadding(new Insets(50, 10, 10, 10));
        adminMainPage.setAlignment(Pos.TOP_CENTER);
        adminMainPage.getStylesheets().add("/Project/Interface/Assets/Styles/AdminMainPage.css");

        userAcc = new VBox();
        userAcc.getStyleClass().add("vbox");
        userAcc.setPrefHeight(140);
        userAcc.setPrefWidth(300);

        userAccLabel = new Label("User Account Management");

        userAccContainer = new HBox();
        userAccContainer.setPadding(new Insets(15, 0, 0, 0));

        patientBtn = new Button("Patients");
        patientBtn.setPrefHeight(30);
        patientBtn.setPrefWidth(85);

        patientBtn.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new ViewPatientList(new AdminMainPage().getAdminMainPage()).getTable());
        });

        doctorBtn = new Button("Doctors");
        doctorBtn.setPrefHeight(30);
        doctorBtn.setPrefWidth(85);

        adminBtn = new Button("Admins");
        adminBtn.setPrefHeight(30);
        adminBtn.setPrefWidth(85);

        userAccContainer.setAlignment(Pos.CENTER);
        userAccContainer.setSpacing(10);
        userAccContainer.getChildren().addAll(patientBtn, doctorBtn, adminBtn);
        userAcc.getChildren().addAll(userAccLabel, userAccContainer);


        appointment = new VBox();
        appointment.setPrefHeight(140);
        appointment.setPrefWidth(300);

        appointmentLabel = new Label("Appointment Management");

        appointmentContainer = new HBox();
        appointmentContainer.setPadding(new Insets(15, 0, 0, 0));

        addAppointmentBtn = new Button("Add");
        addAppointmentBtn.setPrefHeight(30);
        addAppointmentBtn.setPrefWidth(85);

        approveAppointmentBtn = new Button("Approve");
        approveAppointmentBtn.setPrefHeight(30);
        approveAppointmentBtn.setPrefWidth(85);

        appointmentContainer.setAlignment(Pos.CENTER);
        appointmentContainer.setSpacing(10);
        appointmentContainer.getChildren().addAll(addAppointmentBtn, approveAppointmentBtn);
        appointment.getChildren().addAll(appointmentLabel, appointmentContainer);


        medicalRecord = new VBox();
        medicalRecord.setPrefHeight(140);
        medicalRecord.setPrefWidth(300);

        medicalRecordLabel = new Label("Medical Record Management");

        medicalRecordContainer = new HBox();
        medicalRecordContainer.setPadding(new Insets(15, 0, 0, 0));

        updateMedicalRecordBtn = new Button("Update");
        updateMedicalRecordBtn.setPrefHeight(30);
        updateMedicalRecordBtn.setPrefWidth(85);

        medicalRecordContainer.setAlignment(Pos.CENTER);
        medicalRecordContainer.setSpacing(10);
        medicalRecordContainer.getChildren().addAll(updateMedicalRecordBtn);
        medicalRecord.getChildren().addAll(medicalRecordLabel, medicalRecordContainer);


        paymentRecord = new VBox();
        paymentRecord.setPrefHeight(140);
        paymentRecord.setPrefWidth(300);

        paymentRecordLabel = new Label("Payment Record Management");

        paymentRecordContainer = new HBox();
        paymentRecordContainer.setPadding(new Insets(15, 0, 0, 0));

        viewPaymentRecordBtn = new Button("View");
        viewPaymentRecordBtn.setPrefHeight(30);
        viewPaymentRecordBtn.setPrefWidth(85);

        paymentRecordContainer.setAlignment(Pos.CENTER);
        paymentRecordContainer.setSpacing(10);
        paymentRecordContainer.getChildren().addAll(viewPaymentRecordBtn);
        paymentRecord.getChildren().addAll(paymentRecordLabel, paymentRecordContainer);

        adminMainPage.add(userAcc, 0, 0);
        adminMainPage.add(appointment, 1, 0);
        adminMainPage.add(medicalRecord, 0, 1);
        adminMainPage.add(paymentRecord, 1, 1);
    }
    public GridPane getAdminMainPage() {
        return adminMainPage;
    }

}


