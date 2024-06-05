package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.Home;
import Project.Interface.Pages.PatientRegister;
import Project.Interface.Pages.Templates.PopUp;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class PopUpDefault extends PopUp {
    private Label username;
    private TextField usernameInput;
    private Label password;
    private TextField passwordInput;
    private Button login;
    private HBox registerContainer;
    private Label registerLabel;
    private Button register;

    public PopUpDefault() {
        username = new Label("Username");

        usernameInput = new TextField();
        usernameInput.setPromptText("Username");

        password = new Label("Password");

        passwordInput = new TextField();
        passwordInput.setPromptText("Password");

        login = new Button("Login");
        login.setOnAction(e -> {
            ClinicalSystem.login(usernameInput.getText(), passwordInput.getText());
            super.setVisible(false);
            usernameInput.clear();
            passwordInput.clear();
        });

        registerLabel = new Label("No account?");
        registerLabel.setFont(Font.font(10));
        register = new Button("Register");
        register.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new PatientRegister(new Home().getHome()).getRegisterForm());
            super.setVisible(false);
            usernameInput.clear();
            passwordInput.clear();
        });

        registerContainer = new HBox();
        registerContainer.setSpacing(6);
        registerContainer.setPadding(new Insets(10, 10, 10, 10));
        registerContainer.setAlignment(Pos.CENTER);
        registerContainer.getChildren().addAll(registerLabel, register);

        addContent(username, usernameInput, password, passwordInput, login, registerContainer);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }
}
