package Project.Interface.Pages;

import Project.Interface.Pages.Templates.DetailView;
import Project.Users.Doctor;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MakeAppointmentDetails extends DetailView {
    private Label doctorName;
    private Label doctorSpecialization;
    private Label doctorPosition;
    private Label dateLabel;
    private Label timeLabel;
    private Label consultationFees;
    public MakeAppointmentDetails(Doctor doctor, String date, String time) {
        super("Appointment Details");

        doctorName = new Label(doctor.getName());
        doctorSpecialization = new Label(doctor.getSpecialization());
        doctorPosition = new Label(doctor.getPosition());
        dateLabel = new Label(date);
        timeLabel = new Label(time);
        consultationFees = new Label("250");

        addContent("Doctor Name", doctorName);
        addContent("Specialization", doctorSpecialization);
        addContent("Position", doctorPosition);
        addContent("Date", dateLabel);
        addContent("Time", timeLabel);
        addContent("Fees", consultationFees);

        addButtonIntoContainer("Make Appointment");

    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}
