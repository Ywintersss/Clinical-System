package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Doctor;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class ViewDoctorList extends TableListingView {
    private ObservableList<Doctor> doctors;
    private final Button addDoctor;
    private Button updateDoctor;

    public ViewDoctorList() {
        super("Doctor List");

        doctors = ClinicalSystem.getUserDataManager().getAllDoctors();

        addColumn("ID");
        addColumn("Username");
        addColumn("Name");
        addColumn("Email");
        addColumn("Contact");
        addColumn("Specialization");
        addColumn("Position");

        evenWidth();

        initTableData(doctors);

        updateDoctor = new Button("Update");
        updateDoctor.setOnAction(e -> {
            //TODO get doctor
            DoctorEditProfile DoctorEditProfile = new DoctorEditProfile();

            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(event -> {
                //TODO delete doctor
            });

            ClinicalSystem.navigateTo(new DoctorEditProfile().getDetails());
        });

        addColumnButtons(updateDoctor);

        evenWidth();

        addDoctor = new Button("Add");
        addDoctor.setOnAction(e -> {
            ClinicalSystem.navigateTo(new DoctorRegister().getRegisterForm());
        });

        addFunctionalButton(addDoctor);
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}

