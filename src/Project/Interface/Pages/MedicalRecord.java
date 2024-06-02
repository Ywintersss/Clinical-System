package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
public class MedicalRecord extends TableListingView {
    public MedicalRecord(Parent prevPage) {
        super("Medical Record", prevPage);

        addColumn("Patient");
        addColumn("Issue");
        addColumn("Description");
        addColumn("FollowUp Date");


    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}