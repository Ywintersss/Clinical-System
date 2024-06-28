package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.DetailView;
import Project.UserSession;
import Project.Users.Doctor;
import Project.Users.Gender;
import Project.Users.Patient;
import Project.Utilities.ScreenTools;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class DoctorEditProfile extends DetailView {
    private ScrollPane profileScroll;
    private TextField username;
    private TextField password;
    private TextField name;
    private TextField email;
    private TextField contact;
    private TextField age;
    private ComboBox<String> gender;
    private TextField yearsOfExperience;
    private ComboBox<String> specialization;
    private ComboBox<String> position;
    private TextField consultationFees;

    public DoctorEditProfile(Doctor oldDoctorData, int flag) {
        super("Edit Profile");

        if (oldDoctorData == null) {
            oldDoctorData = (Doctor) UserSession.getInstance().getCurrentUser();
        }

        profileScroll = new ScrollPane();
        getButtonContainer().getStylesheets().add("/Project/Interface/Assets/Styles/Styles.css");

        username = new TextField(oldDoctorData.getUsername());
        password = new TextField(oldDoctorData.getPassword());
        name = new TextField(oldDoctorData.getName());
        email = new TextField(oldDoctorData.getEmail());
        contact = new TextField(oldDoctorData.getContact());
        age = new TextField(Integer.toString(oldDoctorData.getAge()));

        gender = new ComboBox<String>();
        gender.getItems().addAll("MALE", "FEMALE");
        gender.setValue(oldDoctorData.getGender().toString());

        yearsOfExperience = new TextField(Integer.toString(oldDoctorData.getYearsOfExperience()));

        specialization = new ComboBox<String>();
        specialization.getItems().addAll("Heart", "Chiropractor", "Family");
        specialization.setValue(oldDoctorData.getSpecialization());

        position = new ComboBox<String>();
        position.getItems().addAll("Head", "Assistant");
        position.setValue(oldDoctorData.getPosition());

        consultationFees = new TextField(Integer.toString(oldDoctorData.getConsultationFee()));

        addContent("Username", username);
        addContent("Password", password);
        addContent("Name", name);
        addContent("Email", email);
        addContent("Contact", contact);
        addContent("Age", age);
        addSelectionContainer("Gender", gender);
        addContent("Years of Experience", yearsOfExperience);
        addSelectionContainer("Specialization", specialization);
        addSelectionContainer("Position", position);
        addContent("Consultation Fees", consultationFees);

        profileScroll.setContent(getContentContainer());
        profileScroll.setFitToWidth(true);
        profileScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        profileScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Button saveButton = getSaveButton(oldDoctorData, flag);
        addButtonIntoContainer(saveButton);

        getDetails().getChildren().removeAll();
        getDetails().getChildren().add(profileScroll);
        moveButtonContainerToBottom();
    }

    private Button getSaveButton(Doctor oldDoctorData, int flag) {
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            try {
                oldDoctorData.setUsername(username.getText());
                oldDoctorData.setPassword(password.getText());
                oldDoctorData.setName(name.getText());
                oldDoctorData.setEmail(email.getText());
                oldDoctorData.setContact(contact.getText());
                oldDoctorData.setAge(Integer.parseInt(age.getText()));
                oldDoctorData.setGender(Gender.valueOf(gender.getValue()));
                oldDoctorData.setYearsOfExperience(Integer.parseInt(yearsOfExperience.getText()));
                oldDoctorData.setSpecialization(specialization.getValue());
                oldDoctorData.setPosition(position.getValue());
                oldDoctorData.setConsultationFee(Integer.parseInt(consultationFees.getText()));

                String[] newData = {oldDoctorData.getID(), username.getText(), password.getText(), name.getText(), email.getText(),
                        contact.getText(), age.getText(), gender.getValue(),
                        yearsOfExperience.getText(), specialization.getValue(), position.getValue(), consultationFees.getText()};

                try {
                    ClinicalSystem.getUserDataManager().updateUser("\\users\\Doctor.txt", newData);
                    UserSession.getInstance().setCurrentUser(oldDoctorData);

                    Notification.information("Changes saved successfully");
                } catch (Exception ex) {
                    Notification.error("Failed to save changes");
                }
                ClinicalSystem.back();

                if (flag == 1) {
                    ClinicalSystem.refresh(new ViewDoctorList().getTable());
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

