package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Users.Doctor;
import javafx.geometry.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.collections.ObservableList;

public class DoctorListing {
    private ObservableList<Doctor> Doctors;
    private VBox DoctorListing;
    private HBox DoctorCard;
    private ScrollPane scroller;

    public DoctorListing() {
        DoctorListing = new VBox();

        Doctors = ClinicalSystem.getUserDataManager().getAllDoctors();

        for (int i = 0; i < Doctors.size(); i++) {
            DoctorCard = new DoctorCard(Doctors.get(i)).getDoctorCard();
            DoctorListing.getChildren().add(DoctorCard);
        }

        DoctorListing.setSpacing(7.5);
        DoctorListing.setAlignment(Pos.CENTER);
        DoctorListing.setPadding(new Insets(7.5));
        DoctorListing.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        DoctorListing.setStyle("-fx-background-color: #FFFFFF;");

        scroller = new ScrollPane();
        scroller.setContent(DoctorListing);
        scroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroller.setFitToWidth(true);
        scroller.setFitToHeight(true);
    }

    public ScrollPane getDoctorListing() {
        return scroller;
    }
}
