package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class ViewSchedule {
    private VBox scheduleContainer;
    private ScrollPane scheduleScroller;
    private GridPane schedules;
    private ToggleGroup toggleGroup;
    private HBox buttonContainer;
    private Button back;
    private Region spacer;
    private Button makeAppointment;
    public ViewSchedule(String doctorName, String date) {
        scheduleContainer = new VBox();
        scheduleContainer.setAlignment(Pos.CENTER);
        scheduleContainer.setPadding(new Insets(10, 10, 10, 10));
        scheduleContainer.setPrefWidth(200);


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
//            ClinicalSystem.navigateTo();
        });

        buttonContainer.getChildren().addAll(back, spacer, makeAppointment);

        scheduleContainer.getChildren().addAll(scheduleScroller, buttonContainer);
    }

    public VBox getSchedules() {
        return scheduleContainer;
    }
}
