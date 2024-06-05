package Project.Interface.Pages.Components;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.TilePane;
import java.awt.event.ActionEvent;

public class Notification {
    private static final Alert a = new Alert(AlertType.NONE);

    public static void confirmation (String message) {
        a.setAlertType(AlertType.CONFIRMATION);
        a.setTitle("Confirmation");
        a.setHeaderText(null);
        a.setContentText(message);
        a.show();
    }

    public static void information (String message) {
        a.setAlertType(AlertType.INFORMATION);
        a.setTitle("Notification");
        a.setHeaderText(null);
        a.setContentText(message);
        a.show();
    }

    public static void error (String message) {
        a.setAlertType(AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(null);
        a.setContentText(message);
        a.show();
    }



}
