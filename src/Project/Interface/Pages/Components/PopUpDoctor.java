package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.AdminEditProfile;
import Project.Interface.Pages.DoctorEditProfile;
import Project.Interface.Pages.DoctorMainPage;
import Project.Interface.Pages.Home;
import Project.Interface.Pages.Templates.PopUp;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class PopUpDoctor extends PopUp {
    private Button editProfile;
    public PopUpDoctor() {
        editProfile = new Button("Edit Profile");
        editProfile.setOnAction(e -> {
            ClinicalSystem.navigateTo(new DoctorEditProfile().getDetails());
        });

        addContent(editProfile);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }

}
