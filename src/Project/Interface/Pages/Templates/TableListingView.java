package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Utilities.ScreenTools;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class TableListingView {
        protected VBox tableContainer;
        private Label tableLabel;
        private TableView table;
        private Button back;

        public TableListingView(String title, Parent previousPage) {
            table = new TableView();
            table.setPrefSize(ScreenTools.getScreenWidth() * 0.2, ScreenTools.getScreenHeight() * 0.8);

            tableLabel = new Label(title);
            tableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

            back = new Button("Back");
            back.setAlignment(Pos.BOTTOM_LEFT);

            back.setOnAction(e ->{
                ClinicalSystem.getLayout().setContent(previousPage);
            });

            tableContainer = new VBox();
            tableContainer.setSpacing(10);
            tableContainer.setPadding(new Insets(10, 10, 10, 10));
            tableContainer.getChildren().addAll(tableLabel, table, back);
        }

        public VBox getTable() {
            return tableContainer;
        }

        public void addColumn (String column) {
            table.getColumns().add(new TableColumn(column));
        }
}
