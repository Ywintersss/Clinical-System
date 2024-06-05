package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddMedicalRecord extends DetailView {
    private TextField patient;
    private TextField issue;
    private TextField description;
    private TextField followUpDate;

    public AddMedicalRecord() {
        super("Add Medical Record", new Home().getHome());

        patient = new TextField();
        patient.setPromptText("Enter Patient's Name...");
        addContent("Patient",patient);

        issue = new TextField();
        issue.setPromptText("Enter Issue...");
        addContent("Issue",issue);

        description = new TextField();
        description.setPromptText("Enter Description...");
        addContent("Description",description);

        followUpDate = new TextField();
        followUpDate.setPromptText("Enter FollowUp Date...");
        addContent("FollowUp Date",followUpDate);

        addButtonIntoContainer("Save");
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}
