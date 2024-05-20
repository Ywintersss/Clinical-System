package Project.Interface;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> System.out.println("Hello World!"));

        stage.setTitle("Hello World!");
        stage.setScene(new Scene((Parent) btn, 300, 250));
        stage.show();
    }
}
