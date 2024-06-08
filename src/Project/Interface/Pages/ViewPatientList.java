package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Patient;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ViewPatientList extends TableListingView {
    private ObservableList<Patient> patients;
    private final Button addPatient;
    private final Button updatePatient;
    public ViewPatientList() {
        super("Patient List");

        patients = ClinicalSystem.getUserDataManager().getAllPatients();

        addColumn("ID");
        addColumn("Name");
        addColumn("Age");
        addColumn("Gender");
        addColumn("Contact");
        addColumn("Email");


        initTableData(patients);

        updatePatient = new Button("Update");
        updatePatient.setOnAction(e -> {
            //TODO get patient
            UserEditProfile userEditProfile = new UserEditProfile();

            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(event -> {
                //TODO delete patient
            });

            userEditProfile.addButtonIntoContainer(deleteButton);

            ClinicalSystem.navigateTo(userEditProfile.getDetails());
        });

        addColumnButtons(updatePatient);

        evenWidth();

        addPatient = new Button("Add");
        addPatient.setOnAction(e -> {
            ClinicalSystem.navigateTo(new PatientRegister().getRegisterForm());
        });

        addFunctionalButton(addPatient);
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
