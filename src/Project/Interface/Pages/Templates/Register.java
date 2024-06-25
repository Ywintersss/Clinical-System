package Project.Interface.Pages.Templates;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.ViewAdminList;
import Project.Interface.Pages.ViewDoctorList;
import Project.Interface.Pages.ViewPatientList;
import Project.Users.Gender;
import Project.Utilities.ScreenTools;
import Project.Utilities.Utilities;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public abstract class Register {
    private VBox registerContainer;
    private ScrollPane registerScroll;
    private VBox registerForm;
    private Label registerTitle;

    private HBox contentContainer;
    private Label contentLabel;
    private TextField contentField;

    private HBox selectionContainer;
    private Label selectionLabel;
    private ComboBox<String> selectionField;

    private HBox buttonContainer;
    private Region spacer;
    private Button register;
    private Button back;

    public Register(String title, int pageFlag) {
        //pageFlag = 1 = Admin
        //pageFlag=2 = Patient
        registerForm = new VBox();
        registerForm.setSpacing(25);
        registerForm.setPadding(new Insets(10, 10, 10, 10));
        registerForm.getStylesheets().add("/Project/Interface/Assets/Styles/styles.css");

        registerTitle = new Label(title);
        registerTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
        VBox.setMargin(registerTitle, new Insets(12, 0, 0, 40));

        registerScroll = new ScrollPane();
        registerScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        registerScroll.setFitToWidth(true);
        registerScroll.setContent(registerForm);

        registerContainer = new VBox();
        registerContainer.getChildren().addAll(registerTitle, registerScroll);

        registerForm.getChildren().addAll(registerTitle);
    }

    public VBox getRegisterForm() {
        return registerContainer;
    }

    public void addContentContainer(String labelTitle,String promptText) {
        contentContainer = new HBox();
        contentContainer.setSpacing(10);
        VBox.setMargin(contentContainer, new Insets(0, 0, 0, 40));

        contentLabel = new Label(labelTitle);
        contentLabel.setPrefWidth(185);
        contentLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        contentField = new TextField();
        contentField.setPromptText(promptText);
        contentField.setPrefWidth(ScreenTools.getScreenWidth() * 0.18);

        registerForm.getChildren().add(contentContainer);
        contentContainer.getChildren().addAll(contentLabel, contentField);
    }

    public void addSelectionContainer (String labelTitle, String promptText, String[] options) {
        selectionContainer = new HBox();
        VBox.setMargin(selectionContainer, new Insets(8, 0, 0, 40));

        selectionLabel = new Label(labelTitle);
        selectionLabel.setPrefWidth(195);
        selectionLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        selectionLabel.setPadding(new Insets(10, -20, 10, 0));

        selectionField = new ComboBox<>();
        selectionField.setPromptText(promptText);
        selectionField.getItems().addAll(options);
        selectionField.setPrefWidth(ScreenTools.getScreenWidth() * 0.18);

        registerForm.getChildren().add(selectionContainer);
        selectionContainer.getChildren().addAll(selectionLabel, selectionField);
    }

    public ArrayList<String> getTextFieldsData() {
        ArrayList<String> data = new ArrayList<>();
        ObservableList<Node> children = registerForm.getChildren();
        for (int i = 1; i < registerForm.getChildren().size(); i++) {
            ObservableList<Node> content = ((HBox) children.get(i)).getChildren();
            if (content.get(1) instanceof TextField) {
                data.add(((TextField) content.get(1)).getText());
            }
            if (content.get(1) instanceof ComboBox) {
                data.add(((ComboBox) content.get(1)).getSelectionModel().getSelectedItem().toString());
            }
        }
        return data;
    }

    public void addButtonContainer(Button register){
        back = new Button("Back");
        back.setPrefHeight(40);
        back.setPrefWidth(100);
        back.setOnAction(e ->{
            ClinicalSystem.back();
        });

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttonContainer = new HBox();
        buttonContainer.setSpacing(10);
        buttonContainer.getChildren().addAll(back, spacer, register);

        registerForm.getChildren().add(buttonContainer);
    }

    public HBox getContentContainer() {
        return contentContainer;
    }

    public HBox getButtonContainer() {
        return buttonContainer;
    }

    public void register(int flag, String ...data) {
        System.out.println(data[0] + data[1]);
        //flag = 1 = Admin register patient
        //flag = 2 = addDoctor
        //flag = 3 = addAdmin
        //flag = 4 = Back to wherever to Patient came from
        try {
            boolean success = ClinicalSystem.register(flag, data);
            if (success) {
                Notification.information("Registration Successful");
                ClinicalSystem.back();
                if (flag == 1){
                    ClinicalSystem.refresh(new ViewPatientList(1).getTable());
                }else if (flag == 2){
                    ClinicalSystem.refresh(new ViewDoctorList().getTable());
                } else if (flag == 3){
                    ClinicalSystem.refresh(new ViewAdminList().getTable());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
