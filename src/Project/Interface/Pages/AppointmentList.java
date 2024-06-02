package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class AppointmentList extends TableListingView {
    public AppointmentList(Parent prevPage) {
        super("Appointment List", prevPage);

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
