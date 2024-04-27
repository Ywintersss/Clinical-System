package Project.Interface;

import javax.swing.*;
import java.awt.*;
public class Login {
    //Login Panel
    public JPanel createLogin(boolean visibility) {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BorderLayout());

        loginPanel.setVisible(visibility);
        JLabel usernameLabel = new JLabel("Username: ");
        loginPanel.add(usernameLabel, BorderLayout.NORTH);

        return loginPanel;
    }

    public boolean getDefaultVisibility() {
        return false;
    }

    public boolean getNewVisibility(boolean visibility) {
        return !visibility;
    }



}
