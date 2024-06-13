package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.DoctorMainPage;
import Project.Scheduler.Schedule;
import Project.UserSession;
import Project.Utilities.Styles;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;

import java.util.HashMap;


public class UploadBox {
    private ObservableList<Schedule> schedules;
    private HashMap<String, Schedule> scheduleDate = new HashMap<>();
    private VBox uploadBox;
    private Label startLabel;
    private ComboBox<String> startTime;
    private Label endLabel;
    private ComboBox<String> endTime;
    private Label dateLabel;
    private ComboBox<String> date;
    private Button takeLeave;
    private Button upload;
    public UploadBox() {
        schedules = ClinicalSystem.getScheduler().getAllSchedules();
        schedules.removeIf(schedule -> !UserSession.getInstance().getCurrentUser().getID().equals(schedule.getDoctorID()));

        for (Schedule schedule : schedules) {
            scheduleDate.put(schedule.getDate(), schedule);
        }

        uploadBox = new VBox();
        uploadBox.setStyle(Styles.backgroundColour("#B0B0B0") + Styles.padding(10));
        uploadBox.setSpacing(10);
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setMaxWidth(250);
        uploadBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        uploadBox.setVisible(false);
        uploadBox.toFront();

        startLabel = new Label("Start Time");
        startLabel.setStyle(Styles.fontFamily + Styles.fontWeightTitle + Styles.fontSize(15));

        endLabel = new Label("End Time");
        endLabel.setStyle(Styles.fontFamily + Styles.fontWeightTitle + Styles.fontSize(15));

        dateLabel = new Label("Date");
        dateLabel.setStyle(Styles.fontFamily + Styles.fontWeightTitle + Styles.fontSize(15));

        startTime = new ComboBox<>();
        startTime.setPromptText("Select Start Time");
        startTime.setStyle(Styles.padding(6));
        startTime.getItems().addAll("0800", "0900", "1000", "1100", "1200", "1300", "1400", "1500");

        endTime = new ComboBox<>();
        endTime.setPromptText("Select End Time");
        endTime.setStyle(Styles.padding(6));
        endTime.setOnMouseClicked(e -> {
            if (startTime.getValue() == null) {
                Notification.information("Please select start time first.");
                return;
            }
            if (endTime.getItems().size() == 0) {
                for (int i = Integer.parseInt(startTime.getValue()) + 900; i <= 2300; i += 100) {
                    endTime.getItems().add(Integer.toString(i));
                }
            }
        });

        date = new ComboBox<>();
        date.setPromptText("DD-MM-YYYY");
        //date.getItems().addAll(Utilities.getCurrentDate(), Utilities.getCurrentDate(1), Utilities.getCurrentDate(2), Utilities.getCurrentDate(3), Utilities.getCurrentDate(4));
        for (int i = 0; i < 5; i++) {
            String boxDateItem = Utilities.getCurrentDate(i);
            if (scheduleDate.containsKey(boxDateItem)) {
                continue;
            }
            date.getItems().add(boxDateItem);
        }

        takeLeave = new Button("Take Leave");
        takeLeave.setStyle(Styles.fontWeightTitle);
        takeLeave.setOnAction(e -> {
            return;
        });

        upload = new Button("Upload");
        upload.setStyle(Styles.fontWeightTitle + Styles.fontSize(15) + Styles.padding(10, 20, 10, 20));
        upload.setOnAction(e -> {
            if (startTime.getValue() == null || endTime.getValue() == null || date.getValue() == null) {
                    Notification.information("Please fill all the fields.");
                    return;
            }
            try {
                ClinicalSystem.getScheduler().addSchedule(UserSession.getInstance().getCurrentUser().getID(), startTime.getValue(), endTime.getValue(), date.getValue());
                Notification.information("Schedule uploaded Successfully");
                ClinicalSystem.Refresh(new DoctorMainPage().getDoctorMainPage());
            } catch (Exception e1) {
                Notification.error("Something went wrong. Please try again.");
            }
        });

        uploadBox.getChildren().addAll(startLabel, startTime, endLabel, endTime, dateLabel, date, takeLeave, upload);
        uploadBox.setVisible(false);
    }
    public VBox getUploadBox() {
        return uploadBox;
    }
}
