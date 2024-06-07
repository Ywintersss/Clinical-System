package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import Project.Utilities.ScreenTools;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class DoctorEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;
    private TextField name;
    private TextField email;
    private TextField contact;
    private TextField age;
    private TextField yearsOfExperience;
    private TextField specialization;
    private TextField position;

    public DoctorEditProfile(Parent previousPage) {
        super("Edit Profile",  previousPage);

        profileScroll = new ScrollPane();
        getButtonContainer().getStylesheets().add("/Project/Interface/Assets/Styles/Styles.css");

        username = new TextField("Elon");
        password = new TextField("1234");
        name = new TextField("elon");
        email = new TextField("elon@1234");
        contact = new TextField("012-3456789");
        age = new TextField("34");
        yearsOfExperience = new TextField("10");
        specialization = new TextField("Heart");
        position = new TextField("Doctor");

        addContent("Username", username);
        addContent("Password", password);
        addContent("Name", name);
        addContent("Email", email);
        addContent("Contact", contact);
        addContent("Age", age);
        addContent("Years of Experience", yearsOfExperience);
        addContent("Specialization", specialization);
        addContent("Position", position);

        profileScroll.setContent(getContentContainer());
        profileScroll.setFitToWidth(true);
        profileScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        profileScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        addButtonIntoContainer("Done");

        getDetails().getChildren().removeAll();
        getDetails().getChildren().remove(getButtonContainer());
        getDetails().getChildren().add(profileScroll);
        getDetails().getChildren().add(getButtonContainer());

    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

