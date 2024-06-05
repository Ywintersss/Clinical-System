package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Doctor;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public class ViewDoctorList extends TableListingView {
    private ObservableList<Doctor> doctor;
    private final Button addDoctor;
    private Button updateDoctor;

    public ViewDoctorList(Parent previousPage) {
        super("Doctor List", previousPage);

        doctor = ClinicalSystem.getAllDoctors();

        addColumn("ID");
        addColumn("Username");
        addColumn("Name");
        addColumn("Email");
        addColumn("Contact");
        addColumn("Specialization");
        addColumn("Position");

        evenWidth();

        initTableData(doctor);

        updateDoctor = new Button("Update");
        updateDoctor.setOnAction(e -> {
            //TODO get doctor
            DoctorEditProfile DoctorEditProfile = new DoctorEditProfile(new ViewDoctorList(previousPage).getTable());

            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(event -> {
                //TODO delete doctor
            });

            ClinicalSystem.getLayout().setContent(new DoctorEditProfile(new ViewDoctorList(previousPage).getTable()).getDetails());
        });

        addColumnButtons(updateDoctor);

        evenWidth();

        addDoctor = new Button("Add");
        addDoctor.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new DoctorRegister(new ViewDoctorList(previousPage).getTable()).getRegisterForm());
        });

        addFunctionalButton(addDoctor);
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}

