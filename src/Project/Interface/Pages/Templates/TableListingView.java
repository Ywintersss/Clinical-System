package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Users.Patient;
import Project.Utilities.ScreenTools;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public abstract class TableListingView {
        protected VBox tableContainer;
        private Label tableLabel;
        private TableView table;
        private HBox buttonContainer;
        private Button back;

        public TableListingView(String title) {
            table = new TableView();

            tableLabel = new Label(title);
            tableLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 25));

            back = new Button("Back");
            back.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");

            back.setOnAction(e ->{
                ClinicalSystem.back();
            });

            buttonContainer = new HBox();
            buttonContainer.setSpacing(10);
            buttonContainer.setPadding(new Insets(10, 10, 10, 10));
            buttonContainer.getChildren().addAll(back);

            tableContainer = new VBox();
            tableContainer.setSpacing(10);
            tableContainer.setPadding(new Insets(10, 10, 10, 10));
            tableContainer.getChildren().addAll(tableLabel, table, buttonContainer);
        }

        public VBox getTable() {
            return tableContainer;
        }

        public void addColumn(TableColumn newColumn) {

            table.getColumns().add(newColumn);
        }

        public void addColumn(String column) {
            TableColumn<Object, ?> newColumn = new TableColumn<>(column);
            newColumn.setCellValueFactory(new PropertyValueFactory<>(column));
            addColumn(newColumn);
        }

        public void addColumn(String column, String property) {
            TableColumn<Object, ?> newColumn = new TableColumn<>(column);
            newColumn.setCellValueFactory(new PropertyValueFactory<>(property));
            addColumn(newColumn);
        }

        public void addColumnButtons(Button button) {
            TableColumn<Object, Void> btnColumn = new TableColumn<>("");
            btnColumn.setCellFactory(col -> new TableCell<Object, Void>(){
                private final Button btn = new Button(button.getText());

                private final StackPane btnContainer = new StackPane();

                {
                    btnContainer.setAlignment(Pos.CENTER);
                    btnContainer.getChildren().add(btn);
                    btn.setOnAction(button.getOnAction());
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : btnContainer);
                }
            });
            btnColumn.setSortable(false);
            addColumn(btnColumn);
        }

        public void evenWidth() {
            table.widthProperty().addListener((observable, oldValue, newValue) -> {
                double width = (newValue.doubleValue() / table.getColumns().size());
                for (Object column: table.getColumns()) {
                    ((TableColumn) column).setPrefWidth(width);
                }
            });
        }

        public void initTableData(ObservableList data) {
            table.setItems(data);
        }
        public void addFunctionalButton(Button FuncButton) {
            Region spacer = new Region();
            FuncButton.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
            HBox.setHgrow(spacer, Priority.ALWAYS);
            buttonContainer.getChildren().addAll(spacer, FuncButton);
        }
}
