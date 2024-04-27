package Project.Interface;

import javax.swing.*;
import java.awt.*;
public class Login {
    //Login Panel
    public JPanel createLogin(boolean visibility) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel usernameLabel = new JLabel("Username: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 10, 10, 10);
        loginPanel.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.9;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 0, 10);
        loginPanel.add(passwordLabel, gbc);

        JTextField passwordField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.9;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        loginPanel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.weightx = 0.6;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(loginButton, gbc);

        JButton registerButton = new JButton("Register");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.4;
        gbc.insets = new Insets(10, 10, 10, 10);
        loginPanel.add(registerButton, gbc);

        loginPanel.setVisible(visibility);
        return loginPanel;
    }

    public boolean getDefaultVisibility() {
        return false;
    }

    public boolean getNewVisibility(boolean visibility) {
        return !visibility;
    }



}
