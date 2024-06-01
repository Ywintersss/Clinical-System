package Project.Interface.Pages.Components;

import javafx.scene.layout.HBox;
import javafx.scene.control.Label;

public class DoctorCard {
    private HBox doctorCard;
    //Doctor object
    private Label doctorName;
    private Label doctorSpecialization;
    private Label doctorPosition;

    public DoctorCard(String name, String specialization, String position) {
        doctorCard = new HBox();

        this.doctorName = new Label(name + " ");
        this.doctorSpecialization = new Label(specialization + " ");
        this.doctorPosition = new Label(position);

        doctorCard.getChildren().addAll(doctorName, doctorSpecialization, doctorPosition);
    }

    public HBox getDoctorCard() {
        return this.doctorCard;
    }
}
