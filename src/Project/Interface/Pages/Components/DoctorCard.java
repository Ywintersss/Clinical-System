package Project.Interface.Pages.Components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DoctorCard {
    private HBox doctorCard;
    private Image doctorImage;
    private VBox doctorDetails;
    private Label specializationLabel;
    private Label doctorNameLabel;
    private Label experienceLabel;
    private Label timeLabel;
    public DoctorCard(String specialization, String doctorName, String experience, String time) {
        doctorCard = new HBox();
        doctorCard.setSpacing(10);

        //this.doctorImage = new Image("\\assets\\images\\doctor.png");

        doctorCard.setPadding(new Insets(15));
        doctorCard.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY)));

        doctorDetails = new VBox();
        doctorDetails.setSpacing(5);

        this.specializationLabel = new Label("Specialization: " + specialization);

        this.doctorNameLabel = new Label("Name: " + doctorName);

        this.experienceLabel = new Label("Experience: " + experience);

        this.timeLabel = new Label(time);


        doctorDetails.getChildren().addAll(specializationLabel, doctorNameLabel, experienceLabel, timeLabel);

        doctorCard.getChildren().addAll(doctorDetails);
    }

    public HBox getDoctorCard() {
        return this.doctorCard;
    }
}
