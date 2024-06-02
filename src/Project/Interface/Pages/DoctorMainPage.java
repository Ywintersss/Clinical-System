package Project.Interface.Pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DoctorMainPage {
	private GridPane doctorMainPage;

	private VBox dailyScheduleContainer;
	private HBox titleContainer;
	private Label title;
	private FlowPane scheduleContainer;
	private Label schedulesLabel;
	private Button uploadScheduleButton;
	private Pane spacer;

	private HBox quickNavContainer;
	private Button AppointmentListButton;
	private Button AddMedicalRecordButton;
	private Button PatientMedicalRecordButton;


	public DoctorMainPage() {
		doctorMainPage = new GridPane();
		doctorMainPage.setHgap(15);
		doctorMainPage.setVgap(20);
		doctorMainPage.setPadding(new Insets(40, 10, 10, 10));
		doctorMainPage.setAlignment(Pos.TOP_CENTER);

		dailyScheduleContainer = new VBox();
		dailyScheduleContainer.setPrefHeight(300);
		dailyScheduleContainer.setPrefWidth(550);
		dailyScheduleContainer.setStyle("-fx-alignment: center;");
		dailyScheduleContainer.setSpacing(10);

		scheduleContainer = new FlowPane();
		scheduleContainer.setStyle("-fx-background-color: #FFFFFF;");
		scheduleContainer.setPadding(new Insets(10, 10, 10, 10));
		scheduleContainer.setPrefHeight(dailyScheduleContainer.getPrefHeight());
		scheduleContainer.setPrefWidth(dailyScheduleContainer.getPrefWidth());
		scheduleContainer.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		schedulesLabel = new Label("Schedules");
		schedulesLabel.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-text-alignment: center;");
		schedulesLabel.setPrefHeight(scheduleContainer.getPrefHeight());
		schedulesLabel.setPrefWidth(scheduleContainer.getPrefWidth());
		scheduleContainer.getChildren().add(schedulesLabel);

		uploadScheduleButton = new Button("Upload Schedule");
		uploadScheduleButton.setPrefWidth(95);
		uploadScheduleButton.setStyle("-fx-font-weight: bold;-fx-font-size: 10px;-fx-underline: true;-fx-text-alignment: center;");

		spacer = new Pane();
		spacer.setPrefWidth(450);

		scheduleContainer.getChildren().add(spacer);
		scheduleContainer.getChildren().add(uploadScheduleButton);

		titleContainer = new HBox();
		titleContainer.setStyle("-fx-background-color: #C0C0C0;-fx-alignment: center;");

		title = new Label("Daily Schedule");
		title.setStyle("-fx-font-weight: bold;-fx-font-size: 16px;-fx-underline: true;-fx-text-alignment: center;-fx-alignment: center;");

		titleContainer.getChildren().add(title);

		quickNavContainer = new HBox();
		quickNavContainer.setStyle("-fx-alignment: center;");
		quickNavContainer.setPrefWidth(dailyScheduleContainer.getPrefWidth());
		quickNavContainer.setSpacing(50);
		quickNavContainer.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		AppointmentListButton = new Button("Appointment List");
		AppointmentListButton.setStyle("-fx-font-weight: bold;-fx-font-size: 10px;-fx-underline: true;-fx-text-alignment: center;");
		AppointmentListButton.setPadding(new Insets(10, 10, 10, 10));

		AddMedicalRecordButton = new Button("Add Medical Record");
		AddMedicalRecordButton.setStyle("-fx-font-weight: bold;-fx-font-size: 10px;-fx-underline: true;-fx-text-alignment: center;");
		AddMedicalRecordButton.setPadding(new Insets(10, 10, 10, 10));

		PatientMedicalRecordButton = new Button("Patient Medical Record");
		PatientMedicalRecordButton.setStyle("-fx-font-weight: bold;-fx-font-size: 10px;-fx-underline: true;-fx-text-alignment: center;");
		PatientMedicalRecordButton.setPadding(new Insets(10, 10, 10, 10));

		quickNavContainer.getChildren().add(AppointmentListButton);
		quickNavContainer.getChildren().add(AddMedicalRecordButton);
		quickNavContainer.getChildren().add(PatientMedicalRecordButton);

		dailyScheduleContainer.getChildren().add(titleContainer);
		dailyScheduleContainer.getChildren().add(scheduleContainer);
		doctorMainPage.add(dailyScheduleContainer, 0, 0);
		doctorMainPage.add(quickNavContainer, 0, 1);

	}

	public GridPane getPage() {
		return doctorMainPage;
	}
}
