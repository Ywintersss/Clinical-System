package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.DetailView;
import Project.UserSession;
import Project.Users.Admin;
import Project.Users.Doctor;
import Project.Users.Gender;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class AdminEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;

    public AdminEditProfile(Admin oldAdminData) {
        super("Edit Profile");

        if (oldAdminData == null) {
            oldAdminData = (Admin) UserSession.getInstance().getCurrentUser();
        }

        profileScroll = new ScrollPane();
        getButtonContainer().getStylesheets().add("/Project/Interface/Assets/Styles/Styles.css");

        username = new TextField(oldAdminData.getUsername());
        password = new TextField(oldAdminData.getPassword());

        addContent("Username", username);
        addContent("Password", password);

        profileScroll.setContent(getContentContainer());
        profileScroll.setFitToWidth(true);
        profileScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        profileScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Button saveButton = getSaveButton(oldAdminData);
        addButtonIntoContainer(saveButton);

        getDetails().getChildren().removeAll();
        getDetails().getChildren().add(profileScroll);
        moveButtonContainerToBottom();

    }

    private Button getSaveButton(Admin oldAdminData) {
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                oldAdminData.setUsername(username.getText());
                oldAdminData.setPassword(password.getText());

                String[] newData = {oldAdminData.getID(), username.getText(), password.getText()};

                try {
                    ClinicalSystem.getUserDataManager().updateUser("\\users\\Admin.txt", newData);
                    UserSession.getInstance().setCurrentUser(oldAdminData);

                    Notification.information("Changes saved successfully");
                } catch (Exception ex) {
                    Notification.error("Failed to save changes");
                }
                ClinicalSystem.back();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        return saveButton;
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

