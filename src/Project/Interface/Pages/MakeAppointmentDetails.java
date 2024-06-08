package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MakeAppointmentDetails extends DetailView {
    private Label doctorName;
    private Label doctorSpecialization;
    private Label doctorPosition;
    private Label consultationFees;
    public MakeAppointmentDetails() {
        super("Appointment Details");

        doctorName = new Label("Kelly");
        doctorSpecialization = new Label("Dermatologist");
        doctorPosition = new Label("Cardiologist");
        consultationFees = new Label("RM5000");

        addContent("Doctor Name", doctorName);
        addContent("Specialization", doctorSpecialization);
        addContent("Position", doctorPosition);
        addContent("Fees", consultationFees);

        addButtonIntoContainer("Make Appointment");

    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}
