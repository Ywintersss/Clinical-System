package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.AdminEditProfile;
import Project.Interface.Pages.AdminMainPage;
import Project.Interface.Pages.Home;
import Project.Interface.Pages.Templates.PopUp;
import Project.Interface.Pages.UserEditProfile;
import Project.Utilities.Styles;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PopUpAdmin extends PopUp {
    private Button editProfile;
    public PopUpAdmin() {
        editProfile = new Button("Edit Profile");
        editProfile.setStyle(Styles.buttonStyle());
        editProfile.setOnAction(e -> {
            ClinicalSystem.navigateTo(new AdminEditProfile(null).getDetails());
        });

        addContent(editProfile);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }

}

