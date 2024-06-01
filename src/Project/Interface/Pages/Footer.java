package Project.Interface.Pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Footer {
    VBox footer;
    HBox reviewContainer;
    Button reviewBtn;
    Label copyRight;
    TextField reviewInput;

    public Footer() {
        footer = new VBox();


        reviewBtn = new Button();
        reviewBtn.setText("Review");

        reviewInput = new TextField();
        reviewInput.setPromptText("Feedback");

        copyRight = new Label();
        copyRight.setText("© 2024 I-Care Clinic . All rights reserved.");
        copyRight.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        copyRight.setPadding(new Insets(10, 10, 10, 10));
        copyRight.setAlignment(Pos.CENTER);

        reviewContainer = new HBox();
        reviewContainer.setSpacing(10);
        reviewContainer.setPadding(new Insets(10, 10, 10, 10));
        reviewContainer.setAlignment(Pos.CENTER);
        reviewContainer.getChildren().addAll(reviewInput, reviewBtn);

        footer.setAlignment(Pos.CENTER);
        footer.getChildren().addAll(reviewContainer, copyRight);
        footer.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2, 0,1,0))));
        footer.setBackground(new Background(new BackgroundFill(Color.LAVENDER,CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public VBox getFooterNode() {
        return this.footer;
    }
}
