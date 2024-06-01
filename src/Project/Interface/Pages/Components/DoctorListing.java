package Project.Interface.Pages.Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DoctorListing {
    private VBox doctorList;

    public DoctorListing() {
        doctorList = new VBox();
        for (int i = 0; i < 3; i++) {
            DoctorCard doctorCard = new DoctorCard("Kelly", "Chest", "Leader");
            doctorList.getChildren().add(doctorCard.getDoctorCard());
        }

        doctorList.setAlignment(Pos.CENTER);
        doctorList.setSpacing(10);
        //doctorList.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        doctorList.setStyle("-fx-background-color: #FFFFFF;");
        doctorList.setPadding(new Insets(10, 10, 10, 10));
        doctorList.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    }
    public VBox getDoctorList() {
        return doctorList;
    }
}
