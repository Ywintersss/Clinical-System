package Project.Interface.Pages;

import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Register {
    private VBox registerForm;
    private Label registerTitle;

    private HBox usernameContainer;
    private Label usernameLabel;
    private TextField username;

    private HBox passwordContainer;
    private Label passwordLabel;
    private TextField password;

    private HBox nameContainer;
    private Label nameLabel;
    private TextField name;

    private HBox emailContainer;
    private Label emailLabel;
    private TextField email;

    private HBox phoneNumberContainer;
    private Label phoneNumberLabel;
    private TextField phoneNumber;

    private HBox genderContainer;
    private Label genderLabel;
    private TextField gender;

    private HBox heightContainer;
    private Label heightLabel;
    private TextField height;

    private HBox weightContainer;
    private Label weightLabel;
    private TextField weight;

    private HBox buttonContainer;
    private Button register;
    private Button back;

    public Register() {
        registerForm = new VBox();
        registerForm.setSpacing(25);
        registerForm.setPadding(new Insets(10, 10, 10, 10));
        registerForm.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        registerForm.setPrefHeight(ScreenTools.getScreenHeight() * 0.8);

        registerTitle = new Label("Register Form");
        registerTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        registerForm.getChildren().add(registerTitle);
        VBox.setMargin(registerTitle, new Insets(30, 0, 0, 40));

        // Form Fields
        usernameContainer = new HBox();
        usernameContainer.setSpacing(10);
        usernameLabel = new Label("Username");
        usernameLabel.setFont(Font.font("Verdana",  15));
        username = new TextField();
        username.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        username.setPromptText("Username");
        usernameContainer.getChildren().addAll(usernameLabel, username);
        VBox.setMargin(usernameContainer, new Insets(0, 0, 0, 40));

        passwordContainer = new HBox();
        passwordContainer.setSpacing(10);
        passwordLabel = new Label("Password");
        passwordLabel.setFont(Font.font("Verdana",  15));
        password = new TextField();
        password.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        password.setPromptText("Password");
        passwordContainer.getChildren().addAll(passwordLabel, password);
        VBox.setMargin(passwordContainer, new Insets(0, 0, 0, 40));

        nameContainer = new HBox();
        nameContainer.setSpacing(10);
        nameLabel = new Label("Name");
        nameLabel.setFont(Font.font("Verdana",  15));
        name = new TextField();
        name.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        name.setPromptText("Name");
        nameContainer.getChildren().addAll(nameLabel, name);
        VBox.setMargin(nameContainer, new Insets(0, 0, 0, 40));

        emailContainer = new HBox();
        emailContainer.setSpacing(10);
        emailLabel = new Label("Email");
        emailLabel.setFont(Font.font("Verdana",  15));
        email = new TextField();
        email.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        email.setPromptText("Email");
        emailContainer.getChildren().addAll(emailLabel, email);
        VBox.setMargin(emailContainer, new Insets(0, 0, 0, 40));

        phoneNumberContainer = new HBox();
        phoneNumberContainer.setSpacing(10);
        phoneNumberLabel = new Label("Phone Number");
        phoneNumberLabel.setFont(Font.font("Verdana",  15));
        phoneNumber = new TextField();
        phoneNumber.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        phoneNumber.setPromptText("Phone Number");
        phoneNumberContainer.getChildren().addAll(phoneNumberLabel, phoneNumber);
        VBox.setMargin(phoneNumberContainer, new Insets(0, 0, 0, 40));

        genderContainer = new HBox();
        genderContainer.setSpacing(10);
        genderLabel = new Label("Gender");
        genderLabel.setFont(Font.font("Verdana",  15));
        gender = new TextField();
        gender.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        gender.setPromptText("Gender");
        genderContainer.getChildren().addAll(genderLabel, gender);
        VBox.setMargin(genderContainer, new Insets(0, 0, 0, 40));

        heightContainer = new HBox();
        heightContainer.setSpacing(10);
        heightLabel = new Label("Height");
        heightLabel.setFont(Font.font("Verdana",  15));
        height = new TextField();
        height.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        height.setPromptText("Height");
        heightContainer.getChildren().addAll(heightLabel, height);
        VBox.setMargin(heightContainer, new Insets(0, 0, 0, 40));

        weightContainer = new HBox();
        weightContainer.setSpacing(10);
        weightLabel = new Label("Weight");
        weightLabel.setFont(Font.font("Verdana",  15));
        weight = new TextField();
        weight.setPrefWidth(ScreenTools.getScreenWidth() * 0.3);
        weight.setPromptText("Weight");
        weightContainer.getChildren().addAll(weightLabel, weight);
        VBox.setMargin(weightContainer, new Insets(0, 0, 0, 40));

        registerForm.getChildren().addAll(usernameContainer, passwordContainer, nameContainer, emailContainer, phoneNumberContainer, genderContainer, heightContainer, weightContainer);

        register = new Button("Register");
        register.setStyle("-fx-background-color: #fa8fb1; -fx-text-fill: #FFFFFF;-fx-font-size: 16;-fx-font-weight: bold;");
        register.setPrefHeight(40);
        register.setPrefWidth(100);

        back = new Button("Back");
        back.setStyle("-fx-background-color: #fa8fb1; -fx-text-fill: #FFFFFF;-fx-font-size: 16;-fx-font-weight: bold;");
        back.setPrefHeight(40);
        back.setPrefWidth(100);

        buttonContainer = new HBox();
        VBox.setMargin(buttonContainer, new Insets(0, 0, 0, 210));
        buttonContainer.setSpacing(10);
        buttonContainer.getChildren().addAll(back,register);
        registerForm.getChildren().add(buttonContainer);
    }

    public VBox getRegisterForm() {
        return registerForm;
    }



}
