package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.DetailView;
import Project.Payments.*;
import Project.Users.Patient;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AddPaymentRecord extends DetailView{
    private ObservableList<Patient> patients;
    private ComboBox<String> patientID;
    private TextField amount;
    private Button save;


    public AddPaymentRecord() {
        super("Add Payment Record");

        patients = ClinicalSystem.getUserDataManager().getAllPatients();

        patientID = new ComboBox<String>();
        patientID.setPromptText("Select Patient ID.");

        for (Patient patient : patients) {
            patientID.getItems().add(patient.getID());
        }

        addSelectionContainer("Patient ID", patients.stream().map(Patient::getID).toArray(String[]::new));

        amount = new TextField();
        amount.setPromptText("RM250");
        addContent("Amount", amount);


        addSelectionContainer("Payment Method", new String[]{"PHYSICAL", "EWALLET", "CARD", "BANKTRANSFER"});

        save = new Button("Save");
        save.setPrefHeight(40);
        save.setPrefWidth(100);

        save.setOnAction(e ->{
            ArrayList<String> data = getInputData();
            System.out.println(data);

            String patientID = data.get(0);
            String amount = "RM" + data.get(1);
            String paymentMethod = data.get(2);
            String date = Utilities.getCurrentDate()+" "+Utilities.getCurrentTime();

            try {
                ClinicalSystem.getPaymentHandler().makePayment(patientID, amount, paymentMethod, date);
                Notification.information("Payment Record Added");

                ClinicalSystem.back();
                ClinicalSystem.refresh(new ViewPaymentRecord().getTable());
            } catch (Exception ex) {
                Notification.error("Failed to Add Payment Record");
            }


        });

        addButtonIntoContainer(save);
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

