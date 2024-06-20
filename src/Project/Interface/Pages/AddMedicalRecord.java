package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.DetailView;
import Project.Users.Patient;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AddMedicalRecord extends DetailView {
    private TextField issue;
    private TextField description;
    private TextField prescription;
    private TextField followUpDate;

    public AddMedicalRecord(Patient patient) {
        super("Add Medical Record");

        issue = new TextField();
        issue.setPromptText("Enter Issue...");
        addContent("Issue",issue);

        description = new TextField();
        description.setPromptText("Enter Description...");
        addContent("Description",description);

        prescription = new TextField();
        prescription.setPromptText("Enter Prescription...");
        addContent("Prescription",prescription);

        followUpDate = new TextField();
        followUpDate.setPromptText("Enter FollowUp Date...");
        addContent("FollowUp Date",followUpDate);

        Button save = new Button("Save");
        save.setPrefHeight(40);
        save.setPrefWidth(100);

        save.setOnAction(e ->{
            ArrayList<String> data = getInputData();
            System.out.println(data);

            String issue = data.get(0);
            String description = data.get(1);
            String followUpDate = data.get(2);
            String prescription = data.get(3);

            ClinicalSystem.getRecorder().addRecord(patient.getID(), issue, prescription, description, followUpDate);

            ClinicalSystem.back();
            ClinicalSystem.refresh(new MedicalRecordList(patient).getMedicalRecordList());
        });

        addButtonIntoContainer(save);
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}
