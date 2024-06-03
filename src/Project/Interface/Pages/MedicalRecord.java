package Project.Interface.Pages;

import Project.Interface.Pages.Components.MedicalRecordCard;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import static javafx.scene.text.Font.font;

public class MedicalRecord {
    private VBox MedicalRecord;
    private Label title;

    public MedicalRecord() {
        MedicalRecord = new VBox();
        MedicalRecord.setPadding(new Insets(10));
        MedicalRecord.setSpacing(20);

        title = new Label("Medical Record");
        title.setFont(font("Verdana", FontWeight.BOLD, 25));
        title.setPadding(new Insets(25, 10, 10, 10));
        VBox.setMargin(title, new Insets(0, 0, 0, 30));

        MedicalRecord.getChildren().addAll(title);

        for (int i = 0; i < 2; i++) {
            MedicalRecord.getChildren().add(new MedicalRecordCard("Azoospermia","No sperm.","6/7/2024").getMedicalRecordCard());
        }
    }

    public VBox getMedicalRecord() {
        return MedicalRecord;
    }
}
