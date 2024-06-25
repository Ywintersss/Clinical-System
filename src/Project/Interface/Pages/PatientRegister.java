package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Components.Notification;
import Project.Interface.Pages.Templates.Register;
import Project.Users.Gender;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import javax.swing.text.View;
import java.util.ArrayList;

public class PatientRegister extends Register {

    public PatientRegister(int pageFlag) {
        super("Register Patient", pageFlag);

        addContentContainer("Username","Username");
        addContentContainer("Password","At least 8 characters, 1 uppercase, 1 number");
        addContentContainer("Name","Full Name");
        addContentContainer("Email","Ryan1234@gmail.com");
        addContentContainer("Phone Number","012-1118888");
        addContentContainer("Age","Age");
        addSelectionContainer("Gender", "Select Gender", new String[]{"MALE", "FEMALE"});
        addContentContainer("Height","Height in cm");
        addContentContainer("Weight","Weight in kg");

        Button register = new Button("Register");
        register.setPrefHeight(40);
        register.setPrefWidth(100);

        register.setOnAction(e ->{
            ArrayList<String> data = getTextFieldsData();
            System.out.println(data);

            String username = data.get(0);
            String password = data.get(1);
            String name = data.get(2);
            String email = data.get(3);
            String phoneNumber = data.get(4);
            String age = data.get(5);
            String gender = data.get(6);
            String height = data.get(7);
            String weight = data.get(8);

           register(1, username, password, name, email, phoneNumber, age, gender, height, weight);

        });

        addButtonContainer(register);
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}