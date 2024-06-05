package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Admin;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ViewAdminList extends TableListingView {
    private ObservableList<Admin> admin;
    private final Button addAdmin;
    private Button deleteAdmin;
    public ViewAdminList(Parent previousPage) {
        super("Admin List", previousPage);

        admin = ClinicalSystem.getAllAdmins();

        addColumn("ID");
        addColumn("Username");

        evenWidth();

        initTableData(admin);

        deleteAdmin = new Button("Delete");
        deleteAdmin.setOnAction(e -> {
            //TODO delete admin
        });

        addColumnButtons(deleteAdmin);

        addAdmin = new Button("Add");
        addAdmin.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new AdminRegister(new ViewAdminList(previousPage).getTable()).getRegisterForm());
        });

        addFunctionalButton(addAdmin);

    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
