package Project.Interface.Pages.Components;

import Project.Interface.Pages.Templates.PopUp;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

public class PopUpPatient extends PopUp {
    private Button editProfile;
    private Button medicalRecord;
    private Button appointments;
    private Button payment;
    public PopUpPatient() {
        editProfile = new Button("Edit Profile");
        editProfile.setOnAction(e -> {
            super.setVisible(false);
        });


        medicalRecord = new Button("Medical Record");


        appointments = new Button("Appointment");


        payment = new Button("Payment");


        addContent(editProfile, medicalRecord, appointments, payment);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }
}
