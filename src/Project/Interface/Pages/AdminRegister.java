package Project.Interface.Pages;

import Project.Interface.Pages.Templates.Register;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class AdminRegister extends Register {

    public AdminRegister() {
        super("Register Admin");

        addContentContainer("Username");
        addContentContainer("Password");

        //addButtonContainer();
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
