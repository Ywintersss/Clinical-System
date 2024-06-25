package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.ScheduleSelector;
import Project.Scheduler.ScheduleDetail;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Utilities.Styles;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import jdk.jshell.execution.Util;

import javax.print.Doc;

public class DoctorCard {
    private ObservableList<ScheduleDetail> activeScheduleDetails;
    private HBox doctorCard;
    private Image doctorImage;
    private VBox doctorDetails;
    private Label doctorNameLabel;
    private Label specializationLabel;
    private Label positionLabel;
    private Label experienceLabel;
    private Button appointMentButton;
    public DoctorCard(Doctor doctor) {
        doctorCard = new HBox();
        doctorCard.setSpacing(10);
        doctorCard.setPadding(new Insets(10));
        doctorCard.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY)));
        doctorCard.setAlignment(Pos.CENTER_LEFT);

        if (doctor.getSpecialization().equals("Heart")){
            this.doctorImage = new Image("\\Project\\Interface\\assets\\images\\heart.png");
        } else if (doctor.getSpecialization().equals("Chiropractor")){
            this.doctorImage = new Image("\\Project\\Interface\\assets\\images\\chiropractor.png");
        } else if (doctor.getSpecialization().equals("Family")){
            this.doctorImage = new Image("\\Project\\Interface\\assets\\images\\family.png");
        }

        ImageView imageView = new ImageView(doctorImage);
        imageView.setFitHeight(65);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);


        doctorDetails = new VBox();
        doctorDetails.setSpacing(2);

        this.doctorNameLabel = new Label("Name: " + doctor.getName());
        doctorNameLabel.setStyle(Styles.fontSize(13));

        this.specializationLabel = new Label("Specialization: " + doctor.getSpecialization());
        specializationLabel.setStyle(Styles.fontSize(13));

        this.experienceLabel = new Label("Experience: " + doctor.getYearsOfExperience() + " years");
        experienceLabel.setStyle(Styles.fontSize(13));

        this.positionLabel = new Label("Position: " + doctor.getPosition());
        positionLabel.setStyle(Styles.fontSize(13));

        appointMentButton = new Button("Make Appointment Today");
        appointMentButton.setOnAction(e -> {
            if (UserSession.getInstance().getCurrentUser() == null) {
                Notification.error("Please Login First");
                return;
            }

            activeScheduleDetails = ClinicalSystem.getScheduler().getActiveScheduleDetails();

            for (ScheduleDetail scheduleDetail : activeScheduleDetails) {
                if (scheduleDetail.getDoctor().getID().equals(doctor.getID()) && scheduleDetail.getDate().equals(Utilities.getCurrentDate())) {
                    if (scheduleDetail.getStartTime().equals("null") && scheduleDetail.getEndTime().equals("null")) {
                        Notification.error("Doctor is on leave today");
                    } else {
                        ClinicalSystem.navigateTo(new ScheduleSelector(scheduleDetail, null).getSchedules());
                        return;
                    }
                }
            }

            Notification.error("Doctor hasn't uploaded their schedule today");
        });

        doctorDetails.getChildren().addAll(doctorNameLabel, specializationLabel, positionLabel, experienceLabel, appointMentButton);

        doctorCard.getChildren().addAll(imageView, doctorDetails);
    }

    public HBox getDoctorCard() {
        return this.doctorCard;
    }
}
