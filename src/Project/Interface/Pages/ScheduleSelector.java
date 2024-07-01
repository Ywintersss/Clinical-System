package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Scheduler.AppointmentDetail;
import Project.Scheduler.ScheduleDetail;
import Project.Users.Doctor;
import Project.Users.Patient;
import Project.Utilities.Styles;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ScheduleSelector {
    private ObservableList<AppointmentDetail> appointmentDetails;
    private ArrayList<String> unavailableTimes;
    private HBox LabelContainer;
    private Label doctorNameLabel;
    private Label dateLabel;
    private VBox scheduleContainer;
    private ScrollPane scheduleScroller;
    private GridPane schedules;
    private ToggleGroup toggleGroup;
    private HBox buttonContainer;
    private Button back;
    private Region spacer;
    private Button makeAppointment;
    public ScheduleSelector(ScheduleDetail scheduleDetail, String patientID, boolean isAdmin) {
        appointmentDetails = ClinicalSystem.getScheduler().getAllAppointmentDetails();

        scheduleContainer = new VBox();
        scheduleContainer.setAlignment(Pos.CENTER);
        scheduleContainer.setPadding(new Insets(10, 10, 10, 10));
        scheduleContainer.setPrefWidth(200);

        LabelContainer = new HBox();
        LabelContainer.setSpacing(10);
        LabelContainer.setPadding(new Insets(10, 10, 10, 10));
        LabelContainer.setAlignment(Pos.CENTER);

        doctorNameLabel = new Label("Doctor: " + scheduleDetail.getDoctor().getName());
        doctorNameLabel.setStyle(Styles.fontWeightBold + Styles.fontSize(25) +Styles.fontFamily);
        dateLabel = new Label("Date: " + scheduleDetail.getDate());
        dateLabel.setStyle(Styles.fontWeightBold + Styles.fontSize(25) +Styles.fontFamily);

        LabelContainer.getChildren().addAll(doctorNameLabel, dateLabel);

        schedules = new GridPane();
        schedules.setHgap(10);
        schedules.setVgap(10);
        schedules.setAlignment(Pos.CENTER);
        schedules.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        schedules.setPadding(new Insets(10, 10, 10, 10));
        schedules.setMaxSize(200, 500);

        toggleGroup = new ToggleGroup();


        //ex: get 08 from 0800
        int duration = Integer.parseInt(scheduleDetail.getEndTime().substring(0, 2)) - Integer.parseInt(scheduleDetail.getStartTime().substring(0, 2));

        LocalTime startTime = LocalTime.of(Integer.parseInt(scheduleDetail.getStartTime().substring(0, 2)), 0);
        String date = scheduleDetail.getDate();

        //Rows
        for (int row = 0; row < duration; row++) {
            //Columns
            for (int column = 0; column < 2; column++) {
                String formattedTime = startTime.format(DateTimeFormatter.ofPattern("HHmm"));

                if (formattedTime.equals("1200") || formattedTime.equals("1230") || formattedTime.equals("1900") || formattedTime.equals("1930")) {
                    startTime = startTime.plusMinutes(30);
                    continue;
                }

                if (!Utilities.isActive(date, formattedTime, false)) {
                    startTime = startTime.plusMinutes(30);
                    continue;
                }

                ToggleButton scheduleButton = new ToggleButton(formattedTime);
                scheduleButton.setMinWidth(100);
                scheduleButton.setMinHeight(50);
                scheduleButton.setToggleGroup(toggleGroup);

                startTime = startTime.plusMinutes(30);

                GridPane.setRowIndex(scheduleButton, row);
                GridPane.setColumnIndex(scheduleButton, column);

                schedules.getChildren().add(scheduleButton);
            }
        }

        if (schedules.getChildren().size() == 0) {
            Notification.error("No more schedules available");
        }

        scheduleScroller = new ScrollPane();
        scheduleScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scheduleScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scheduleScroller.setContent(schedules);
        scheduleScroller.setMaxWidth(250);
        scheduleScroller.setFitToWidth(true);


        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.setPadding(new Insets(10, 10, 10, 10));

        back = new Button("Back");
        back.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
        back.setOnAction(e -> {
            ClinicalSystem.back();
        });

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        makeAppointment = new Button("Make Appointment");
        makeAppointment.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
        makeAppointment.setOnAction(e -> {
            if (toggleGroup.getSelectedToggle() == null) {
                Notification.error("Please select a time");
                return;
            }

            //Removes unrelated appointment details
            appointmentDetails.removeIf(appointmentDetail -> !appointmentDetail.getSchedule().getScheduleID().equals(scheduleDetail.getSchedule().getScheduleID()));

            unavailableTimes = new ArrayList<>();
            for (AppointmentDetail appointmentDetail : appointmentDetails) {
                unavailableTimes.add(appointmentDetail.getAppointmentTime());
            }

            String time = ((ToggleButton) toggleGroup.getSelectedToggle()).getText();

            if (unavailableTimes.contains(time)) {
                Notification.error("Time is unavailable");
                return;
            }

            ClinicalSystem.navigateTo(new MakeAppointmentDetails(scheduleDetail, patientID, time, isAdmin).getDetails());
        });

        buttonContainer.getChildren().addAll(back, spacer, makeAppointment);

        scheduleContainer.getChildren().addAll(LabelContainer,scheduleScroller, buttonContainer);
    }

    public VBox getSchedules() {
        return scheduleContainer;
    }
}
