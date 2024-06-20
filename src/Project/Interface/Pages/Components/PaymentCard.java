package Project.Interface.Pages.Components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PaymentCard {
    private VBox contentContainer;

    private HBox paymentContainer;
    private Label paymentIDLabel;
    private Label paymentID;

    private HBox patientContainer;
    private Label patientLabel;
    private Label patient;

    private HBox amountContainer;
    private Label amountLabel;
    private Label amount;

    private HBox paymentMethodContainer;
    private Label paymentMethodLabel;
    private Label paymentMethod;

    private HBox dateContainer;
    private Label dateLabel;
    private Label date;
    public PaymentCard(String paymentID, String patient, String amount, String paymentMethod, String date) {
        contentContainer = new VBox();
        contentContainer.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY)));
        contentContainer.setPadding(new Insets(10));
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 20));

        paymentContainer = new HBox();
        paymentContainer.setSpacing(20);
        paymentContainer.setPadding(new Insets(5));

        paymentIDLabel = new Label("Payment ID");
        this.paymentID = new Label(paymentID);

        patientContainer = new HBox();
        patientContainer.setSpacing(20);
        patientContainer.setPadding(new Insets(5));

        patientLabel = new Label("Patient");
        this.patient = new Label(patient);


        amountContainer = new HBox();
        amountContainer.setSpacing(20);
        amountContainer.setPadding(new Insets(5));

        amountLabel = new Label("Amount");
        this.amount = new Label(amount);


        paymentMethodContainer = new HBox();
        paymentMethodContainer.setSpacing(20);
        paymentMethodContainer.setPadding(new Insets(5));

        paymentMethodLabel = new Label("Payment Method");
        this.paymentMethod = new Label(paymentMethod);


        dateContainer = new HBox();
        dateContainer.setSpacing(20);
        dateContainer.setPadding(new Insets(5));

        dateLabel = new Label("Date");
        this.date = new Label(date);

        paymentContainer.getChildren().addAll(paymentIDLabel, this.paymentID);
        patientContainer.getChildren().addAll(patientLabel, this.patient);
        amountContainer.getChildren().addAll(amountLabel, this.amount);
        paymentMethodContainer.getChildren().addAll(paymentMethodLabel, this.paymentMethod);
        dateContainer.getChildren().addAll(dateLabel, this.date);

        contentContainer.getChildren().addAll(patientContainer, amountContainer, paymentMethodContainer, dateContainer);
    }

    public VBox getPaymentCard() {
        return contentContainer;
    }
}
