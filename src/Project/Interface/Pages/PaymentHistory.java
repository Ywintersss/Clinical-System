package Project.Interface.Pages;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import static javafx.scene.text.Font.font;

public class PaymentHistory {
    private VBox paymentHistory;
    private Label title;
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

    public PaymentHistory() {
        paymentHistory = new VBox();

        title = new Label("Payment History");
        title.setFont(font("Verdana", FontWeight.BOLD, 25));
        title.setPadding(new Insets(25, 10, 20, 10));
        VBox.setMargin(title, new Insets(0, 0, 0, 30));

        contentContainer = new VBox();
        contentContainer.setBackground( new Background( new BackgroundFill( Color.LIGHTPINK, new CornerRadii(8), Insets.EMPTY ) ) );
        contentContainer.setPadding(new Insets(10));
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 35));

        paymentContainer = new HBox();
        paymentContainer.setSpacing(20);
        paymentContainer.setPadding(new Insets(5));

        paymentIDLabel = new Label("Payment ID");
        paymentID = new Label("10001");
        paymentID.setStyle("-fx-background-color: white;");

        patientContainer = new HBox();
        patientContainer.setSpacing(20);
        patientContainer.setPadding(new Insets(5));

        patientLabel = new Label("Patient");
        patient = new Label("Derick");


        amountContainer = new HBox();
        amountContainer.setSpacing(20);
        amountContainer.setPadding(new Insets(5));

        amountLabel = new Label("Amount");
        amount = new Label("100.00");


        paymentMethodContainer = new HBox();
        paymentMethodContainer.setSpacing(20);
        paymentMethodContainer.setPadding(new Insets(5));

        paymentMethodLabel = new Label("Payment Method");
        paymentMethod = new Label("Cash");


        dateContainer = new HBox();
        dateContainer.setSpacing(20);
        dateContainer.setPadding(new Insets(5));

        dateLabel = new Label("Date");
        date = new Label("2022-01-01");

        paymentContainer.getChildren().addAll(paymentIDLabel, paymentID);
        patientContainer.getChildren().addAll(patientLabel, patient);
        amountContainer.getChildren().addAll(amountLabel, amount);
        paymentMethodContainer.getChildren().addAll(paymentMethodLabel, paymentMethod);
        dateContainer.getChildren().addAll(dateLabel, date);

        contentContainer.getChildren().addAll(patientContainer, amountContainer, paymentMethodContainer, dateContainer);
        paymentHistory.getChildren().addAll(title, contentContainer);

    }

    public VBox getPaymentHistory() {
        return paymentHistory;
    }
}
