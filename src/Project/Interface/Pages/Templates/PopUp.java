package Project.Interface.Pages.Templates;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PopUp {
    protected VBox popUp;
    private Image profileImage;
    public PopUp() {
        popUp = new VBox();

        profileImage = new Image("/Project/Interface/Assets/Icons/profile.png");
        ImageView profileImageView = new ImageView(profileImage);
        profileImageView.setFitHeight(100);
        profileImageView.setFitWidth(100);
        profileImageView.setPreserveRatio(true);

        popUp.getChildren().add(profileImageView);
        popUp.setSpacing(10);
        popUp.setAlignment(Pos.CENTER);
        popUp.setPadding(new Insets(10, 20, 10, 20));
        popUp.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        popUp.setVisible(false);
    }

    public VBox getPopUp() {
        return popUp;
    }

    public void addContent(Node ...content) {
        for (Node node : content) {
            popUp.getChildren().add(node);
        }
    }
}
