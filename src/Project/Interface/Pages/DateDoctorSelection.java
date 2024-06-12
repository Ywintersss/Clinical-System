package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Users.Doctor;
import Project.Utilities.Utilities;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.print.Doc;

public class DateDoctorSelection {
    private ObservableList<Doctor> doctors;
    private Label titleLabel;
    private Region spacer1;
    private VBox dateSelectionContainer;
    private HBox dateDoctorSelectorContainer;
    private Label SelectDate;
    private ComboBox<String> dateSelector;
    private Label SelectDoctor;
    private ComboBox<Doctor> doctorSelector;
    private Region spacer2;
    private HBox buttonContainer;
    private Button back;
    private Region spacer3;
    private Button next;
    public DateDoctorSelection() {
        doctors = ClinicalSystem.getUserDataManager().getAllDoctors();

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
        dateSelector.setValue("Today");
        dateSelector.getItems().addAll("Today", Utilities.getCurrentDate(1), Utilities.getCurrentDate(2));

        SelectDoctor = new Label("Select Doctor: ");
        SelectDoctor.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        SelectDoctor.setPadding(new Insets(10, -20, 10, 0));

        doctorSelector = new ComboBox<>();
        doctorSelector.setPromptText("Select a Doctor");
        //doctorSelector.setValue();
        doctorSelector.getItems().addAll(doctors);

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


        spacer3 = new Region();
        HBox.setHgrow(spacer3, Priority.ALWAYS);

        next = new Button("Next");
        next.setPadding(new Insets(10, 20, 10, 20));
        next.setOnAction(e -> {
            if (doctorSelector.getValue() == null) {
                Notification.error("Please select a doctor");
                return;
            }

            if (dateSelector.getValue().equals("Today")) {
                ClinicalSystem.navigateTo(new ViewSchedule(doctorSelector.getValue(), Utilities.getCurrentDate(0)).getSchedules());
            } else if (dateSelector.getValue().equals(Utilities.getCurrentDate(1))) {
//                ClinicalSystem.navigateTo(new ViewSchedule(Utilities.getCurrentDate(1)).getTable();
            } else if (dateSelector.getValue().equals(Utilities.getCurrentDate(2))) {
//                ClinicalSystem.navigateTo(new ViewSchedule(Utilities.getCurrentDate(2)).getTable();
            }
        });

        buttonContainer.getChildren().addAll(back, spacer3, next);

        dateSelectionContainer.getChildren().addAll(titleLabel, spacer1, dateDoctorSelectorContainer, spacer2, buttonContainer);
    }

    public VBox getDateSelection() {
        return dateSelectionContainer;
    }
}
