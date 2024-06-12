package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Scheduler.Appointment;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

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
