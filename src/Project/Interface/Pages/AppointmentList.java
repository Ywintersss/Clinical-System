package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
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
import javafx.scene.control.TableCell;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AppointmentList extends TableListingView {
    private Button cancelButton;
    private Button addAppointment;
    private ObservableList<AppointmentDetail> appointmentDetailsList;
    public AppointmentList(int flag, String title) {
        super(title);

        appointmentDetailsList = ClinicalSystem.getScheduler().getAllAppointmentDetails();

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

        cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            int index = getButtonIndex(e);

            AppointmentDetail appointmentDetail = (AppointmentDetail) getTableView().getItems().get(index);

            try {
                ClinicalSystem.getScheduler().cancelAppointment(appointmentDetail.getAppointment().getAppointmentID());
                ClinicalSystem.back();
                ClinicalSystem.navigateTo(new AppointmentList(flag, "Appointments").getTable());
                Notification.information("Appointment deleted successfully");
            } catch (Exception e1) {
                Notification.error("Error while deleting appointment");
            }
        });

        addAppointment = new Button("Add");
        addAppointment.setOnAction(e -> {
            ClinicalSystem.navigateTo(new DateDoctorSelection().getDateSelection());
        });

        //flag 1: All Appointments
        //2: Doctor's Appointments
        //3: Patient's Active Appointments
        //4: Patient's Historical Appointments
        if (flag == 1){
            addFunctionalButton(addAppointment);
            addColumnButtons(cancelButton);
        } else if (flag == 2){
            //Remove unrelated appointments
            appointmentDetailsList.removeIf(appointmentDetail -> !appointmentDetail.getDoctor().getID().equals(UserSession.getInstance().getCurrentUser().getID()));

            addColumnButtons(cancelButton);
        } else if (flag == 3) {
            appointmentDetailsList.removeIf(appointmentDetail -> !appointmentDetail.getPatient().getID().equals(UserSession.getInstance().getCurrentUser().getID()));
            appointmentDetailsList.removeIf(appointmentDetail -> {
                Schedule schedule = appointmentDetail.getSchedule();
                String date = schedule.getDate();
                String appointmentTime = appointmentDetail.getAppointmentTime();
                //Filter out inactive appointments
                //Return true if appointment is active
                //Don't remove if it is active
                return !Utilities.isActive(date, appointmentTime);
            });

            Button appointmentHistory = new Button("Appointment History");
            appointmentHistory.setOnAction(e -> {
                ClinicalSystem.navigateTo(new AppointmentList(4, "Appointment History").getTable());
            });

            addColumnButtons(cancelButton);

            addFunctionalButton(appointmentHistory);
        } else if (flag == 4) {
            appointmentDetailsList.removeIf(appointmentDetail -> !appointmentDetail.getPatient().getID().equals(UserSession.getInstance().getCurrentUser().getID()));
            appointmentDetailsList.removeIf(appointmentDetail -> {
                Schedule schedule = appointmentDetail.getSchedule();
                String date = schedule.getDate();
                String appointmentTime = appointmentDetail.getAppointmentTime();
                //Remove if it is active
                return Utilities.isActive(date, appointmentTime);
            });
        }

        initTableData(appointmentDetailsList);

        evenWidth();
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}
