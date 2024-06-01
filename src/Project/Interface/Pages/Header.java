package Project.Interface.Pages;

import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Header{
    private HBox header;
    private Button profileBtn;
    private Region spacer1;
    private Label clinicTitle;
    private Region spacer2;
    private Button logout;
    public Header(VBox popUp) {
        header = new HBox();

        profileBtn = new Button();
        profileBtn.setText("Profile");

        profileBtn.setOnAction(e -> {
            popUp.setVisible(!popUp.isVisible());
        });
        profileBtn.setPadding(new Insets(10, 10, 10, 10));
        HBox.setMargin(profileBtn, new Insets(5, 0, 5, 10));

        spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        clinicTitle = new Label("I-Care Clinic");
        clinicTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        logout = new Button("Logout");
        logout.setPadding(new Insets(10, 10, 10, 10));
        HBox.setMargin(logout, new Insets(5, 10, 5, 0));

        //header.setSpacing(ScreenTools.getScreenWidth() * 0.25);
        header.setAlignment(Pos.CENTER);
        header.getChildren().addAll(profileBtn, spacer1, clinicTitle, spacer2, logout);
        header.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1, 0,2,0))));
        header.setStyle("-fx-background-color: #F6DAE4;");


    }
    public HBox getHeaderNode() {
        return this.header;
    }
}
