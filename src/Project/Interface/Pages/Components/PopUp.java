package Project.Interface.Pages.Components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PopUp {
    private VBox popUp;
    private Image profileImage;
    private Label username;
    private TextField usernameInput;
    private Label password;
    private TextField passwordInput;
    private Button login;
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

        register = new Button("Register");

        popUp.getChildren().addAll(profileImageView, username, usernameInput, password, passwordInput, login, register);
        popUp.setSpacing(10);
        popUp.setAlignment(Pos.CENTER);
        popUp.setPadding(new Insets(10, 30, 10, 30));
        popUp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        popUp.setVisible(false);
    }

    public VBox getPopUp() {
        return popUp;
    }
}
