package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AppointmentList extends TableListingView {
    public AppointmentList() {
        super("Appointment List");

        addColumn("Patient");
        addColumn("Doctor");
        addColumn("Date Time");
        addColumn("Description");
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
