package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Scheduler.ScheduleDetail;
import Project.UserSession;
import Project.Users.Doctor;

import Project.Users.Patient;
import Project.Utilities.Styles;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DateDoctorSelection {
    private ObservableList<ScheduleDetail> scheduleDetails;
    private ObservableList<Patient> patients;
    private Label titleLabel;
    private Region spacer1;
    private VBox dateSelectionContainer;
    private HBox dateDoctorSelectorContainer;
    private Label SelectDate;
    private ComboBox<String> dateSelector;
    private HBox patientSelectorContainer;
    private Label SelectPatient;
    private ComboBox<String> patientSelector;
    private Region adminSpacer;
    private Label SelectDoctor;
    private ComboBox<Doctor> doctorSelector;
    private Region spacer2;
    private HBox buttonContainer;
    private Button back;
    private Region spacer3;
    private Button next;
    public DateDoctorSelection(boolean isAdmin) {
        scheduleDetails = ClinicalSystem.getScheduler().getActiveScheduleDetails();
        patients = ClinicalSystem.getUserDataManager().getAllPatients();

        if (scheduleDetails.isEmpty()) {
            Notification.information("No Schedule Available, Please try again later");
        }

        dateSelectionContainer = new VBox();
        dateSelectionContainer.setSpacing(10);
        dateSelectionContainer.setPadding(new Insets(10, 10, 10, 10));
        dateSelectionContainer.setAlignment(Pos.CENTER);

        titleLabel = new Label("Select a Date");
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        titleLabel.setPadding(new Insets(10, 0, 10, 0));

        spacer1 = new Region();
        VBox.setVgrow(spacer1, Priority.ALWAYS);

        dateDoctorSelectorContainer = new HBox();
        dateDoctorSelectorContainer.setSpacing(20);
        dateDoctorSelectorContainer.setAlignment(Pos.CENTER);

        SelectDate = new Label("Select Date: ");
        SelectDate.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        SelectDate.setPadding(new Insets(10, -20, 10, 0));

        dateSelector = new ComboBox<>();
        dateSelector.setPromptText("Select a Date");


        dateSelector.setOnMouseClicked(e -> {
            dateSelector.getItems().clear();
            if (doctorSelector.getValue() == null) {
                dateSelector.getItems().addAll(scheduleDetails.stream().map(ScheduleDetail::getDate).distinct().toList());
            } else {
                for (ScheduleDetail scheduleDetail : scheduleDetails) {
                    if (scheduleDetail.getDoctor().equals(doctorSelector.getValue())) {
                        dateSelector.getItems().add(scheduleDetail.getDate());
                    }
                }
            }
        });


        SelectDoctor = new Label("Select Doctor: ");
        SelectDoctor.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        SelectDoctor.setPadding(new Insets(10, -20, 10, 0));

        doctorSelector = new ComboBox<>();
        doctorSelector.setPromptText("Select a Doctor");
        doctorSelector.setOnMouseClicked(e -> {
            doctorSelector.getItems().clear();
            if (dateSelector.getValue() == null) {
                doctorSelector.getItems().addAll(scheduleDetails.stream().map(ScheduleDetail::getDoctor).distinct().toList());
            } else {
                for (ScheduleDetail scheduleDetail : scheduleDetails) {
                    if (scheduleDetail.getDate().equals(dateSelector.getValue())) {
                        doctorSelector.getItems().add(scheduleDetail.getDoctor());
                    }
                }
            }
        });

        dateDoctorSelectorContainer.getChildren().addAll(SelectDate, dateSelector, SelectDoctor, doctorSelector);

        spacer2 = new Region();
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);
        VBox.setMargin(buttonContainer, new Insets(0, 10, 10, 10));

        back = new Button("Back");
        back.setPadding(new Insets(10, 20, 10, 20));
        back.setOnAction(e -> {
            ClinicalSystem.back();
        });
        back.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");


        spacer3 = new Region();
        HBox.setHgrow(spacer3, Priority.ALWAYS);


        next = new Button("Next");
        next.setPadding(new Insets(10, 20, 10, 20));
        next.setOnAction(e -> {
            String patientID;
            if (doctorSelector.getValue() == null || dateSelector.getValue() == null) {
                Notification.error("Please select a doctor and a date");
                return;
            }

            if (isAdmin && patientSelector.getValue() == null) {
                Notification.error("Please select a patient");
                return;
            } else if (isAdmin && patientSelector.getValue() != null) {
                patientID = patientSelector.getValue();
            } else {
                patientID = UserSession.getInstance().getCurrentUser().getID();
            }


            ScheduleDetail scheduleDetail = scheduleDetails.stream()
                .filter(sd -> sd.getDoctor().equals(doctorSelector.getValue()))
                .filter(sd -> sd.getDate().equals(dateSelector.getValue()))
                .findFirst()
                .orElse(null);

            assert scheduleDetail != null;
            ClinicalSystem.navigateTo(new ScheduleSelector(scheduleDetail, patientID).getSchedules());
        });
        next.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");

        buttonContainer.getChildren().addAll(back, spacer3, next);

        dateSelectionContainer.getChildren().addAll(titleLabel, spacer1, dateDoctorSelectorContainer, spacer2, buttonContainer);

        if (isAdmin) {
            patientSelectorContainer = new HBox();
            patientSelectorContainer.setSpacing(20);
            patientSelectorContainer.setAlignment(Pos.CENTER);
            patientSelectorContainer.setPadding(new Insets(10, 10, 10, 10));

            SelectPatient = new Label("Select Patient: ");
            SelectPatient.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            SelectPatient.setPadding(new Insets(10, -20, 10, 0));

            patientSelector = new ComboBox<>();
            patientSelector.setPromptText("Select a Patient");
            patientSelector.getItems().addAll(patients.stream().map(Patient::getID).distinct().toList());

            adminSpacer = new Region();
            HBox.setHgrow(adminSpacer, Priority.ALWAYS);

            patientSelectorContainer.getChildren().addAll(SelectPatient, patientSelector);

            dateSelectionContainer.getChildren().add(2, patientSelectorContainer);
            dateSelectionContainer.getChildren().add(4, adminSpacer);
        }
    }

    public VBox getDateSelection() {
        return dateSelectionContainer;
    }
}
