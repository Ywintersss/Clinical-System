package Project.Interface.Pages.Components;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class ScheduleCard {
    private HBox scheduleCard;

    //Schedule Object
    private Label specializationLabel;
    private Label doctorNameLabel;
    private Label dateLabel;
    private Label timeLabel;
    public ScheduleCard(String specialization, String doctorName, String date, String time) {
        scheduleCard = new HBox();

        this.specializationLabel = new Label(specialization);
        this.doctorNameLabel = new Label(doctorName);
        this.dateLabel = new Label(date);
        this.timeLabel = new Label(time);

        scheduleCard.getChildren().addAll(specializationLabel, doctorNameLabel, dateLabel, timeLabel);
    }

    public HBox getScheduleCard() {
        return this.scheduleCard;
    }
}
