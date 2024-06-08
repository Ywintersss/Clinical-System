package Project.Interface.Pages.Components;

import Project.Utilities.ScreenTools;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Schedule {
    private VBox schedule;
    private HBox scheduleCard;

    public Schedule() {
        schedule = new VBox();

        for (int i = 0; i < 4; i++) {
            //TODO i < 3 needs to change
            scheduleCard = new ScheduleCard("Heart", "Kelly", "Monday", "10:00 - 11:00").getScheduleCard();
            //scheduleCard = new ScheduleCard().getScheduleCard();
            schedule.getChildren().add(scheduleCard);
        }

        schedule.setSpacing(10);
        schedule.setAlignment(Pos.CENTER);
        schedule.setPadding(new Insets(10, 10, 10, 10));
        schedule.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        schedule.setStyle("-fx-background-color: #FFFFFF;");



    }

    public VBox getSchedule() {
        return schedule;
    }
}
