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

    private VBox medicalRecord;
    private Label medicalRecordLabel;
    private HBox medicalRecordContainer;
    private Button viewMedicalRecordBtn;

    private VBox paymentRecord;
    private Label paymentRecordLabel;
    private HBox paymentRecordContainer;
    private Button viewPaymentRecordBtn;

    private VBox feedBack;
    private Label feedBackLabel;
    private HBox feedBackContainer;
    private Button viewFeedBackBtn;

    public AdminMainPage() {
        adminMainPage = new GridPane();
        adminMainPage.setHgap(25);
        adminMainPage.setVgap(35);
        adminMainPage.setPadding(new Insets(50, 10, 10, 10));
        adminMainPage.setAlignment(Pos.TOP_CENTER);
        adminMainPage.getStylesheets().add("/Project/Interface/Assets/Styles/AdminMainPage.css");

        userAcc = new VBox();
        //userAcc.getStyleClass().add("vbox");
        userAcc.setPrefHeight(140);
        userAcc.setPrefWidth(300);

        userAccLabel = new Label("User Account Management");

        userAccContainer = new HBox();
        userAccContainer.setPadding(new Insets(15, 0, 0, 0));

        patientBtn = new Button("Patients");
        patientBtn.setPrefHeight(30);
        patientBtn.setPrefWidth(100);

        patientBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new ViewPatientList(1).getTable());
        });

        doctorBtn = new Button("Doctors");
        doctorBtn.setPrefHeight(30);
        doctorBtn.setPrefWidth(100);

        doctorBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new ViewDoctorList().getTable());
        });

        adminBtn = new Button("Admins");
        adminBtn.setPrefHeight(30);
        adminBtn.setPrefWidth(100);

        adminBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new ViewAdminList().getTable());
        });

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

        addAppointmentBtn = new Button("Add/Cancel");
        addAppointmentBtn.setPrefHeight(30);
        addAppointmentBtn.setPrefWidth(130);

        addAppointmentBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new AppointmentList(1, "Appointments").getTable());
        });

        appointmentContainer.setAlignment(Pos.CENTER);
        appointmentContainer.setSpacing(10);
        appointmentContainer.getChildren().addAll(addAppointmentBtn);

        appointment.getChildren().addAll(appointmentLabel, appointmentContainer);


        medicalRecord = new VBox();
        medicalRecord.setPrefHeight(140);
        medicalRecord.setPrefWidth(300);

        medicalRecordLabel = new Label("Medical Record Management");

        medicalRecordContainer = new HBox();
        medicalRecordContainer.setPadding(new Insets(15, 0, 0, 0));

        viewMedicalRecordBtn = new Button("Add");
        viewMedicalRecordBtn.setPrefHeight(30);
        viewMedicalRecordBtn.setPrefWidth(100);

        viewMedicalRecordBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new ViewPatientList(2).getTable());
        });

        medicalRecordContainer.setAlignment(Pos.CENTER);
        medicalRecordContainer.setSpacing(10);
        medicalRecordContainer.getChildren().addAll(viewMedicalRecordBtn);
        medicalRecord.getChildren().addAll(medicalRecordLabel, medicalRecordContainer);

        paymentRecord = new VBox();
        paymentRecord.setPrefHeight(140);
        paymentRecord.setPrefWidth(300);

        paymentRecordLabel = new Label("Payment Record Management");

        paymentRecordContainer = new HBox();
        paymentRecordContainer.setPadding(new Insets(15, 0, 0, 0));

        viewPaymentRecordBtn = new Button("Add");
        viewPaymentRecordBtn.setPrefHeight(30);
        viewPaymentRecordBtn.setPrefWidth(100);

        viewPaymentRecordBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new ViewPaymentRecord().getTable());
        });

        paymentRecordContainer.setAlignment(Pos.CENTER);
        paymentRecordContainer.setSpacing(10);
        paymentRecordContainer.getChildren().addAll(viewPaymentRecordBtn);
        paymentRecord.getChildren().addAll(paymentRecordLabel, paymentRecordContainer);

        feedBack = new VBox();
        feedBack.setPrefHeight(140);
        feedBack.setPrefWidth(300);

        feedBackLabel = new Label("Feedback Management");

        feedBackContainer = new HBox();
        feedBackContainer.setPadding(new Insets(15, 0, 0, 0));

        viewFeedBackBtn = new Button("Add");
        viewFeedBackBtn.setPrefHeight(30);
        viewFeedBackBtn.setPrefWidth(100);

        viewFeedBackBtn.setOnAction(e -> {
            ClinicalSystem.navigateTo(new ViewFeedBack().getTable());
        });

        feedBackContainer.setAlignment(Pos.CENTER);
        feedBackContainer.setSpacing(10);
        feedBackContainer.getChildren().addAll(viewFeedBackBtn);
        feedBack.getChildren().addAll(feedBackLabel, feedBackContainer);

        adminMainPage.add(userAcc, 0, 0);
        adminMainPage.add(appointment, 1, 0);
        adminMainPage.add(medicalRecord, 0, 1);
        adminMainPage.add(paymentRecord, 1, 1);
        adminMainPage.add(feedBack, 0, 2);
    }
    public GridPane getAdminMainPage() {
        return adminMainPage;
    }

}


