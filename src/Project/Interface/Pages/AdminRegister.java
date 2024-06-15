package Project.Interface.Pages;

import Project.Interface.Pages.Templates.Register;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AdminRegister extends Register {

    public AdminRegister() {
        super("Register Admin");

        addContentContainer("Username","Username");
        addContentContainer("Password","At least 8 characters, 1 uppercase, 1 number");

        Button register = new Button("Register");
        register.setPrefHeight(40);
        register.setPrefWidth(100);

        register.setOnAction(e ->{
            ArrayList<String> adminData = getTextFieldsData();
            System.out.println(adminData);

            String username = adminData.get(0);
            String password = adminData.get(1);

            register(3, username, password);
        });

        addButtonContainer(register);
    }

    @Override
    public VBox getRegisterForm() {
        return super.getRegisterForm();
    }
}
