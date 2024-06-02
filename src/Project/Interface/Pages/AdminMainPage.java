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

    private VBox doctor;
    private Label doctorLabel;
    private HBox doctorContainer;
    private Button addDoctorBtn;
    private Button scheduleBtn;

    public AdminMainPage() {
        adminMainPage = new GridPane();
        adminMainPage.setHgap(15);
        adminMainPage.setVgap(20);
        adminMainPage.setPadding(new Insets(40, 10, 10, 10));
        adminMainPage.setAlignment(Pos.TOP_CENTER);
        adminMainPage.getStylesheets().add("/Project/Interface/Assets/Styles/AdminMainPage.css");

        userAcc = new VBox();
        userAcc.getStyleClass().add("vbox");
        userAcc.setPrefHeight(120);
        userAcc.setPrefWidth(280);

        userAccLabel = new Label("User Account Management");

        userAccContainer = new HBox();

        patientBtn = new Button("Patients");
        patientBtn.setPrefHeight(30);
        patientBtn.setPrefWidth(75);

        patientBtn.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new ViewPatientList(new AdminMainPage().getAdminMainPage()).getTable());
        });

        doctorBtn = new Button("Doctors");
        doctorBtn.setPrefHeight(30);
        doctorBtn.setPrefWidth(75);

        userAccContainer.setAlignment(Pos.CENTER);
        userAccContainer.setSpacing(10);
        userAccContainer.getChildren().addAll(patientBtn, doctorBtn);
        userAcc.getChildren().addAll(userAccLabel, userAccContainer);


        appointment = new VBox();
        appointment.setPrefHeight(120);
        appointment.setPrefWidth(280);

        appointmentLabel = new Label("Appointment Management");

        appointmentContainer = new HBox();

        addAppointmentBtn = new Button("Add");
        addAppointmentBtn.setPrefHeight(30);
        addAppointmentBtn.setPrefWidth(75);

        approveAppointmentBtn = new Button("Approve");
        approveAppointmentBtn.setPrefHeight(30);
        approveAppointmentBtn.setPrefWidth(75);

        appointmentContainer.setAlignment(Pos.CENTER);
        appointmentContainer.setSpacing(10);
        appointmentContainer.getChildren().addAll(addAppointmentBtn, approveAppointmentBtn);
        appointment.getChildren().addAll(appointmentLabel, appointmentContainer);


        medicalRecord = new VBox();
        medicalRecord.setPrefHeight(120);
        medicalRecord.setPrefWidth(280);

        medicalRecordLabel = new Label("Medical Record Management");

        medicalRecordContainer = new HBox();

        updateMedicalRecordBtn = new Button("Update");
        updateMedicalRecordBtn.setPrefHeight(30);
        updateMedicalRecordBtn.setPrefWidth(75);

        medicalRecordContainer.setAlignment(Pos.CENTER);
        medicalRecordContainer.setSpacing(10);
        medicalRecordContainer.getChildren().addAll(updateMedicalRecordBtn);
        medicalRecord.getChildren().addAll(medicalRecordLabel, medicalRecordContainer);


        paymentRecord = new VBox();
        paymentRecord.setPrefHeight(120);
        paymentRecord.setPrefWidth(280);

        paymentRecordLabel = new Label("Payment Record Management");

        paymentRecordContainer = new HBox();

        viewPaymentRecordBtn = new Button("View");
        viewPaymentRecordBtn.setPrefHeight(30);
        viewPaymentRecordBtn.setPrefWidth(75);

        paymentRecordContainer.setAlignment(Pos.CENTER);
        paymentRecordContainer.setSpacing(10);
        paymentRecordContainer.getChildren().addAll(viewPaymentRecordBtn);
        paymentRecord.getChildren().addAll(paymentRecordLabel, paymentRecordContainer);


//        doctor = new VBox();
//        doctor.setPrefHeight(120);
//        doctor.setPrefWidth(280);
//
//        doctorLabel = new Label("Doctor Management");
//
//        doctorContainer = new HBox();
//
//        addDoctorBtn = new Button("Add");
//        addDoctorBtn.setPrefHeight(30);
//        addDoctorBtn.setPrefWidth(75);
//
//        scheduleBtn = new Button("Schedule");
//        scheduleBtn.setPrefHeight(30);
//        scheduleBtn.setPrefWidth(75);
//
//        doctorContainer.setAlignment(Pos.CENTER);
//        doctorContainer.setSpacing(10);
//        doctorContainer.getChildren().addAll(addDoctorBtn, scheduleBtn);
//        doctor.getChildren().addAll(doctorLabel, doctorContainer);


        adminMainPage.add(userAcc, 0, 0);
        adminMainPage.add(appointment, 1, 0);
        adminMainPage.add(medicalRecord, 0, 1);
        adminMainPage.add(paymentRecord, 1, 1);
    }
    public GridPane getAdminMainPage() {
        return adminMainPage;
    }

}


