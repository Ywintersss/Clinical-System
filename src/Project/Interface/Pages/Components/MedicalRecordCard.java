package Project.Interface.Pages.Components;

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

    private HBox followUpContainer;
    private Label followUpLabel;
    private Label followUp;

    public MedicalRecordCard(String issue, String description, String followUp) {
        contentContainer = new VBox();
        contentContainer.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY)));
        contentContainer.setPadding(new Insets(10));
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 35));

        issueContainer = new HBox();
        issueContainer.setSpacing(20);
        issueContainer.setPadding(new Insets(5));

        issueLabel = new Label("Issue");
        this.issue = new Label(issue);


        descriptionContainer = new HBox();
        descriptionContainer.setSpacing(20);
        descriptionContainer.setPadding(new Insets(5));

        descriptionLabel = new Label("Description");
        this.description = new Label(description);


        followUpContainer = new HBox();
        followUpContainer.setSpacing(20);
        followUpContainer.setPadding(new Insets(5));

        followUpLabel = new Label("Follow Up");
        this.followUp = new Label(followUp);


        issueContainer.getChildren().addAll(issueLabel, this.issue);
        descriptionContainer.getChildren().addAll(descriptionLabel, this.description);
        followUpContainer.getChildren().addAll(followUpLabel, this.followUp);

        contentContainer.getChildren().addAll(issueContainer, descriptionContainer, followUpContainer);
    }

    public VBox getMedicalRecordCard() {
        return contentContainer;
    }
}
