package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Utilities.Utilities;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DateSelection {
    private Label titleLabel;
    private Region spacer1;
    private VBox dateSelectionContainer;
    private HBox dateSelectorContainer;
    private Label SelectDate;
    private ComboBox<String> dateSelector;
    private Region spacer2;
    private HBox buttonContainer;
    private Button back;
    private Region spacer3;
    private Button next;
    public DateSelection(Parent previousPage) {
        dateSelectionContainer = new VBox();
        dateSelectionContainer.setSpacing(10);
        dateSelectionContainer.setPadding(new Insets(10, 10, 10, 10));
        dateSelectionContainer.setAlignment(Pos.CENTER);

        titleLabel = new Label("Select a Date");
        titleLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        titleLabel.setPadding(new Insets(10, 0, 10, 0));

        spacer1 = new Region();
        VBox.setVgrow(spacer1, Priority.ALWAYS);

        dateSelectorContainer = new HBox();
        dateSelectorContainer.setSpacing(10);
        dateSelectorContainer.setAlignment(Pos.CENTER);

        SelectDate = new Label("Select Date: ");
        SelectDate.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        SelectDate.setPadding(new Insets(10, 0, 10, 0));

        dateSelector = new ComboBox<>();
        dateSelector.setPromptText("Select a Date");
        dateSelector.setValue("Today");
        dateSelector.getItems().addAll("Today", Utilities.getCurrentDate(1), Utilities.getCurrentDate(2));

        dateSelectorContainer.getChildren().addAll(SelectDate,dateSelector);

        spacer2 = new Region();
        VBox.setVgrow(spacer2, Priority.ALWAYS);

        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);

        back = new Button("Back");
        back.setPadding(new Insets(10, 20, 10, 20));
        back.setOnAction(e -> {
            ClinicalSystem.getLayout().setContent(previousPage);
        });

        spacer3 = new Region();
        HBox.setHgrow(spacer3, Priority.ALWAYS);

        next = new Button("Next");
        next.setPadding(new Insets(10, 20, 10, 20));
        next.setOnAction(e -> {
            if (dateSelector.getValue().equals("Today")) {
//                ClinicalSystem.getLayout().setContent(new TimeSelection(previousPage));
            } else if (dateSelector.getValue().equals(Utilities.getCurrentDate(1))) {
//                ClinicalSystem.getLayout().setContent(new TimeSelection(previousPage, Utilities.getCurrentDate(1)));
            } else if (dateSelector.getValue().equals(Utilities.getCurrentDate(2))) {
//                ClinicalSystem.getLayout().setContent(new TimeSelection(previousPage, Utilities.getCurrentDate(2)));
            }
        });

        buttonContainer.getChildren().addAll(back, spacer3, next);

        dateSelectionContainer.getChildren().addAll(titleLabel, spacer1, dateSelectorContainer, spacer2, buttonContainer);
    }

    public VBox getDateSelection() {
        return dateSelectionContainer;
    }
}
