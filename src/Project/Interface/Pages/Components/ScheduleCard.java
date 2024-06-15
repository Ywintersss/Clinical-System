package Project.Interface.Pages.Components;

import Project.Scheduler.Schedule;
import Project.Utilities.Styles;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ScheduleCard {
    private HBox scheduleCard;
    private Label dateLabel;
    private Label startTimeLabel;
    private Label endTimeLabel;
    public ScheduleCard(Schedule schedule) {
        scheduleCard = new HBox();
        scheduleCard.setSpacing(10);
        scheduleCard.setPadding(new Insets(10));
        scheduleCard.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(4), Insets.EMPTY)));
        scheduleCard.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(4), BorderWidths.DEFAULT)));

        dateLabel = new Label("Schedule Date: " + schedule.getDate());
        dateLabel.setStyle(Styles.fontWeightBold + Styles.fontSize(16));

        startTimeLabel = new Label("Start Time: " + schedule.getStartTime());
        startTimeLabel.setStyle(Styles.fontWeightBold + Styles.fontSize(16));

        endTimeLabel = new Label("End Time: " + schedule.getEndTime());
        endTimeLabel.setStyle(Styles.fontWeightBold + Styles.fontSize(16));

        scheduleCard.getChildren().addAll(dateLabel, startTimeLabel, endTimeLabel);
    }
    public HBox getScheduleCard() {
        return scheduleCard;
    }
}
