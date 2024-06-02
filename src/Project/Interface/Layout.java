package Project.Interface;

import Project.Interface.Pages.Home;
import Project.Interface.Pages.Header;
import Project.Interface.Pages.Footer;
import Project.Interface.Pages.Components.PopUpDefault;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

import Project.Interface.Pages.DoctorMainPage;

public class Layout{
    private BorderPane mainLayout;
    private HBox header;
    private VBox footer;
    private Parent content;
    private VBox popUpDefault;
    private VBox rightSideMargin;

    public Layout () {
        popUpDefault = new PopUpDefault().getPopUp();
        rightSideMargin = new PopUpDefault().getPopUp();

        mainLayout = new BorderPane();
        header = new Header(popUpDefault).getHeaderNode();
        content = new DoctorMainPage().getPage();
        footer = new Footer().getFooterNode();

        mainLayout.setTop(header);
        mainLayout.setCenter(content);
        mainLayout.setBottom(footer);
        mainLayout.setLeft(popUpDefault);
        mainLayout.setRight(rightSideMargin);

        mainLayout.setStyle("-fx-background-color: #D4F0F7;");
    }
    public Scene getScene() {
        return new Scene(mainLayout, 1080, 720, Color.SKYBLUE);
    }

    public void setContent(Parent content) {
        this.content = content;
        mainLayout.setCenter(content);
    }
}
