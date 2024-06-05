package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import Project.Utilities.ScreenTools;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AdminEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;

    public AdminEditProfile() {
        super("Edit Profile", new AdminMainPage().getAdminMainPage());

        profileScroll = new ScrollPane();
        getButtonContainer().getStylesheets().add("/Project/Interface/Assets/Styles/adminStyle.css");

        username = new TextField("Tom");
        password = new TextField("1234");

        addContent("Username", username);
        addContent("Password", password);

        profileScroll.setContent(getContentContainer());
        profileScroll.setFitToWidth(true);
        profileScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        profileScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        addButtonIntoContainer("Done");

        getDetails().getChildren().removeLast();
        getDetails().getChildren().removeLast();
        getDetails().getChildren().add(profileScroll);
        getDetails().getChildren().add(getButtonContainer());

    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

