/*Link to our GitHub Repository: https://github.com/Ywintersss/Clinical-System

Special thanks to everyone who worked on this project:
Shawn Ryan Peterson, Kelly Pek Xue Er, Too Tze Jiat.
Miss Tan Li June and everyone who helped along the way.

*/



import Project.ClinicalSystem;
import Project.Interface.Pages.Home;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        ClinicalSystem.navigateTo(new Home().getHome());

        stage.setScene(ClinicalSystem.getLayout().getScene());

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
