package Project.Interface.Pages.Components;

import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AboutUs {
    private ScrollPane aboutUsContainer;
    private VBox aboutUs;
    private Image aboutUsImage;
    private Label aboutUsLabel;

    public AboutUs() {
        aboutUs = new VBox();
        aboutUs.setId("aboutUs");
        aboutUs.getStylesheets().add("/Project/Interface/Assets/Styles/aboutus.css");

        aboutUsImage = new Image("/Project/Interface/Assets/Images/AboutUsImage.png");
        ImageView aboutUsImageView = new ImageView(aboutUsImage);

        aboutUsImageView.setFitHeight(200);
        aboutUsImageView.setFitWidth(200);
        aboutUsImageView.setPreserveRatio(true);

        aboutUsLabel = new Label();
        aboutUsLabel.setText(
                "I-Care Clinic is a Center of Excellence for heart and chiropractor treatment in Kuala Lumpur, Malaysia. \n" +
                "The team at I-Care Clinic has grown to include sub-specialists for structural heart treatment, complex and high-risk procedures, and comprehensive health care for families.\n" +
                " \n" +
                "As a CoE for all cardiac and chiropractic matters, we team up with hospitals in Malaysia for subspecialty referrals and cardiac and chiropractic surgical support.\n" +
                " \n" +
                "Our clinic is located at 18, Jalan Bukit Jalil 8, Bukit Jalil.\n" +
                " \n" +
                "Monday - Friday 9am-11pm\n" +
                "Our service up to 14 Hours !\n" +
                " \n" +
                "Our clinic (I-Clinic) can be reached at +607 1818 0088"
        );
        aboutUsLabel.setPadding(new Insets(20, 20, 20, 20));
        aboutUsLabel.setFont(new Font(14));
        aboutUsLabel.setWrapText(true);

        aboutUsContainer = new ScrollPane();
        aboutUsContainer.setContent(aboutUs);
        aboutUsContainer.setFitToWidth(true);
        aboutUsContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        aboutUsContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

        aboutUs.maxWidthProperty().bind(aboutUsContainer.widthProperty());
        aboutUs.getChildren().addAll(aboutUsImageView, aboutUsLabel);
    }

    public ScrollPane getAboutUs() {
        return aboutUsContainer;
    }
}
