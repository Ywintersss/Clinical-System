package Project.Interface.Pages;

import Project.Interface.Pages.Templates.TableListingView;
import Project.Payments.*;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import Project.ClinicalSystem;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ViewPaymentRecord extends TableListingView {
    private ObservableList<Payment> paymentHistory;
    private final Button deletePayment;
    private final Button addPayment;
    public ViewPaymentRecord() {
        super("Payment Record");

        paymentHistory = ClinicalSystem.getPaymentHandler().getAllPaymentHistory();

        addColumn("PaymentID");
        addColumn("PatientID");
        addColumn("Amount");
        addColumn("PaymentMethod");
        addColumn("Date");

        initTableData(paymentHistory);

        deletePayment = new Button("Delete");
        deletePayment.setOnAction(e -> {
            //TODO delete
        });

        addColumnButtons(deletePayment);

        evenWidth();

        addPayment = new Button("Add");
        addPayment.setOnAction(e -> {
            ClinicalSystem.navigateTo(new PatientRegister().getRegisterForm());
        });

        addFunctionalButton(addPayment);
    }

    @Override
    public VBox getTable() {
        return super.getTable();
    }
}

