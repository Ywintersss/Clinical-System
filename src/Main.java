import Project.Interface.Layout;
import Project.Utilities.ScreenTools;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Layout layout = new Layout();
        stage.setScene(layout.getScene());

        stage.setMinWidth(1080);
        stage.setMinHeight(720);

        Image icon = new Image("/Project/Interface/Assets/Icons/I-Care_ClinicIcon.png");
        stage.getIcons().add(icon);

        stage.setTitle("I-Care Clinic");

        stage.setResizable(false);

        // stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args)  {
        launch(args);
    }
}
