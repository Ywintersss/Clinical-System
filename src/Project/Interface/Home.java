package Project.Interface;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Home {
    public Home() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(1080, 720));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane layeredPane = new JLayeredPane();
        //Instantiating the login panel.
        Login login = new Login();
        AtomicBoolean visibility = new AtomicBoolean(login.getDefaultVisibility());
        JPanel loginPanel = login.createLogin(visibility.get());

        loginPanel.setBounds(0, 0, 200, frame.getHeight());
        loginPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        layeredPane.add(loginPanel, JLayeredPane.POPUP_LAYER, 0);
        frame.add(layeredPane);

// Title Panel
        JPanel titlePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton image = new JButton("Image");
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.weightx = 0.1;

        //Event Listener to change visibility of login panel.
        image.addActionListener(e -> {
            visibility.set(login.getNewVisibility(visibility.get()));
            loginPanel.setVisible(visibility.get());
        });

        titlePanel.add(image, gbc);

        JLabel title = new JLabel("Clinic Management System", JLabel.CENTER);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 20);
        gbc.weightx = 0.9;

        titlePanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 1, true));
        titlePanel.add(title, gbc);

        frame.add(titlePanel, BorderLayout.NORTH);

//Footer
        JPanel footerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints footerGbc = new GridBagConstraints();

        JLabel footer = new JLabel("Footer", JLabel.CENTER);
        footerGbc.gridx = 0;
        footerGbc.fill = GridBagConstraints.BOTH;
        footerGbc.weighty = 0.2;
        footerPanel.add(footer, footerGbc);

        footerPanel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 1, true));
        footerPanel.setSize(frame.getWidth(), 20);

        frame.add(footerPanel, BorderLayout.SOUTH);


//Main Contents
//PROBLEM: Size of main content is not scalable, requires manual modifying due to the nature of JLayeredPane
        JPanel mainContainer = new JPanel(new GridBagLayout());
        mainContainer.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1, true));

        JPanel aboutUsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints mainGbc = new GridBagConstraints();
        aboutUsPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1, true));
        JLabel aboutUsLabel = new JLabel("lorem", JLabel.CENTER);
        aboutUsPanel.add(aboutUsLabel);

        JPanel doctorAppointmentsPanel = new JPanel(new GridBagLayout());
        doctorAppointmentsPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 1, true));
        JLabel doctorAppointmentsLabel = new JLabel("appointments (insert variable here)", JLabel.CENTER);
        doctorAppointmentsPanel.add(doctorAppointmentsLabel);

        JPanel SchedulesPanel = new JPanel(new GridBagLayout());
        SchedulesPanel.setBorder(BorderFactory.createLineBorder(Color.green, 1, true));
        JLabel SchedulesLabel = new JLabel("Schedules", JLabel.CENTER);
        SchedulesPanel.add(SchedulesLabel);

        mainGbc.gridx = 0;
        mainGbc.weightx = 0.3;
        mainGbc.weighty = 0.5;
        mainGbc.insets = new Insets(20, 20, 20, 20);
        mainGbc.fill = GridBagConstraints.BOTH;
        mainContainer.add(aboutUsPanel, mainGbc);

        mainGbc.gridx = 0;
        mainGbc.gridy = 1;
        mainGbc.weightx = 0.3;
        mainGbc.weighty = 0.5;
        mainGbc.insets = new Insets(20, 20, 20, 20);
        mainGbc.fill = GridBagConstraints.BOTH;
        mainContainer.add(doctorAppointmentsPanel, mainGbc);

        mainGbc.gridx = 1;
        mainGbc.gridy = 0;
        mainGbc.weightx = 1;
        mainGbc.weighty = 1.0;
        mainGbc.gridheight = 2;
        mainGbc.insets = new Insets(20, 20, 20, 20);
        mainGbc.fill = GridBagConstraints.BOTH;
        mainContainer.add(SchedulesPanel, mainGbc);
        //The part where the main content is added with a fixed size. Tried to make it dynamic.
        mainContainer.setBounds(0,0, frame.getWidth()-15, frame.getHeight()-80);
        layeredPane.add(mainContainer, JLayeredPane.DEFAULT_LAYER, 0);
        frame.add(layeredPane, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

}