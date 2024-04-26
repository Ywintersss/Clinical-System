package Project.Interface;

import javax.swing.*;
import java.awt.*;

public class Home {
    public Home() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Title Panel
        JPanel titlePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel image = new JLabel("Temp");
        image.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 20, 0, 0);
        gbc.weightx = 0.1;
        titlePanel.add(image, gbc);

        JLabel title = new JLabel("Clinic Management System", JLabel.CENTER);
        title.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 0, 20);
        gbc.weightx = 0.9;
        titlePanel.add(title, gbc);

        frame.add(titlePanel, BorderLayout.NORTH);
//Main Contents
        JPanel mainContainer = new JPanel(new GridBagLayout());
        mainContainer.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));

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
        mainGbc.fill = GridBagConstraints.BOTH;
        mainContainer.add(aboutUsPanel, mainGbc);

        mainGbc.gridx = 0;
        mainGbc.gridy = 1;
        mainGbc.weightx = 0.3;
        mainGbc.weighty = 0.5;
        mainGbc.fill = GridBagConstraints.BOTH;
        mainContainer.add(doctorAppointmentsPanel, mainGbc);

        mainGbc.gridx = 1;
        mainGbc.gridy = 0;
        mainGbc.weightx = 1;
        mainGbc.weighty = 1.0;
        mainGbc.gridheight = 2;
        mainGbc.fill = GridBagConstraints.BOTH;
        mainContainer.add(SchedulesPanel, mainGbc);

        frame.add(mainContainer, BorderLayout.CENTER);

        //Footer

        JPanel footerPanel = new JPanel(new GridBagLayout());
        footerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1, true));
        GridBagConstraints footerGbc = new GridBagConstraints();

        JLabel footer = new JLabel("Footer", JLabel.CENTER);

        footerPanel.add(footer, footerGbc);

        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.pack();

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

}