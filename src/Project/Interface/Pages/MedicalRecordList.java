package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.MedicalRecordCard;
import Project.UserSession;
import Project.Users.Patient;
import Project.Records.MedicalRecord;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import static javafx.scene.text.Font.font;

public class MedicalRecordList {
    private ObservableList<MedicalRecord> patientMedicalRecordList;
    private ScrollPane medicalRecordScroller;
    private VBox medicalRecordContainer;
    private VBox medicalRecord;
    private Label title;
    private Region spacer;
    private HBox buttonContainer;
    private Region containerSpacer;
    private Button back;
    public MedicalRecordList(Patient patient) {
        if (patient == null) {
            patient = (Patient) UserSession.getInstance().getCurrentUser();
        }

        patientMedicalRecordList = ClinicalSystem.getRecorder().getPatientMedicalRecord(patient.getID());

        medicalRecord = new VBox();

        title = new Label("Medical Records");
        title.setFont(font("Verdana", FontWeight.BOLD, 25));
        title.setPadding(new Insets(25, 10, 10, 10));
        VBox.setMargin(title, new Insets(0, 20, 0, 20));

        spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        containerSpacer = new Region();
        HBox.setHgrow(containerSpacer, Priority.ALWAYS);

        back = new Button("Back");
        back.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
        back.setOnAction(e -> {
            ClinicalSystem.back();
        });

        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(back, containerSpacer);
        VBox.setMargin(buttonContainer, new Insets(0, 10, 20, 10));

        medicalRecordContainer = new VBox();
        medicalRecordContainer.setPadding(new Insets(10));
        medicalRecordContainer.setSpacing(20);

        for (MedicalRecord medicalRecord : patientMedicalRecordList) {
            medicalRecordContainer.getChildren().add(new MedicalRecordCard(medicalRecord).getMedicalRecordCard());
        }

        medicalRecordScroller = new ScrollPane(medicalRecord);
        medicalRecordScroller.setFitToWidth(true);
        medicalRecordScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        medicalRecordScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        medicalRecordScroller.setContent(medicalRecordContainer);

        medicalRecord.getChildren().addAll(title, medicalRecordScroller, spacer, buttonContainer);
    }

    public VBox getMedicalRecordList() {
        return medicalRecord;
    }

    public void addButtonIntoContainer(Button FuncButton) {
        buttonContainer.getChildren().add(FuncButton);
    }
}
