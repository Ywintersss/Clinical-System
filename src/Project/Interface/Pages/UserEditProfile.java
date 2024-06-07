package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import Project.Utilities.ScreenTools;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import Project.UserSession;

public class UserEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;
    private TextField name;
    private TextField email;
    private TextField contact;
    private TextField age;
    private TextField gender;
    private TextField height;
    private TextField weight;

	public UserEditProfile(Parent previousPage) {
        super("Edit Profile", previousPage);

		UserSession userSession = new UserSession();

        profileScroll = new ScrollPane();

        username = new TextField("Tom");
        password = new TextField("1234");
        name = new TextField("Tom");
        email = new TextField("tom@1234");
        contact = new TextField("012-3456789");
        age = new TextField("21");
        gender = new TextField("MALE");
        height = new TextField("188");
        weight = new TextField("72");

        addContent("Username", username);
        addContent("Password", password);
        addContent("Name", name);
        addContent("Email", email);
        addContent("Contact", contact);
        addContent("Age", age);
        addContent("Gender", gender);
        addContent("Height", height);
        addContent("Weight", weight);

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
