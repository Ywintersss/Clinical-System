package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Users.Doctor;
import Project.Utilities.ScreenTools;
import Project.Utilities.Styles;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ViewSchedule {
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
    public ViewSchedule(Doctor doctor, String date) {
        scheduleContainer = new VBox();
        scheduleContainer.setAlignment(Pos.CENTER);
        scheduleContainer.setPadding(new Insets(10, 10, 10, 10));
        scheduleContainer.setPrefWidth(200);

        LabelContainer = new HBox();
        LabelContainer.setSpacing(10);
        LabelContainer.setPadding(new Insets(10, 10, 10, 10));
        LabelContainer.setAlignment(Pos.CENTER);

        doctorNameLabel = new Label("Doctor: " + doctor.getName());
        doctorNameLabel.setStyle(Styles.fontWeightTitle + Styles.fontSize(25) +Styles.fontFamily);
        dateLabel = new Label("Date: " + date);
        dateLabel.setStyle(Styles.fontWeightTitle + Styles.fontSize(25) +Styles.fontFamily);

        LabelContainer.getChildren().addAll(doctorNameLabel, dateLabel);

        schedules = new GridPane();
        schedules.setHgap(10);
        schedules.setVgap(10);
        schedules.setAlignment(Pos.CENTER);
        schedules.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        schedules.setPadding(new Insets(10, 10, 10, 10));
        schedules.setMaxSize(200, 500);

        toggleGroup = new ToggleGroup();

        //TODO diff schedule based on doctor type
        LocalTime startTime = LocalTime.of(9, 0);

        //Rows
        for (int row = 0; row < 14; row++) {
            //Columns
            for (int column = 0; column < 2; column++) {
                String formattedTime = startTime.format(DateTimeFormatter.ofPattern("HH:mm"));

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
        back.setOnAction(e -> {
            ClinicalSystem.back();
        });

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        makeAppointment = new Button("Make Appointment");
        makeAppointment.setOnAction(e -> {
            if (toggleGroup.getSelectedToggle() == null) {
                Notification.error("Please select a time");
                return;
            }

            String time = ((ToggleButton) toggleGroup.getSelectedToggle()).getText();
            ClinicalSystem.navigateTo(new MakeAppointmentDetails(doctor, date, time).getDetails());
        });

        buttonContainer.getChildren().addAll(back, spacer, makeAppointment);

        scheduleContainer.getChildren().addAll(LabelContainer,scheduleScroller, buttonContainer);
    }

    public VBox getSchedules() {
        return scheduleContainer;
    }
}
