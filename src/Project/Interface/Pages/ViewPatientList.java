package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class ViewPatientList extends TableListingView {
    public ViewPatientList(Parent prevPage) {
        super("Patient List", prevPage);

        addColumn("ID");
        addColumn("Name");
        addColumn("Age");
        addColumn("Gender");
        addColumn("Address");
        addColumn("Contact");
        addColumn("Action");
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
