package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Users.Gender;
import Project.Utilities.ScreenTools;
import Project.Utilities.Utilities;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public abstract class Register {
    private VBox registerContainer;
    private ScrollPane registerScroll;
    private VBox registerForm;
    private Label registerTitle;

    private HBox contentContainer;
    private Label contentLabel;
    private TextField contentField;

    private HBox selectionContainer;
    private Label selectionLabel;
    private ComboBox<String> selectionField;

    private HBox buttonContainer;
    private Region spacer;
    private Button register;
    private Button back;

    public Register(String title) {
        registerForm = new VBox();
        registerForm.setSpacing(25);
        registerForm.setPadding(new Insets(10, 10, 10, 10));
        registerForm.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");

        registerTitle = new Label(title);
        registerTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        VBox.setMargin(registerTitle, new Insets(12, 0, 0, 40));

        registerScroll = new ScrollPane();
        registerScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        registerScroll.setFitToWidth(true);
        registerScroll.setContent(registerForm);

        registerContainer = new VBox();
        registerContainer.getChildren().addAll(registerTitle, registerScroll);

        registerForm.getChildren().addAll(registerTitle);
    }

    public VBox getRegisterForm() {
        return registerContainer;
    }

    public void addContentContainer(String labelTitle,String promptText) {
        contentContainer = new HBox();
        contentContainer.setSpacing(10);
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 40));

        contentLabel = new Label(labelTitle);
        contentLabel.setPrefWidth(185);
        contentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        contentField = new TextField();
        contentField.setPromptText(promptText);
        contentField.setPrefWidth(ScreenTools.getScreenWidth() * 0.18);

        registerForm.getChildren().add(contentContainer);
        contentContainer.getChildren().addAll(contentLabel, contentField);
    }

    public void addSelectionContainer (String labelTitle, String promptText, String[] options) {
        selectionContainer = new HBox();
        VBox.setMargin(selectionContainer, new Insets(8, 0, 0, 40));

        selectionLabel = new Label(labelTitle);
        selectionLabel.setPrefWidth(195);
        selectionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        selectionLabel.setPadding(new Insets(10, -20, 10, 0));

        selectionField = new ComboBox<>();
        selectionField.setPromptText(promptText);
        selectionField.getItems().addAll(options);
        selectionField.setPrefWidth(ScreenTools.getScreenWidth() * 0.18);

        registerForm.getChildren().add(selectionContainer);
        selectionContainer.getChildren().addAll(selectionLabel, selectionField);
    }

    public ArrayList<String> getTextFieldsData() {
        ArrayList<String> data = new ArrayList<>();
        ObservableList<Node> children = registerForm.getChildren();
        for (int i = 1; i < registerForm.getChildren().size(); i++) {
            ObservableList<Node> content = ((HBox) children.get(i)).getChildren();
            if (content.get(1) instanceof TextField) {
                data.add(((TextField) content.get(1)).getText());
            }
            if (content.get(1) instanceof ComboBox) {
                data.add(((ComboBox) content.get(1)).getSelectionModel().getSelectedItem().toString());
            }
        }
        return data;
    }

    public void addButtonContainer(Button register){
        back = new Button("Back");
        back.setPrefHeight(40);
        back.setPrefWidth(100);
        back.setOnAction(e ->{
            ClinicalSystem.back();
        });

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.getChildren().addAll(back, spacer, register);

        registerForm.getChildren().add(buttonContainer);
    }

    public HBox getContentContainer() {
        return contentContainer;
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }

    public boolean register(int flag, String ...data) {
        try {
            boolean success = ClinicalSystem.register(flag, data);
            if (success) {
                Notification.information("Registration Successful");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return false;
    }
}
