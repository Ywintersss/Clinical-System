package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.DetailView;
import Project.Users.Gender;
import Project.Users.User;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import Project.UserSession;
import Project.Users.Patient;
import Project.Controller.UserDataManager;

public class UserEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;
    private TextField name;
    private TextField email;
    private TextField contact;
    private TextField age;
    private TextField gender;
    private TextField height;
    private TextField weight;

	public UserEditProfile() {
        super("Edit Profile");

        Patient oldPatientData = (Patient) UserSession.getInstance().getCurrentUser();

        profileScroll = new ScrollPane();

        username = new TextField(oldPatientData.getUsername());
        password = new TextField(oldPatientData.getPassword());
        name = new TextField(oldPatientData.getName());
        email = new TextField(oldPatientData.getEmail());
        contact = new TextField(oldPatientData.getContact());
        age = new TextField(Integer.toString(oldPatientData.getAge()));
        gender = new TextField(oldPatientData.getGender().getGender());
        height = new TextField(Double.toString(oldPatientData.getHeight()));
        weight = new TextField(Double.toString(oldPatientData.getWeight()));

        addContent("Username", username);
        addContent("Password", password);
        addContent("Name", name);
        addContent("Email", email);
        addContent("Contact", contact);
        addContent("Age", age);
        addContent("Gender", gender);
        addContent("Height", height);
        addContent("Weight", weight);

        profileScroll.setContent(getContentContainer());
        profileScroll.setFitToWidth(true);
        profileScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        profileScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Button saveButton = getSaveButton(oldPatientData);
        addButtonIntoContainer(saveButton);

        getDetails().getChildren().removeAll();
        getDetails().getChildren().remove(getButtonContainer());
        getDetails().getChildren().add(profileScroll);
        getDetails().getChildren().add(getButtonContainer());
    }

    private Button getSaveButton(Patient oldPatientData) {
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                Gender genderField;

                if (gender.getText().equals("Male")) {
                    genderField = Gender.MALE;
                } else {
                    genderField = Gender.FEMALE;
                }

                oldPatientData.setUsername(username.getText());
                oldPatientData.setPassword(password.getText());
                oldPatientData.setName(name.getText());
                oldPatientData.setEmail(email.getText());
                oldPatientData.setContact(contact.getText());
                oldPatientData.setAge(Integer.parseInt(age.getText()));
                oldPatientData.setGender(genderField);
                oldPatientData.setHeight(Double.parseDouble(height.getText()));
                oldPatientData.setWeight(Double.parseDouble(weight.getText()));

                String[] newData = {oldPatientData.getID(), username.getText(), password.getText(), name.getText(), email.getText(),
                        contact.getText(), age.getText(), genderField.getGender().toUpperCase(),
                        height.getText(), weight.getText()};
                UserDataManager.updateUser("\\users\\Patient.txt", newData);

                UserSession.getInstance().setCurrentUser(oldPatientData);

                ClinicalSystem.back();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        return saveButton;
    }
    //addButtonIntoContainer();




    @Override
    public VBox getDetails() {
        return super.getDetails();
    }
}

