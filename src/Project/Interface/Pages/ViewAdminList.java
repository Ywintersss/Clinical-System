package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Users.Admin;
import Project.Users.Doctor;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.VBox;

public class ViewAdminList extends TableListingView {
    private ObservableList<Admin> admin;
    private final Button addAdmin;
    private Button deleteAdmin;
    public ViewAdminList() {
        super("Admin List");

        admin = ClinicalSystem.getUserDataManager().getAllAdmins();

        addColumn("ID");
        addColumn("Username");

        evenWidth();

        initTableData(admin);

        deleteAdmin = new Button("Delete");
        deleteAdmin.setOnAction(e -> {
            TableCell<?, ?> cell = (TableCell<?, ?>) ((Button) e.getSource()).getParent().getParent();
            int index = cell.getIndex();

            Admin admin = (Admin) getTableView().getItems().get(index);
            try{
                //Notification.confirmation("Are you sure?");
                ClinicalSystem.getUserDataManager().deleteUser("\\users\\Admin.txt", admin.getID());
                Notification.information("Deleted");
                ClinicalSystem.back();
                ClinicalSystem.navigateTo(new ViewAdminList().getTable());
            } catch (Exception exception) {
                Notification.error("Error Deleting");
            }
        });

        addColumnButtons(deleteAdmin);

        addAdmin = new Button("Add");
        addAdmin.setOnAction(e -> {
            ClinicalSystem.navigateTo(new AdminRegister().getRegisterForm());
        });

        addFunctionalButton(addAdmin);

    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
