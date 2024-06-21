package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.DetailView;
import Project.Scheduler.ScheduleDetail;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Users.Patient;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MakeAppointmentDetails extends DetailView {
    private Label doctorName;
    private Label doctorSpecialization;
    private Label doctorPosition;
    private Label dateLabel;
    private Label timeLabel;
    private TextField description;
    private Label consultationFees;
    private Button makeAppointment;
    public MakeAppointmentDetails(ScheduleDetail scheduleDetail, String selectedTime) {
        super("Appointment Details");

        doctorName = new Label(scheduleDetail.getDoctor().getName());
        doctorSpecialization = new Label(scheduleDetail.getDoctor().getSpecialization());
        doctorPosition = new Label(scheduleDetail.getDoctor().getPosition());
        dateLabel = new Label(scheduleDetail.getDate());
        timeLabel = new Label(selectedTime);
        description = new TextField();
        description.setPromptText("Anything to tell the doctor?");
        consultationFees = new Label("RM" + scheduleDetail.getDoctor().getConsultationFee());

        addContent("Doctor Name", doctorName);
        addContent("Specialization", doctorSpecialization);
        addContent("Position", doctorPosition);
        addContent("Date", dateLabel);
        addContent("Time", timeLabel);
        addContent("Description", description);
        addContent("Fees", consultationFees);

        makeAppointment = new Button("Make Appointment");
        makeAppointment.setOnAction(e -> {
            Patient patient = (Patient) UserSession.getInstance().getCurrentUser();
            try {
                ClinicalSystem.getScheduler().makeAppointment(scheduleDetail.getSchedule().getScheduleID(), patient.getID(), selectedTime, description.getText() != null ? description.getText() : "none");
                Notification.information("Appointment made successfully");

                ClinicalSystem.back();
                ClinicalSystem.back();
                ClinicalSystem.refresh(new DateDoctorSelection().getDateSelection());
            } catch (Exception ex) {
                Notification.error("Something went wrong");
            }
        });

        addButtonIntoContainer(makeAppointment);
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}
