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

        addContentContainer("Username","Username");
        addContentContainer("Password","At least 8 characters, 1 uppercase, 1 number");
        addContentContainer("Name","Full Name");
        addContentContainer("Email","Ryan1234@gmail.com");
        addContentContainer("Phone Number","012-1118888");
        addContentContainer("Age","Age");
        addSelectionContainer("Gender", "Select Gender", new String[]{"MALE", "FEMALE"});
        addContentContainer("Years Of Experience","Years Of Experience");
        addSelectionContainer("Specialization","Select Specialization", new String[]{"Heart", "Chiropractor", "Family"});
        addSelectionContainer("Position","Select Position", new String[]{"Head", "Assistant"});

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

            register(2, username, password, name, email, phoneNumber, age, gender, yearsOfExperience, specialization, position);
        });

        addButtonContainer(register);
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
