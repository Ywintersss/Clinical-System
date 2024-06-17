package Project.Interface;

import Project.Interface.Pages.*;
import Project.Interface.Pages.Components.PopUpDefault;
import Project.Interface.Pages.Templates.PopUp;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

/**
 * <h3>Layout class</h3>
 * <p>Manages the layout of the application</p>
 * <p>Includes the header, footer, and content of the application</p>
 */


public class Layout{
    private BorderPane mainLayout;
    private HBox header;
    private VBox footer;
    private Parent content;
    private VBox popUp;
    private Region rightSideMargin;

    public Layout () {
        popUp = new PopUpDefault().getPopUp();

        rightSideMargin = new Region();
        rightSideMargin.prefWidthProperty().bind(popUp.widthProperty());

        mainLayout = new BorderPane();
        header = new Header(popUp).getHeaderNode();
        content = new Home().getHome();
        footer = new Footer().getFooterNode();

        mainLayout.setTop(header);
        mainLayout.setCenter(content);
        mainLayout.setBottom(footer);
        mainLayout.setLeft(popUp);
        mainLayout.setRight(rightSideMargin);

        mainLayout.setStyle("-fx-background-color: #D4F0F7;");
    }

    //returns a scene for the stage
    public Scene getScene() {
        return new Scene(mainLayout, 1080, 720, Color.SKYBLUE);
    }

    public Parent getContent() {
        return content;
    }

    //main method of routing between contents(pages)
    public void setContent(Parent content) {
        this.content = content;
        mainLayout.setCenter(content);
    }

    //sets the header and popUp
    public void setHeaderPopUp(PopUp newPopUp) {
        VBox popUp = newPopUp.getPopUp();
        Header header = new Header(popUp);

        //add logout button if popUp(logged in) is not default(not logged in)
        if (!(newPopUp instanceof PopUpDefault)) {
            header.addLogout();
        } else {
            header.removeLogout();
        }

        //sets the header and popUp
        mainLayout.setTop(header.getHeaderNode());
        mainLayout.setLeft(popUp);
    }
}
