package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.layout.VBox;
public class AppointmentHistory extends TableListingView {
    public AppointmentHistory() {
        super("Appointment History");

        addColumn("Doctor");
        addColumn("Date Time");
        addColumn("Description");

        //Make appt button

    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}