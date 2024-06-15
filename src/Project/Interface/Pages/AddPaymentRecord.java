package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.DetailView;
import Project.Payments.*;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AddPaymentRecord extends DetailView{
    private TextField patientID;
    private TextField amount;


    public AddPaymentRecord() {
        super("Add Payment Record");

        patientID = new TextField();
        patientID.setPromptText("Enter Patient ID...");
        addContent("Patient ID",patientID);

        amount = new TextField();
        amount.setPromptText("RM250");
        addContent("Amount",amount);


        addSelectionContainer("Payment Method", new String[]{"PHYSICAL", "EWALLET", "CARD", "BANKTRANSFER"});

        Button save = new Button("Save");
        save.setPrefHeight(40);
        save.setPrefWidth(100);

        save.setOnAction(e ->{
            ArrayList<String> data = getInputData();
            System.out.println(data);

            String patientID = data.get(0);
            String amount = data.get(1);
            String paymentMethod = data.get(2);
            String date = Utilities.getCurrentDate()+" "+Utilities.getCurrentTime();

            ClinicalSystem.getPaymentHandler().makePayment(patientID, amount, paymentMethod, date);

            ClinicalSystem.navigateTo(new ViewPaymentRecord().getTable());
        });

        addButtonIntoContainer(save);
    }
    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

