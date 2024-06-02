package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class AppointmentSchedule extends TableListingView {
    public AppointmentSchedule(String title, Parent previousPage) {
        super(title, previousPage);
        addColumn("Date Time");
        addColumn("Doctor");
        addColumn("Description");
        addColumn("Patient");
        addColumn("Status");
        addColumn("Action");
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }



}
