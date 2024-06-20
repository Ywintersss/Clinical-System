package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.PaymentCard;
import Project.Payments.Payment;
import Project.UserSession;
import Project.Users.Patient;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import static javafx.scene.text.Font.font;

public class PaymentHistoryList {
    private ObservableList<Payment> paymentList;
    private ScrollPane paymentScroller;
    private VBox paymentContainer;
    private Region spacer;
    private VBox paymentHistory;
    private Label title;
    private HBox buttonContainer;
    private Region containerSpacer;
    private Button back;

    public PaymentHistoryList(Patient patient) {
        if (patient == null) {
            patient = (Patient) UserSession.getInstance().getCurrentUser();
        }

        paymentList = ClinicalSystem.getPaymentHandler().getPatientPaymentHistory(patient.getID());

        paymentHistory = new VBox();

        containerSpacer = new Region();
        HBox.setHgrow(containerSpacer, Priority.ALWAYS);

        back = new Button("Back");
        back.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
        back.setOnAction(e -> {
            ClinicalSystem.back();
        });

        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.getChildren().addAll(back, containerSpacer);
        VBox.setMargin(buttonContainer, new Insets(0, 10, 20, 10));

        paymentContainer = new VBox();
        paymentContainer.setPadding(new Insets(10));
        paymentContainer.setSpacing(20);

        title = new Label("Payment History");
        title.setFont(font("Verdana", FontWeight.BOLD, 25));
        title.setPadding(new Insets(25, 10, 10, 10));
        VBox.setMargin(title, new Insets(0, 20, 0, 20));


        for (Payment payment: paymentList) {
            paymentContainer.getChildren().add(new PaymentCard(payment.getPaymentID(), payment.getPatientID(), payment.getAmount(), payment.getPaymentMethod().getPaymentMethod(), payment.getDate()).getPaymentCard());
        }

        paymentScroller = new ScrollPane(paymentHistory);
        paymentScroller.setFitToWidth(true);
        paymentScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        paymentScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        paymentScroller.setContent(paymentContainer);

        spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        paymentHistory.getChildren().addAll(title, paymentScroller, spacer, buttonContainer);
    }

    public VBox getPaymentHistory() {
        return paymentHistory;
    }
}
