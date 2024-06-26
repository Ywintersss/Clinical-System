package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.DetailView;
import Project.Users.Gender;
import Project.UserSession;
import Project.Users.Patient;
import Project.Controller.UserDataManager;
import Project.Users.User;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;

import java.util.Arrays;

public class UserEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;
    private TextField name;
    private TextField email;
    private TextField contact;
    private TextField age;
    private ComboBox<String> gender;
    private TextField height;
    private TextField weight;

	public UserEditProfile(Patient oldPatientData, int flag) {
        super("Edit Profile");

        if (oldPatientData == null) {
            oldPatientData = (Patient) UserSession.getInstance().getCurrentUser();
        }

        profileScroll = new ScrollPane();

        username = new TextField(oldPatientData.getUsername());
        password = new TextField(oldPatientData.getPassword());
        name = new TextField(oldPatientData.getName());
        email = new TextField(oldPatientData.getEmail());
        contact = new TextField(oldPatientData.getContact());
        age = new TextField(Integer.toString(oldPatientData.getAge()));
        gender = new ComboBox<String>();
        gender.getItems().addAll("MALE", "FEMALE");
        gender.setValue(oldPatientData.getGender().toString());
        height = new TextField(Double.toString(oldPatientData.getHeight()));
        weight = new TextField(Double.toString(oldPatientData.getWeight()));

        addContent("Username", username);
        addContent("Password", password);
        addContent("Name", name);
        addContent("Email", email);
        addContent("Contact", contact);
        addContent("Age", age);
        addSelectionContainer("Gender", gender);
        addContent("Height", height);
        addContent("Weight", weight);

        profileScroll.setContent(getContentContainer());
        profileScroll.setFitToWidth(true);
        profileScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        profileScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Button saveButton = getSaveButton(oldPatientData, flag);
        addButtonIntoContainer(saveButton);

        getDetails().getChildren().removeAll();
        getDetails().getChildren().add(profileScroll);
        moveButtonContainerToBottom();
    }

    private Button getSaveButton(Patient oldPatientData, int flag) {
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                oldPatientData.setUsername(username.getText());
                oldPatientData.setPassword(password.getText());
                oldPatientData.setName(name.getText());
                oldPatientData.setEmail(email.getText());
                oldPatientData.setContact(contact.getText());
                oldPatientData.setAge(Integer.parseInt(age.getText()));
                oldPatientData.setGender(Gender.valueOf(gender.getValue()));
                oldPatientData.setHeight(Double.parseDouble(height.getText()));
                oldPatientData.setWeight(Double.parseDouble(weight.getText()));

                String[] newData = {oldPatientData.getID(), username.getText(), password.getText(), name.getText(), email.getText(),
                        contact.getText(), age.getText(), gender.getValue(),
                        height.getText(), weight.getText()};

                try {
                    ClinicalSystem.getUserDataManager().updateUser("\\users\\Patient.txt", newData);
                    Notification.information("Changes saved successfully");

                    //not admin
                    if (flag != 1) {
                        UserSession.getInstance().setCurrentUser(oldPatientData);
                    }

                } catch (Exception ex) {
                    Notification.error("Failed to save changes");
                }

                ClinicalSystem.back();

                if (flag == 1) {
                    ClinicalSystem.refresh(new ViewPatientList(1).getTable());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        return saveButton;
    }


    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

