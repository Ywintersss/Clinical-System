package Project.Interface.Pages.Components;

import Project.Utilities.Styles;
import Project.Utilities.Utilities;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.*;


public class UploadBox {
    private VBox uploadBox;
    private Label startLabel;
    private TextField startTime;
    private Label endLabel;
    private TextField endTime;
    private Label dateLabel;
    private ComboBox<String> date;
    private Button takeLeave;
    private Button upload;
    public UploadBox() {
        uploadBox = new VBox();
        uploadBox.setStyle(Styles.backgroundColour("#B0B0B0") + Styles.padding(10));
        uploadBox.setSpacing(10);
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setMaxWidth(250);
        uploadBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        uploadBox.setVisible(false);
        uploadBox.toFront();

        startLabel = new Label("Start Time");
        startLabel.setStyle(Styles.fontFamily + Styles.fontWeightTitle + Styles.fontSize(15));

        endLabel = new Label("End Time");
        endLabel.setStyle(Styles.fontFamily + Styles.fontWeightTitle + Styles.fontSize(15));

        dateLabel = new Label("Date");
        dateLabel.setStyle(Styles.fontFamily + Styles.fontWeightTitle + Styles.fontSize(15));

        startTime = new TextField();
        startTime.setPromptText("HH:MM");
        startTime.setStyle(Styles.padding(6));

        endTime = new TextField();
        endTime.setPromptText("HH:MM");
        endTime.setStyle(Styles.padding(6));

        date = new ComboBox<>();
        date.setPromptText("DD-MM-YYYY");
        date.getItems().addAll("Today", Utilities.getCurrentDate(1), Utilities.getCurrentDate(2), Utilities.getCurrentDate(3), Utilities.getCurrentDate(4));

        takeLeave = new Button("Take Leave");
        takeLeave.setStyle(Styles.fontWeightTitle);
        takeLeave.setOnAction(e -> {
            return;
        });

        upload = new Button("Upload");
        upload.setStyle(Styles.fontWeightTitle + Styles.fontSize(15) + Styles.padding(10, 20, 10, 20));
        upload.setOnAction(e -> {

        });

        uploadBox.getChildren().addAll(startLabel, startTime, endLabel, endTime, dateLabel, date, takeLeave, upload);
        uploadBox.setVisible(false);
    }
    public VBox getUploadBox() {
        return uploadBox;
    }
}
