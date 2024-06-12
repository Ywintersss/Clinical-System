package Project.Interface.Pages;

import Project.ClinicalSystem;
import Project.Interface.Pages.Templates.Register;
import Project.Users.Gender;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DoctorRegister extends Register {
    private ArrayList<String> doctorData = new ArrayList<>();

    public DoctorRegister() {
        super("Register Doctor");

        addContentContainer("Username");
        addContentContainer("Password");
        addContentContainer("Name");
        addContentContainer("Email");
        addContentContainer("Phone Number");
        addContentContainer("Age");
        addContentContainer("Gender");
        addContentContainer("Years Of Experience");
        addContentContainer("Specialization");
        addContentContainer("Position");

        Button register = new Button("Register");
        register.setPrefHeight(40);
        register.setPrefWidth(100);

        register.setOnAction(e ->{
            ArrayList<String> doctorData = getTextFieldsData();
            System.out.println(doctorData);

            String username = doctorData.get(0);
            String password = doctorData.get(1);
            String name = doctorData.get(2);
            String email = doctorData.get(3);
            String phoneNumber = doctorData.get(4);
            String age = doctorData.get(5);
            String gender = doctorData.get(6);
            String yearsOfExperience = doctorData.get(7);
            String specialization = doctorData.get(8);
            String position = doctorData.get(9);

            Gender genderField;
            if (gender.equalsIgnoreCase("Male")) {
                genderField = Gender.MALE;
            } else {
                genderField = Gender.FEMALE;
            }
            register(2, username, password, name, email, phoneNumber, age, genderField.getGender(), yearsOfExperience, specialization, position);
        });

        addButtonContainer(register);
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
