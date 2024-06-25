package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Patient;
import javafx.collections.ObservableList;
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

        //flag 1: All Patients (Admin) CRUD operations
        //flag 2: All Patients (Doctor) View Medical Record
        if (flag == 1) {
            columnButton = new Button("Update");
            columnButton.setOnAction(e -> {
                int index = getButtonIndex(e);

                Patient patient = (Patient) getTableView().getItems().get(index);

                UserEditProfile userEditProfile = new UserEditProfile(patient);

                Button deleteButton = new Button("Delete");
                deleteButton.setOnAction(event -> {
                    try{
                        //Notification.confirmation("Are you sure?");
                        ClinicalSystem.getUserDataManager().deleteUser("\\users\\Patient.txt", patient.getID());
                        ClinicalSystem.getUserDataManager().removeAllRelated(patient.getID());
                        Notification.information("Deleted");
                        ClinicalSystem.back();
                        ClinicalSystem.refresh(new ViewPatientList(1).getTable());
                    } catch (Exception exception) {
                        Notification.error("Error Deleting");
                    }
                });

                userEditProfile.addButtonIntoContainer(deleteButton);

                ClinicalSystem.navigateTo(userEditProfile.getDetails());
            });

            addColumnButtons(columnButton);

            addPatient = new Button("Add");
            addPatient.setOnAction(e -> {
                ClinicalSystem.navigateTo(new PatientRegister(1).getRegisterForm());
            });

            addFunctionalButton(addPatient);
        } else if (flag == 2) {
            columnButton = new Button("View");
            columnButton.setOnAction(e -> {
                int index = getButtonIndex(e);

                Patient patient = (Patient) getTableView().getItems().get(index);

                MedicalRecordList MedicalRecordList = new MedicalRecordList(patient);

                Button add = new Button("Add");
                add.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
                add.setOnAction(event -> {
                    ClinicalSystem.navigateTo(new AddMedicalRecord(patient).getDetails());
                });

                MedicalRecordList.addButtonIntoContainer(add);

                ClinicalSystem.navigateTo(MedicalRecordList.getMedicalRecordList());
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
