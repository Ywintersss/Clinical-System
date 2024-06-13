package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.TableListingView;
import Project.Scheduler.Appointment;
import Project.Scheduler.AppointmentDetail;
import Project.Scheduler.Schedule;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Users.Patient;
import Project.Users.User;
import Project.Utilities.Utilities;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AppointmentList extends TableListingView {
    private Button viewButton;
    private ObservableList<AppointmentDetail> appointmentDetailsList;
    public AppointmentList(int flag, String title) {
        super(title);

        appointmentDetailsList = ClinicalSystem.getScheduler().getAllAppointmentDetails();

        if (flag == 2){
            appointmentDetailsList.removeIf(appointmentDetail -> !appointmentDetail.getDoctor().getID().equals(UserSession.getInstance().getCurrentUser().getID()));
        } else if (flag == 3) {
            appointmentDetailsList.removeIf(appointmentDetail -> !appointmentDetail.getPatient().getID().equals(UserSession.getInstance().getCurrentUser().getID()));
            appointmentDetailsList.removeIf(appointmentDetail -> {
                Schedule schedule = appointmentDetail.getSchedule();
                String date = schedule.getDate();
                String appointmentTime = appointmentDetail.getAppointmentTime();
                return Utilities.hasPassedDate(date) || Utilities.hasPassedTime(appointmentTime);
            });

            Button appointmentHistory = new Button("Appointment History");
            appointmentHistory.setOnAction(e -> {
                ClinicalSystem.navigateTo(new AppointmentList(4, "Appointment History").getTable());
            });

            addFunctionalButton(appointmentHistory);
        } else if (flag == 4) {
            appointmentDetailsList.removeIf(appointmentDetail -> {
                Schedule schedule = appointmentDetail.getSchedule();
                String date = schedule.getDate();
                String appointmentTime = appointmentDetail.getAppointmentTime();
                return !Utilities.hasPassedDate(date) && !Utilities.hasPassedTime(appointmentTime);
            });
        }

        addColumn("Doctor");
        addColumn("Patient", cellData -> {
            AppointmentDetail appointmentDetail = (AppointmentDetail) cellData.getValue();
            Patient patient = appointmentDetail.getPatient();
            return new SimpleObjectProperty<Object>(patient.getName());
        });
        addColumn("Date", cellData -> {
            AppointmentDetail appointmentDetail = (AppointmentDetail) cellData.getValue();
            Schedule schedule = appointmentDetail.getSchedule();
            return new SimpleObjectProperty<Object>(schedule.getDate());
        });
        addColumn("Time", "appointmentTime");
        addColumn("Description");

        viewButton = new Button("View");
        viewButton.setOnAction(e -> {
            return;
        });

        addColumnButtons(viewButton);

        initTableData(appointmentDetailsList);

        evenWidth();
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
