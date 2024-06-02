package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
public class Appointment extends TableListingView {
    public Appointment(Parent prevPage) {
        super("Appointment History", prevPage);

        addColumn("Patient");
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