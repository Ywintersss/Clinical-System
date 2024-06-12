package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.DateDoctorSelection;
import Project.UserSession;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MakeAppointmentBox {
    private VBox MakeAppointmentBox;
    private Label makeAppointmentLabel;
    private Button makeAppointmentButton;

    public MakeAppointmentBox() {
        MakeAppointmentBox = new VBox();

        MakeAppointmentBox.setAlignment(Pos.CENTER);
        MakeAppointmentBox.setSpacing(10);
        //MakeAppointmentBox.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        MakeAppointmentBox.setStyle("-fx-background-color: #FFFFFF;");
        MakeAppointmentBox.setPadding(new Insets(10, 10, 10, 10));
        MakeAppointmentBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        makeAppointmentLabel = new Label("Make Appointments Now");
        makeAppointmentLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #000000;");

        makeAppointmentButton = new Button("View Schedules >");
        makeAppointmentButton.setOnAction(e -> {
            if (UserSession.getInstance().getCurrentUser() == null) {
                Notification.error("Please Login First");
                return;
            }
            ClinicalSystem.navigateTo(new DateDoctorSelection().getDateSelection());
        });

        MakeAppointmentBox.getChildren().addAll(makeAppointmentLabel, makeAppointmentButton);
    }
    public VBox getMakeAppointmentBox() {
        return MakeAppointmentBox;
    }
}
