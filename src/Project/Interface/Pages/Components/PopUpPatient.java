package Project.Interface.Pages.Components;

import Project.ClinicalSystem;
import Project.Interface.Pages.*;
import Project.Interface.Pages.Templates.PopUp;
import Project.Utilities.Styles;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

public class PopUpPatient extends PopUp {
    private Button editProfile;
    private Button medicalRecord;
    private Button appointments;
    private Button payment;
    public PopUpPatient() {
        editProfile = new Button("Edit Profile");
        editProfile.setStyle(Styles.buttonStyle());
        editProfile.setOnAction(e -> {
            ClinicalSystem.navigateTo(new UserEditProfile(null).getDetails());
        });


        medicalRecord = new Button("Medical Record");
        medicalRecord.setStyle(Styles.buttonStyle());
        medicalRecord.setOnAction(e -> {
            ClinicalSystem.navigateTo(new MedicalRecordList(null).getMedicalRecordList());
        });


        appointments = new Button("Appointments");
        appointments.setStyle(Styles.buttonStyle());
        appointments.setOnAction(e -> {
            ClinicalSystem.navigateTo(new AppointmentList(3, "Appointments").getTable());
        });


        payment = new Button("Payment");
        payment.setStyle(Styles.buttonStyle());
        payment.setOnAction(e -> {
            ClinicalSystem.navigateTo(new PaymentHistoryList(null).getPaymentHistory());
        });


        addContent(editProfile, medicalRecord, appointments, payment);
    }

    @Override
    public VBox getPopUp() {
        return super.getPopUp();
    }
}
