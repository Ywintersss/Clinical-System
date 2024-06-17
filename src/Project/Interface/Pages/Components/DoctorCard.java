package Project.Interface.Pages.Components;

import Project.Utilities.Styles;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DoctorCard {
    private HBox doctorCard;
    private Image doctorImage;
    private VBox doctorDetails;
    private Label doctorNameLabel;
    private Label specializationLabel;
    private Label positionLabel;
    private Label experienceLabel;
    public DoctorCard(String specialization, String position, String doctorName, String experience) {
        doctorCard = new HBox();
        doctorCard.setSpacing(10);

        //this.doctorImage = new Image("\\assets\\images\\doctor.png");

        doctorCard.setPadding(new Insets(17.5, 15, 17.5, 15));
        doctorCard.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY)));

        doctorDetails = new VBox();
        doctorDetails.setSpacing(5);

        this.doctorNameLabel = new Label("Name: " + doctorName);
        doctorNameLabel.setStyle(Styles.fontSize(14));

        this.specializationLabel = new Label("Specialization: " + specialization);
        specializationLabel.setStyle(Styles.fontSize(14));

        this.experienceLabel = new Label("Experience: " + experience);
        experienceLabel.setStyle(Styles.fontSize(14));

        this.positionLabel = new Label("Position: " + position);
        positionLabel.setStyle(Styles.fontSize(14));

        doctorDetails.getChildren().addAll(doctorNameLabel, specializationLabel, positionLabel, experienceLabel);

        doctorCard.getChildren().addAll(doctorDetails);
    }

    public HBox getDoctorCard() {
        return this.doctorCard;
    }
}
