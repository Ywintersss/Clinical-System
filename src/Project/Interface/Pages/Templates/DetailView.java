package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public abstract class DetailView {
    private VBox details;
    private Label Title;
    private VBox contentContainer;
    private HBox buttonContainer;
    private Region containerSpacer;
    private Button back;
    private CornerRadii borderRadius = new CornerRadii(4);
    public DetailView(String title, Parent previousPage) {
        details = new VBox();
        details.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");


        Title = new Label(title);
        Title.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        Title.setPadding(new Insets(0, 10, 20, 10));

        contentContainer = new VBox();
        contentContainer.setAlignment(Pos.CENTER);
        contentContainer.setSpacing(10);
        contentContainer.setPadding(new Insets(20));
        contentContainer.setStyle("-fx-background-color: #799CED; -fx-background-radius: 4px;");
        contentContainer.getChildren().add(Title);

        buttonContainer = new HBox();

        containerSpacer = new Region();

        HBox.setHgrow(containerSpacer, Priority.ALWAYS);

        back = new Button("Back");
        back.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(previousPage);
        });

        buttonContainer.getChildren().addAll(back, containerSpacer);
        buttonContainer.setSpacing(10);

        details.setSpacing(20);
        details.setAlignment(Pos.TOP_CENTER);
        details.setPadding(new Insets(30, 20, 10, 20));
        details.setPrefHeight(ScreenTools.getScreenHeight() * 0.8);
        details.getChildren().addAll(contentContainer, buttonContainer);
    }

    public VBox getDetails() {
        return details;
    }

    public void addContent(String labelTitle, Node content) {
        VBox contentBox = new VBox();

        Label Title = new Label(labelTitle);
        Title.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        Background background = new Background(new BackgroundFill(Color.WHITE, borderRadius, Insets.EMPTY));

        if (!(content instanceof Label) && !(content instanceof TextField)) {
            return;
        }

        ((Control) content).setBackground(background);
        ((Control) content).setPadding(new Insets(4, 4, 4, 4));
        ((Control) content).prefWidthProperty().bind(contentContainer.widthProperty());

        contentBox.setAlignment(Pos.CENTER_LEFT);
        contentBox.setSpacing(2);
        contentBox.getChildren().addAll(Title,(content));

        contentContainer.getChildren().add(contentBox);
    }

    public void addButtonIntoContainer(String buttonLabel) {
        Button button = new Button(buttonLabel);

        buttonContainer.getChildren().add(button);
    }

    public void addButtonIntoContainer(Button FuncButton) {
        buttonContainer.getChildren().add(FuncButton);
    }

    public VBox getContentContainer() {
        return contentContainer;
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }
}
