package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import Project.Interface.Pages.Components.AboutUs;
import Project.Interface.Pages.Components.MakeAppointmentBox;
import Project.Interface.Pages.Components.DoctorListing;
import javafx.geometry.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

public class Home {
    private HBox home;
    private VBox aboutUsMakeAppointmentContainer;
    private ScrollPane aboutUs;
    private VBox makeAppointmentBox;
    private VBox doctorContainer;
    private ScrollPane doctor;
    public Home() {
        home = new HBox();
        home.setSpacing(10);
        home.setAlignment(Pos.CENTER);

        aboutUsMakeAppointmentContainer = new VBox();

        //left side
        aboutUs = new AboutUs().getAboutUs();

        makeAppointmentBox = new MakeAppointmentBox().getMakeAppointmentBox();

        aboutUsMakeAppointmentContainer.setSpacing(10);
        aboutUsMakeAppointmentContainer.setPadding(new Insets(10, 10, 10, 10));
        aboutUsMakeAppointmentContainer.setPrefWidth(ScreenTools.getScreenWidth() * 0.2);

        aboutUsMakeAppointmentContainer.widthProperty().addListener((observable, oldValue, newValue) -> {
           aboutUs.setPrefWidth(aboutUsMakeAppointmentContainer.widthProperty().getValue());
           makeAppointmentBox.setPrefWidth(aboutUsMakeAppointmentContainer.widthProperty().getValue());
        });

        aboutUsMakeAppointmentContainer.heightProperty().addListener((observable, oldValue, newValue) -> {
            aboutUs.setPrefHeight(aboutUsMakeAppointmentContainer.heightProperty().getValue() * 0.8);
            makeAppointmentBox.setPrefHeight(aboutUsMakeAppointmentContainer.heightProperty().getValue() * 0.2);
        });

        aboutUsMakeAppointmentContainer.getChildren().addAll(aboutUs, makeAppointmentBox);

        doctorContainer = new VBox();
        doctorContainer.setAlignment(Pos.CENTER);

        //right side
        doctor = new DoctorListing().getDoctorListing();
        doctor.setPrefWidth(ScreenTools.getScreenWidth() * 0.2);

        doctorContainer.setPadding(new Insets(10, 0, 10, 0));
        doctorContainer.getChildren().add(doctor);

        home.getChildren().addAll(aboutUsMakeAppointmentContainer, doctorContainer);
    }

    public HBox getHome() {
        return this.home;
    }
}
