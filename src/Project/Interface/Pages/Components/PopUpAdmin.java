package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.AdminEditProfile;
import Project.Interface.Pages.Home;
import Project.Interface.Pages.Templates.PopUp;
import Project.Interface.Pages.UserEditProfile;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PopUpAdmin extends PopUp {
    private Button editProfile;
    public PopUpAdmin() {
        editProfile = new Button("Edit Profile");
        editProfile.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new AdminEditProfile(new Home().getHome()).getDetails());
        });

        addContent(editProfile);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }

}

