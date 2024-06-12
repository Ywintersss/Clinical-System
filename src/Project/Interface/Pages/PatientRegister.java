package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.Register;
import Project.Users.Gender;
import Project.Utilities.Utilities;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PatientRegister extends Register {

    public PatientRegister() {
        super("Register Patient");

        addContentContainer("Username");
        addContentContainer("Password");
        addContentContainer("Name");
        addContentContainer("Email");
        addContentContainer("Phone Number");
        addContentContainer("Age");
        addContentContainer("Gender");
        addContentContainer("Height");
        addContentContainer("Weight");

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

            Gender genderField;
            if (gender.equalsIgnoreCase("Male")) {
                genderField = Gender.MALE;
            } else {
                genderField = Gender.FEMALE;
            }
            register(1, username, password, name, email, phoneNumber, age, genderField.getGender(), height, weight);
        });

        addButtonContainer(register);
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}