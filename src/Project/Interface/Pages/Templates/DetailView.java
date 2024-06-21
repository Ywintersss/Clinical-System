package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

import java.util.ArrayList;

public abstract class DetailView {
    private VBox details;
    private Label Title;
    private VBox contentContainer;
    private HBox buttonContainer;
    private Region containerSpacer;

    private HBox selectionContainer;
    private Label selectionLabel;
    private Region spacer;
    private ComboBox<String> selectionField;

    private Button back;
    private CornerRadii borderRadius = new CornerRadii(4);
    public DetailView(String title) {
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
            ClinicalSystem.back();
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

    public void addDatePicker(String labelTitle, DatePicker datePicker) {
        HBox dateContainer = new HBox();
        dateContainer.setAlignment(Pos.CENTER_LEFT);
        dateContainer.setSpacing(25);
        dateContainer.setPadding(new Insets(15, 0, 0, 0));

        Label Title = new Label(labelTitle);
        Title.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        Title.setAlignment(Pos.CENTER);

        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            datePicker.setValue(null);
        });

        datePicker.setPromptText(labelTitle);

        dateContainer.getChildren().addAll(Title, datePicker, clear);

        contentContainer.getChildren().add(dateContainer);
    }

    public void addSelectionContainer(String labelTitle, String[] options) {
        selectionContainer = new HBox();
        selectionContainer.setAlignment(Pos.CENTER_LEFT);
        VBox.setMargin(selectionContainer, new Insets(15, 0, 0, 0));

        selectionLabel = new Label(labelTitle);
        selectionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        selectionLabel.setAlignment(Pos.CENTER);

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        selectionField = new ComboBox<>();
        selectionField.setPromptText("Select " + labelTitle);
        selectionField.getItems().addAll(options);
        selectionField.setPrefWidth(ScreenTools.getScreenWidth() * 0.22);
        Background background = new Background(new BackgroundFill( Color.WHITE, borderRadius, null));
        selectionField.setBackground(background);
        selectionField.setPadding(new Insets(4, 4, 4, 4));

        selectionContainer.getChildren().addAll(selectionLabel, spacer, selectionField);
        contentContainer.getChildren().add(selectionContainer);
    }

    public void addSelectionContainer(String labelTitle, ComboBox<String> selectionField) {
        selectionField.setPrefWidth(ScreenTools.getScreenWidth() * 0.22);
        Background background = new Background(new BackgroundFill( Color.WHITE, borderRadius, null));
        selectionField.setBackground(background);
        selectionField.setPadding(new Insets(4, 4, 4, 4));

        selectionContainer = new HBox();
        selectionContainer.setAlignment(Pos.CENTER_LEFT);
        selectionContainer.setSpacing(55);;

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        selectionLabel = new Label(labelTitle);
        selectionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        selectionLabel.setAlignment(Pos.CENTER);

        selectionContainer.getChildren().addAll(selectionLabel, spacer, selectionField);
        contentContainer.getChildren().add(selectionContainer);
    }

    public void addButtonIntoContainer(String buttonLabel) {
        Button button = new Button(buttonLabel);

        buttonContainer.getChildren().add(button);
    }
    public void addButtonIntoContainer(Button FuncButton) {
        buttonContainer.getChildren().add(FuncButton);
    }

    public void moveButtonContainerToBottom(){
        details.getChildren().remove(buttonContainer);
        details.getChildren().add(buttonContainer);
    }


    public VBox getContentContainer() {
        return contentContainer;
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }

    public ArrayList<String> getInputData() {
        ArrayList<String> data = new ArrayList<>();
        ObservableList<Node> children = contentContainer.getChildren();
        for (int i = 1; i < children.size(); i++) {
            ObservableList<Node> content = ((Parent) children.get(i)).getChildrenUnmodifiable();
            if (content.get(1) instanceof TextField) {
                data.add(((TextField) content.get(1)).getText());
            }
            if (content.get(1) instanceof ComboBox) {
                data.add(((ComboBox) content.get(1)).getSelectionModel().getSelectedItem().toString());
            }
            if (content.get(1) instanceof DatePicker) {
                data.add(((DatePicker) content.get(1)).getValue().toString());
            }
        }
        return data;
    }
}
