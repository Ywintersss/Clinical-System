package Project.Interface.Pages;

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
    private Button addUserBtn;
    private Button updateUserBtn;

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

        userAcc = new VBox();
        userAcc.setStyle("-fx-background-color: #FFFFFF;");
        userAcc.setPadding(new Insets(10, 10, 10, 10));
        userAcc.setPrefHeight(120);
        userAcc.setPrefWidth(280);
        userAcc.setSpacing(10);
        userAcc.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        userAccLabel = new Label("User Account Management");
        userAccLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-underline: true;");

        userAccContainer = new HBox();

        addUserBtn = new Button("Add");
        addUserBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        addUserBtn.setPrefHeight(30);
        addUserBtn.setPrefWidth(75);

        updateUserBtn = new Button("Update");
        updateUserBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        updateUserBtn.setPrefHeight(30);
        updateUserBtn.setPrefWidth(75);

        userAccContainer.setAlignment(Pos.CENTER);
        userAccContainer.setSpacing(10);
        userAccContainer.getChildren().addAll(addUserBtn, updateUserBtn);
        userAcc.getChildren().addAll(userAccLabel, userAccContainer);


        appointment = new VBox();
        appointment.setStyle("-fx-background-color: #FFFFFF;");
        appointment.setPadding(new Insets(10, 10, 10, 10));
        appointment.setPrefHeight(120);
        appointment.setPrefWidth(280);
        appointment.setSpacing(10);
        appointment.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        appointmentLabel = new Label("Appointment Management");
        appointmentLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-underline: true;");

        appointmentContainer = new HBox();

        addAppointmentBtn = new Button("Add");
        addAppointmentBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        addAppointmentBtn.setPrefHeight(30);
        addAppointmentBtn.setPrefWidth(75);

        approveAppointmentBtn = new Button("Approve");
        approveAppointmentBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        approveAppointmentBtn.setPrefHeight(30);
        approveAppointmentBtn.setPrefWidth(75);

        appointmentContainer.setAlignment(Pos.CENTER);
        appointmentContainer.setSpacing(10);
        appointmentContainer.getChildren().addAll(addAppointmentBtn, approveAppointmentBtn);
        appointment.getChildren().addAll(appointmentLabel, appointmentContainer);


        medicalRecord = new VBox();
        medicalRecord.setStyle("-fx-background-color: #FFFFFF;");
        medicalRecord.setPadding(new Insets(10, 10, 10, 10));
        medicalRecord.setPrefHeight(120);
        medicalRecord.setPrefWidth(280);
        medicalRecord.setSpacing(10);
        medicalRecord.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        medicalRecordLabel = new Label("Medical Record Management");
        medicalRecordLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-underline: true;");

        medicalRecordContainer = new HBox();

        updateMedicalRecordBtn = new Button("Update");
        updateMedicalRecordBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        updateMedicalRecordBtn.setPrefHeight(30);
        updateMedicalRecordBtn.setPrefWidth(75);

        medicalRecordContainer.setAlignment(Pos.CENTER);
        medicalRecordContainer.setSpacing(10);
        medicalRecordContainer.getChildren().addAll(updateMedicalRecordBtn);
        medicalRecord.getChildren().addAll(medicalRecordLabel, medicalRecordContainer);


        paymentRecord = new VBox();
        paymentRecord.setStyle("-fx-background-color: #FFFFFF;");
        paymentRecord.setPadding(new Insets(10, 10, 10, 10));
        paymentRecord.setPrefHeight(120);
        paymentRecord.setPrefWidth(280);
        paymentRecord.setSpacing(10);
        paymentRecord.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        paymentRecordLabel = new Label("Payment Record Management");
        paymentRecordLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-underline: true;");

        paymentRecordContainer = new HBox();

        viewPaymentRecordBtn = new Button("View");
        viewPaymentRecordBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        viewPaymentRecordBtn.setPrefHeight(30);
        viewPaymentRecordBtn.setPrefWidth(75);

        paymentRecordContainer.setAlignment(Pos.CENTER);
        paymentRecordContainer.setSpacing(10);
        paymentRecordContainer.getChildren().addAll(viewPaymentRecordBtn);
        paymentRecord.getChildren().addAll(paymentRecordLabel, paymentRecordContainer);


        doctor = new VBox();
        doctor.setStyle("-fx-background-color: #FFFFFF;");
        doctor.setPadding(new Insets(10, 10, 10, 10));
        doctor.setPrefHeight(120);
        doctor.setPrefWidth(280);
        doctor.setSpacing(10);
        doctor.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        doctorLabel = new Label("Doctor Management");
        doctorLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-underline: true;");

        doctorContainer = new HBox();

        addDoctorBtn = new Button("Add");
        addDoctorBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        addDoctorBtn.setPrefHeight(30);
        addDoctorBtn.setPrefWidth(75);

        scheduleBtn = new Button("Schedule");
        scheduleBtn.setStyle("-fx-background-color: #da8ee7; -fx-text-fill: #FFFFFF;-fx-font-size: 13px;-fx-font-weight: bold;");
        scheduleBtn.setPrefHeight(30);
        scheduleBtn.setPrefWidth(75);

        doctorContainer.setAlignment(Pos.CENTER);
        doctorContainer.setSpacing(10);
        doctorContainer.getChildren().addAll(addDoctorBtn, scheduleBtn);
        doctor.getChildren().addAll(doctorLabel, doctorContainer);


        adminMainPage.add(userAcc, 0, 0);
        adminMainPage.add(appointment, 1, 0);
        adminMainPage.add(medicalRecord, 0, 1);
        adminMainPage.add(paymentRecord, 1, 1);
        adminMainPage.add(doctor, 0, 2);
    }
    public GridPane getAdminMainPage() {
        return adminMainPage;
    }

}


