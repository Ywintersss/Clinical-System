package Project.Interface.Pages.Components;

import Project.Records.MedicalRecord;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MedicalRecordCard {
    private VBox contentContainer;

    private HBox issueContainer;
    private Label issueLabel;
    private Label issue;

    private HBox descriptionContainer;
    private Label descriptionLabel;
    private Label description;

    private HBox prescriptionContainer;
    private Label prescriptionLabel;
    private Label prescription;

    private HBox followUpContainer;
    private Label followUpLabel;
    private Label followUp;

    public MedicalRecordCard(MedicalRecord medicalRecord) {
        contentContainer = new VBox();
        contentContainer.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY)));
        contentContainer.setPadding(new Insets(10));
        VBox.setMargin(contentContainer, new Insets(0, 20, 0, 20));

        issueContainer = new HBox();
        issueContainer.setSpacing(20);
        issueContainer.setPadding(new Insets(5));

        issueLabel = new Label("Issue");
        this.issue = new Label(medicalRecord.getIssue());


        descriptionContainer = new HBox();
        descriptionContainer.setSpacing(20);
        descriptionContainer.setPadding(new Insets(5));

        descriptionLabel = new Label("Description");
        this.description = new Label(medicalRecord.getDescription());

        prescriptionContainer = new HBox();
        prescriptionContainer.setSpacing(20);
        prescriptionContainer.setPadding(new Insets(5));

        prescriptionLabel = new Label("Prescription");
        this.prescription = new Label(medicalRecord.getPrescription());

        followUpContainer = new HBox();
        followUpContainer.setSpacing(20);
        followUpContainer.setPadding(new Insets(5));

        followUpLabel = new Label("Follow Up");
        this.followUp = new Label(medicalRecord.getFollowUpDate());


        issueContainer.getChildren().addAll(issueLabel, this.issue);
        descriptionContainer.getChildren().addAll(descriptionLabel, this.description);
        prescriptionContainer.getChildren().addAll(prescriptionLabel, this.prescription);
        followUpContainer.getChildren().addAll(followUpLabel, this.followUp);

        contentContainer.getChildren().addAll(issueContainer, descriptionContainer, prescriptionContainer, followUpContainer);
    }

    public VBox getMedicalRecordCard() {
        return contentContainer;
    }
}
