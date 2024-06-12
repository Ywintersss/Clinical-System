package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.DetailView;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Users.Patient;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MakeAppointmentDetails extends DetailView {
    private Label doctorName;
    private Label doctorSpecialization;
    private Label doctorPosition;
    private Label dateLabel;
    private Label timeLabel;
    private Label consultationFees;
    private Button makeAppointment;
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

        makeAppointment = new Button("Make Appointment");
        makeAppointment.setOnAction(e -> {
            Patient patient = (Patient) UserSession.getInstance().getCurrentUser();
            ClinicalSystem.getScheduler().makeAppointment(doctor.getScheduleID(), patient.getID(), time, "Something for now");
        });

        addButtonIntoContainer(makeAppointment);
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}
