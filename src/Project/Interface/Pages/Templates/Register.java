package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public abstract class Register {
    private VBox registerForm;
    private Label registerTitle;

    private HBox contentContainer;
    private Label contentLabel;
    private TextField contentField;

    private HBox buttonContainer;
    private Button register;
    private Button back;

    public Register(String title) {
        registerForm = new VBox();
        registerForm.setSpacing(25);
        registerForm.setPadding(new Insets(10, 10, 10, 10));
        registerForm.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        registerForm.setPrefHeight(ScreenTools.getScreenHeight() * 0.8);
        registerForm.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");

        registerTitle = new Label(title);
        registerTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        VBox.setMargin(registerTitle, new Insets(12, 0, 0, 40));

        registerForm.getChildren().addAll(registerTitle);
    }

    public VBox getRegisterForm() {
        return registerForm;
    }

    public void addContentContainer(String labelTitle) {
        contentContainer = new HBox();
        contentContainer.setSpacing(10);
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 40));

        contentLabel = new Label(labelTitle);
        contentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        contentField = new TextField();
        contentField.setPromptText(labelTitle);
        contentField.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);

        registerForm.getChildren().add(contentContainer);
        contentContainer.getChildren().addAll(contentLabel, contentField);
    }

    public void addButtonContainer(){
        register = new Button("Register");
        register.setPrefHeight(40);
        register.setPrefWidth(100);

        register.setOnAction(e ->{
            //ClinicalSystem.register(username.getText(), password.getText(), name.getText(), email.getText(), phoneNumber.getText(), gender.getText(), height.getText(), weight.getText());
        });

        back = new Button("Back");
        back.setPrefHeight(40);
        back.setPrefWidth(100);
        back.setOnAction(e ->{
            ClinicalSystem.back();
        });

        buttonContainer = new HBox();
        VBox.setMargin(buttonContainer, new Insets(0, 0, 0, 240));
        buttonContainer.setSpacing(10);
        buttonContainer.getChildren().addAll(back,register);

        registerForm.getChildren().add(buttonContainer);
    }

    public HBox getContentContainer() {
        return contentContainer;
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }


}
