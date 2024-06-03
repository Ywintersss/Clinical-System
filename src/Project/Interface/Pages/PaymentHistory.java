package Project.Interface.Pages;

import Project.Interface.Pages.Components.PaymentCard;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import static javafx.scene.text.Font.font;

public class PaymentHistory {
    private VBox paymentHistory;
    private Label title;

    public PaymentHistory() {
        paymentHistory = new VBox();
        paymentHistory.setPadding(new Insets(10));
        paymentHistory.setSpacing(20);

        title = new Label("Payment History");
        title.setFont(font("Verdana", FontWeight.BOLD, 25));
        title.setPadding(new Insets(25, 10, 10, 10));
        VBox.setMargin(title, new Insets(0, 0, 0, 30));

        paymentHistory.getChildren().addAll(title);

        for (int i = 0; i < 2; i++) {
            paymentHistory.getChildren().add(new PaymentCard("50001","Onic","RM 100.00", "Cash", "10/10/2021").getPaymentCard());
        }
    }

    public VBox getPaymentHistory() {
        return paymentHistory;
    }
}
