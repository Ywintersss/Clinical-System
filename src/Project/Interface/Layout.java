package Project.Interface;

import Project.Interface.Pages.Home;
import Project.Interface.Pages.Header;
import Project.Interface.Pages.Footer;
import Project.Interface.Pages.Components.PopUp;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class Layout{
    private BorderPane mainLayout;
    private HBox header;
    private VBox footer;
    private Parent content;
    private VBox popUp;

    public Layout () {
        popUp = new PopUp().getPopUp();

        mainLayout = new BorderPane();
        header = new Header(popUp).getHeaderNode();
        content = new Home().getHome();
        footer = new Footer().getFooterNode();

        mainLayout.setTop(header);
        mainLayout.setCenter(content);
        mainLayout.setBottom(footer);
        mainLayout.setLeft(popUp);
        mainLayout.setStyle("-fx-background-color: #D4F0F7;");
    }



    public Scene getScene() {
        return new Scene(mainLayout, 1080, 720, Color.SKYBLUE);
    }
}
