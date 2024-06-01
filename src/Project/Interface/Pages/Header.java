package Project.Interface.Pages;

import Project.Interface.Pages.Components.PopUp;
import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Popup;

public class Header{
    private HBox header;
    private Button profileBtn;

    private Label clinicTitle;
    public Header(VBox popUp) {
        header = new HBox();

        profileBtn = new Button();
        profileBtn.setText("Profile");

        profileBtn.setOnAction(e -> {
            popUp.setVisible(!popUp.isVisible());
        });
        profileBtn.setPadding(new Insets(10, 10, 10, 10));

        clinicTitle = new Label("I-Care Clinic");
        clinicTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

        header.setSpacing(ScreenTools.getScreenWidth() * 0.25);
        header.setAlignment(Pos.CENTER_LEFT);
        header.getChildren().addAll(profileBtn, clinicTitle);
        header.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1, 0,2,0))));
        header.setStyle("-fx-background-color: #F6DAE4;");


    }
    public HBox getHeaderNode() {
        return this.header;
    }
}
