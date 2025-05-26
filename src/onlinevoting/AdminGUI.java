package onlinevoting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame {

    private JButton addNomineeButton;
    private JButton removeNomineeButton;
    private JButton displayResultsButton;
    private JButton votersListButton;

    public AdminGUI() {
        // Setting up the frame
        setTitle("Election Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Creating components
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Election Manager Access");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to check username and password
                String username = JOptionPane.showInputDialog("Enter username:");
                String password = JOptionPane.showInputDialog("Enter password:");

                if (isValidLogin(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    showAdminOptions();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                }
            }
        });

        // Adding components to the main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Centered layout with spacing
        buttonPanel.add(loginButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);

        setVisible(true);
    }

    // Mock login validation - Replace with actual authentication logic
    private boolean isValidLogin(String username, String password) {
        // Replace with your actual admin credentials validation logic
        return username.equals("admin") && password.equals("password");
    }

    private void showAdminOptions() {
        // Logic to display admin options once logged in
        JPanel adminOptionsPanel = new JPanel(new GridLayout(2, 2, 20, 20)); // GridLayout with spacing

        addNomineeButton = new JButton("Add Nominee");
        customizeButton(addNomineeButton);

        removeNomineeButton = new JButton("Remove Nominee");
        customizeButton(removeNomineeButton);

        displayResultsButton = new JButton("Display Results");
        customizeButton(displayResultsButton);

        votersListButton = new JButton("Voters List");
        customizeButton(votersListButton);

        adminOptionsPanel.add(addNomineeButton);
        adminOptionsPanel.add(removeNomineeButton);
        adminOptionsPanel.add(displayResultsButton);
        adminOptionsPanel.add(votersListButton);

        getContentPane().removeAll(); // Clear previous content
        getContentPane().add(adminOptionsPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void customizeButton(JButton button) {
        button.setPreferredSize(new Dimension(150, 50)); // Set button size
        button.setBackground(Color.WHITE); // Button background color
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Button font
        button.setForeground(Color.BLACK); // Button text color
    }
}


