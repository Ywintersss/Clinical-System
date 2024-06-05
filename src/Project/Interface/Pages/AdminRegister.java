package Project.Interface.Pages;

import Project.Interface.Pages.Templates.Register;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class AdminRegister extends Register {

    public AdminRegister(Parent previousPage) {
        super("Register Admin",  previousPage);

        addContentContainer("Username");
        addContentContainer("Password");

        addButtonContainer(new ViewAdminList(previousPage).getTable());
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
