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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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

    public void addContentContainer(String labelTitle) {
        contentContainer = new HBox();
        contentContainer.setSpacing(10);
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 40));

        contentLabel = new Label(labelTitle);
        contentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        contentField = new TextField();
        contentField.setPromptText(labelTitle);
        //contentField.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);

        registerForm.getChildren().add(contentContainer);
        contentContainer.getChildren().addAll(contentLabel, contentField);
    }

    public ArrayList<String> getTextFieldsData() {
        ArrayList<String> data = new ArrayList<>();
        ObservableList<Node> children = registerForm.getChildren();
        for (int i = 1; i < registerForm.getChildren().size(); i++) {
            ObservableList<Node> content = ((HBox) children.get(i)).getChildren();
            if (content.get(1) instanceof TextField) {
                data.add(((TextField) content.get(1)).getText());
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

    public void register(int flag, String ...data) {
        try {
            ClinicalSystem.register(flag, data);
            Notification.information("Registration Successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
