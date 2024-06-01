package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.Register;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PopUp {
    private VBox popUp;
    private Image profileImage;
    private Label username;
    private TextField usernameInput;
    private Label password;
    private TextField passwordInput;
    private Button login;
    private HBox registerContainer;
    private Label registerLabel;
    private Button register;

    public PopUp() {
        popUp = new VBox();

        profileImage = new Image("/Project/Interface/Assets/Icons/profile.png");
        ImageView profileImageView = new ImageView(profileImage);
        profileImageView.setFitHeight(100);
        profileImageView.setFitWidth(100);
        profileImageView.setPreserveRatio(true);

        username = new Label("Username");

        usernameInput = new TextField();
        usernameInput.setPromptText("Username");

        password = new Label("Password:");

        passwordInput = new TextField();
        passwordInput.setPromptText("Password");

        login = new Button("Login");
        login.setOnAction(e -> {
            ClinicalSystem.login(usernameInput.getText(), passwordInput.getText());
            popUp.setVisible(false);
            usernameInput.clear();
            passwordInput.clear();
        });

        registerLabel = new Label("Don't have an account?");
        registerLabel.setFont(Font.font(10));
        register = new Button("Register");
        register.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new Register().getRegisterForm());
            popUp.setVisible(false);
            usernameInput.clear();
            passwordInput.clear();
        });

        registerContainer = new HBox();
        registerContainer.setSpacing(6);
        registerContainer.setPadding(new Insets(10, 10, 10, 10));
        registerContainer.setAlignment(Pos.CENTER);
        registerContainer.getChildren().addAll(registerLabel, register);

        popUp.getChildren().addAll(profileImageView, username, usernameInput, password, passwordInput, login, registerContainer);
        popUp.setSpacing(10);
        popUp.setAlignment(Pos.CENTER);
        popUp.setPadding(new Insets(10, 20, 10, 20));
        popUp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        popUp.setVisible(false);
    }

    public VBox getPopUp() {
        return popUp;
    }
}
