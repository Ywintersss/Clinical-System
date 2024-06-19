package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.PaymentCard;
import Project.Payments.Payment;
import Project.UserSession;
import Project.Users.Patient;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import static javafx.scene.text.Font.font;

public class PaymentHistoryList {
    private ObservableList<Payment> paymentList;
    private ScrollPane paymentScroller;
    private VBox paymentHistory;
    private Label title;

    public PaymentHistoryList(Patient patient) {
        if (patient == null) {
            patient = (Patient) UserSession.getInstance().getCurrentUser();
        }

        paymentList = ClinicalSystem.getPaymentHandler().getPatientPaymentHistory(patient.getID());

        paymentHistory = new VBox();
        paymentHistory.setPadding(new Insets(10));
        paymentHistory.setSpacing(20);

        title = new Label("Payment History");
        title.setFont(font("Verdana", FontWeight.BOLD, 25));
        title.setPadding(new Insets(25, 10, 10, 10));
        VBox.setMargin(title, new Insets(0, 0, 0, 30));

        paymentHistory.getChildren().addAll(title);

        for (Payment payment: paymentList) {
            paymentHistory.getChildren().add(new PaymentCard(payment.getPaymentID(), payment.getPatientID(), payment.getAmount(), payment.getPaymentMethod().getPaymentMethod(), payment.getDate()).getPaymentCard());
        }

        paymentScroller = new ScrollPane(paymentHistory);
        paymentScroller.setFitToWidth(true);
        paymentScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        paymentScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        paymentScroller.setContent(paymentHistory);

    }

    public VBox getPaymentHistory() {
        return paymentHistory;
    }
}
