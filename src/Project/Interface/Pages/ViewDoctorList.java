package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Doctor;
import Project.Users.Patient;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.VBox;

import javax.print.Doc;


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
            TableCell<?, ?> cell = (TableCell<?, ?>) ((Button) e.getSource()).getParent().getParent();
            int index = cell.getIndex();

            Doctor doctor = (Doctor) getTableView().getItems().get(index);

            //TODO get doctor
            DoctorEditProfile DoctorEditProfile = new DoctorEditProfile(doctor);

            Button deleteButton = new Button("Delete");
            deleteButton.setOnAction(event -> {
                //TODO delete doctor
            });

            DoctorEditProfile.addButtonIntoContainer(deleteButton);

            ClinicalSystem.navigateTo(DoctorEditProfile.getDetails());
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

