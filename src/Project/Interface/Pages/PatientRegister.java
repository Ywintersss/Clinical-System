package Project.Interface.Pages;

import Project.Interface.Pages.Templates.Register;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class PatientRegister extends Register {

    public PatientRegister() {
        super("Register Patient");

        addContentContainer("Username");
        addContentContainer("Password");
        addContentContainer("Name");
        addContentContainer("Email");
        addContentContainer("Phone Number");
        addContentContainer("Age");
        addContentContainer("Gender");
        addContentContainer("Height");
        addContentContainer("Weight");

        addButtonContainer();
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
