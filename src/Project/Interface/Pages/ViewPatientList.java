package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Patient;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ViewPatientList extends TableListingView {
    private ObservableList<Patient> patients;
    public ViewPatientList(Parent prevPage) {
        super("Patient List", prevPage);

        patients = ClinicalSystem.getAllPatients();

        addColumn("ID");
        addColumn("Name");
        addColumn("Age");
        addColumn("Gender");
        addColumn("Contact");
        addColumn("Email");

        evenWidth();

        initTableData(patients);
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
