package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Users.Doctor;
import javafx.geometry.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

public class DoctorListing {
    private ObservableList<Doctor> Doctors;
    private VBox DoctorListing;
    private HBox DoctorCard;

    public DoctorListing() {
        DoctorListing = new VBox();

        Doctors = ClinicalSystem.getUserDataManager().getAllDoctors();

        for (int i = 0; i < Doctors.size(); i++) {
            DoctorCard = new DoctorCard(Doctors.get(i).getSpecialization(), Doctors.get(i).getPosition(), Doctors.get(i).getName(), Integer.toString(Doctors.get(i).getYearsOfExperience())).getDoctorCard();
            DoctorListing.getChildren().add(DoctorCard);
        }

        DoctorListing.setSpacing(12.5);
        DoctorListing.setAlignment(Pos.CENTER);
        DoctorListing.setPadding(new Insets(20, 10, 20, 10));
        DoctorListing.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        DoctorListing.setStyle("-fx-background-color: #FFFFFF;");
    }

    public VBox getDoctorListing() {
        return DoctorListing;
    }
}
