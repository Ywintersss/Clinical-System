package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.*;
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
            ClinicalSystem.getLayout().setContent(new UserEditProfile(new Home().getHome()).getDetails());
        });


        medicalRecord = new Button("Medical Record");
        medicalRecord.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new MedicalRecord().getMedicalRecord());
        });


        appointments = new Button("Appointment");
        appointments.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new Appointment(new Home().getHome()).getTable());
        });


        payment = new Button("Payment");
        payment.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(new PaymentHistory().getPaymentHistory());
        });


        addContent(editProfile, medicalRecord, appointments, payment);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }
}
