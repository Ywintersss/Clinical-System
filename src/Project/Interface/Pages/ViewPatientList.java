package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Patient;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ViewPatientList extends TableListingView {
    private ObservableList<Patient> patients = ClinicalSystem.getUserDataManager().getAllPatients();
    private Button addPatient;
    private Button columnButton;
    public ViewPatientList(int flag) {
        super("Patient List");

        addColumn("ID");
        addColumn("Name");
        addColumn("Age");
        addColumn("Gender");
        addColumn("Contact");
        addColumn("Email");


        initTableData(patients);

        if (flag == 1) {
            columnButton = new Button("Update");
            columnButton.setOnAction(e -> {
                //TODO get patient
                UserEditProfile userEditProfile = new UserEditProfile();

                Button deleteButton = new Button("Delete");
                deleteButton.setOnAction(event -> {
                    //TODO delete patient
                });

                userEditProfile.addButtonIntoContainer(deleteButton);

                ClinicalSystem.navigateTo(userEditProfile.getDetails());
            });

            addColumnButtons(columnButton);

            addPatient = new Button("Add");
            addPatient.setOnAction(e -> {
                ClinicalSystem.navigateTo(new PatientRegister().getRegisterForm());
            });

            addFunctionalButton(addPatient);
        } else if (flag == 2) {
            columnButton = new Button("View");
            columnButton.setOnAction(e -> {
                //TODO get patient
                MedicalRecord MedicalRecord = new MedicalRecord();

                Button add = new Button("Add");
                add.setOnAction(event -> {
                    //TODO delete patient
                });

                MedicalRecord.addButtonIntoContainer(add);

                ClinicalSystem.navigateTo(MedicalRecord.getMedicalRecord());
            });

            addColumnButtons(columnButton);
        }
        evenWidth();
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
