package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class AdminEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;

    public AdminEditProfile() {
        super("Edit Profile");

        profileScroll = new ScrollPane();
        getButtonContainer().getStylesheets().add("/Project/Interface/Assets/Styles/Styles.css");

        username = new TextField("Tom");
        password = new TextField("1234");

        addContent("Username", username);
        addContent("Password", password);

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

