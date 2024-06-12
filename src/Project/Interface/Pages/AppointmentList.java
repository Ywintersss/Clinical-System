package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Scheduler.Appointment;
import Project.Scheduler.Schedule;
import Project.Scheduler.Scheduler;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Users.User;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AppointmentList extends TableListingView {
    private Button completeButton;
    private ObservableList<Appointment> appointments;
    public AppointmentList() {
        super("Appointment List");

        appointments = ClinicalSystem.getScheduler().getAllAppointments();

        addColumn("Doctor");
        addColumn("Patient");
        addColumn("Date");
        addColumn("Time");
        addColumn("Description");

        completeButton = new Button("Complete");
        completeButton.setOnAction(e -> {
            return;
        });

        addColumnButtons(completeButton);

        initTableData(appointments);

        evenWidth();
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
