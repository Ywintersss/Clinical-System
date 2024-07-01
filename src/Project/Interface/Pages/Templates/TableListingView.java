package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.util.Callback;

public abstract class TableListingView {
        protected VBox tableContainer;
        private Label tableLabel;
        private TableView table;
        private HBox buttonContainer;
        private Button back;

        public TableListingView(String title) {
            table = new TableView();
            table.setEditable(false);

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

        public TableView getTableView() {
            return table;
        }

        public void moveButtonsToBottom() {
            tableContainer.getChildren().remove(buttonContainer);
            tableContainer.getChildren().add(buttonContainer);
        }

        public void addColumn(TableColumn newColumn) {

            table.getColumns().add(newColumn);
        }

        //Adding a default column where JavaFX will display the data with the same column name getter.
        public void addColumn(String column) {
            TableColumn<Object, ?> newColumn = new TableColumn<>(column);
            newColumn.setCellValueFactory(new PropertyValueFactory<>(column));
            addColumn(newColumn);
        }

        //Adding a column with a custom getter
        //For example:
        //Column Name: Years of Experience, Getter: getYearsOfExperience
        public void addColumn(String column, String property) {
            TableColumn<Object, ?> newColumn = new TableColumn<>(column);
            newColumn.setCellValueFactory(new PropertyValueFactory<>(property));
            addColumn(newColumn);
        }

        //Adding a column with a custom callback function
        //For example:
        //Column Name: Patient from AppointmentDetail Class, Getter: A callback function that references to the Object Patient and its getters
        public <S> void addColumn(String column, Callback<TableColumn.CellDataFeatures<Object, S>, ObservableValue<S>> callback) {
            TableColumn<Object, S> newColumn = new TableColumn<>(column);
            newColumn.setCellValueFactory(callback);
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


        //Resize the columns to fit the content
        public void evenWidth() {
            table.widthProperty().addListener((observable, oldValue, newValue) -> {
                double width = (newValue.doubleValue() / table.getColumns().size());
                for (Object column: table.getColumns()) {
                    ((TableColumn) column).setPrefWidth(width);
                }
            });
        }

        //Sets the table data
        public void initTableData(ObservableList data) {
            table.setItems(data);
        }

        //Adds a functional button to the bottom of the table
        public void addFunctionalButton(Button FuncButton) {
            Region spacer = new Region();
            FuncButton.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");
            HBox.setHgrow(spacer, Priority.ALWAYS);
            buttonContainer.getChildren().addAll(spacer, FuncButton);
        }

        //Returns the index of the button in the table
        //Used to select the correct row in the table
        public int getButtonIndex(ActionEvent e){
            //Get the cell that was clicked.
            //Type cast the action event to a button from the source of the called action event.
            //Type cast the button to a TableCell from the ancestor of the button.
            //Return the index of the button in the table
            TableCell<?, ?> cell = (TableCell<?, ?>) ((Button) e.getSource()).getParent().getParent();
            return cell.getIndex();
        }
}
