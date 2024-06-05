package Project.Interface.Pages;

import Project.Interface.Pages.Templates.Register;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class DoctorRegister extends Register {

    public DoctorRegister(Parent previousPage) {
        super("Register Doctor",  previousPage);

        addContentContainer("Username");
        addContentContainer("Password");
        addContentContainer("Name");
        addContentContainer("Email");
        addContentContainer("Phone Number");
        addContentContainer("Age");
        addContentContainer("Gender");
        addContentContainer("Years Of Experience");
        addContentContainer("Specialization");
        addContentContainer("Position");

        addButtonContainer(new ViewDoctorList(previousPage).getTable());
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
