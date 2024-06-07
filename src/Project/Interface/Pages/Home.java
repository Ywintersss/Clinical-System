package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import Project.Interface.Pages.Components.AboutUs;
import Project.Interface.Pages.Components.DoctorListing;
import Project.Interface.Pages.Components.Schedule;
import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Home {

    private HBox home;
    private VBox aboutUsDoctorListContainer;
    private ScrollPane aboutUs;
    private VBox doctorList;
    private VBox Schedule;
    public Home() {
        home = new HBox();
        home.setSpacing(20);
        home.setAlignment(Pos.CENTER);

        aboutUsDoctorListContainer = new VBox();

        //left side
        aboutUs = new AboutUs().getAboutUs();

        doctorList = new DoctorListing().getDoctorList();

        aboutUsDoctorListContainer.setSpacing(10);
        aboutUsDoctorListContainer.setPadding(new Insets(10, 10, 10, 10));
        aboutUsDoctorListContainer.setPrefWidth(ScreenTools.getScreenWidth() * 0.2);
        aboutUsDoctorListContainer.setPrefHeight(ScreenTools.getScreenHeight() * 0.8);

        aboutUsDoctorListContainer.widthProperty().addListener((observable, oldValue, newValue) -> {
           aboutUs.setPrefWidth(aboutUsDoctorListContainer.widthProperty().getValue());
           doctorList.setPrefWidth(aboutUsDoctorListContainer.widthProperty().getValue());
        });

        aboutUsDoctorListContainer.heightProperty().addListener((observable, oldValue, newValue) -> {
            aboutUs.setPrefHeight(aboutUsDoctorListContainer.heightProperty().getValue() * 0.8);
            doctorList.setPrefHeight(aboutUsDoctorListContainer.heightProperty().getValue() * 0.2);
        });

        aboutUsDoctorListContainer.getChildren().addAll(aboutUs, doctorList);


        //right side
        Schedule = new Schedule().getSchedule();

        Schedule.setPrefWidth(ScreenTools.getScreenWidth() * 0.2);
        Schedule.setPrefHeight(ScreenTools.getScreenHeight() * 0.8);

        home.getChildren().addAll(aboutUsDoctorListContainer, Schedule);
    }

    public HBox getHome() {
        return this.home;
    }
}
